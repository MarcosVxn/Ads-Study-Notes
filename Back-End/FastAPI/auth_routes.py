from fastapi import APIRouter, Depends, HTTPException
from models import Usuario, db
from sqlalchemy.orm import Session
from dependencies import pegar_sessao
from main import bcrypt_context, ALGORITHM, ACCESS_TOKEN_EXPIRE_MINUTES, SECRET_KEY
from schemas import UsuarioSchema, LoginSchema
from jose import jwt, JWTError
from datetime import datetime,timedelta,timezone

auth_router = APIRouter(prefix="/auth", tags=["auth"])


# Token Temporario
def criar_token(id_usuario, duracao_token=timedelta(minutes=ACCESS_TOKEN_EXPIRE_MINUTES)):

    #esse datetime.now serve para pegar a hora que o usuario entrar e usar de acordo com o timezone UTC que é a hora padrão e o timedelta é oque importamos da main

    data_expiracao = datetime.now(timezone.utc) + duracao_token
    dic_info = {"sub": id_usuario, "exp": data_expiracao}
    jwt_codificado = jwt.encode(dic_info, SECRET_KEY, ALGORITHM)
    return jwt_codificado

def verificar_token(token, session: Session = Depends(pegar_sessao)):
    # Verificar se o token é valido
    #extrarir o id do usuario do token
    usuario = session.query(Usuario).filter(Usuario.id==1).firts()
    return

def autenticar_usuario(email, senha, session):
    usuario = session.query(Usuario).filter(Usuario.email==email).first()
    if not usuario:
        return False
    
    # no bcrypt utilizamos o verify uma função do bcrypt que verifica se a hash é a mesma que a senha do usuario como passamos no parametro

    elif not bcrypt_context.verify(senha, usuario.senha):
        return False

    # caso a função percorrer todo o if not e elif not quer dizer que deu TRUE então retornarar usuario

    return usuario


@auth_router.get("/")
async def home():
    """
    Essa é a rota padrão de autenticação do nosso sistema
    """
    return{"mensagem": "Você acessou a rota padrão de autenticação", "autenticado": False}

@auth_router.post("/criar_conta")
async def criar_conta(usuarios_sechema: UsuarioSchema, session = Depends(pegar_sessao)):
    usuario = session.query(Usuario).filter(Usuario.email==usuarios_sechema.email).first()
    if usuario:
        #ja existe um usuario com esse email
        raise HTTPException(status_code=400, detail="E-mail do usuário já cadastro")

    else:
        senha_criptografada = bcrypt_context.hash(usuarios_sechema.senha)
        novo_usuario = Usuario(usuarios_sechema.nome, usuarios_sechema.email, senha_criptografada,usuarios_sechema.ativo, usuarios_sechema.admin)
        session.add(novo_usuario)
        session.commit()
        return {"Mensagem": f"Usuário cadastro com sucesso {usuarios_sechema.email}"}

@auth_router.post("/login")
async def login(login_schema: LoginSchema, session: Session = Depends(pegar_sessao)):
    usuario = autenticar_usuario(login_schema.email, login_schema.senha, session)
    if not usuario:
        raise HTTPException(status_code=400, detail="Usuário não encontrado ou credenciais invalida")
    else:
        access_token = criar_token(usuario.id)
        refresh_token = criar_token(usuario.id, duracao_token=timedelta(days=7))
        return{
            "access_token": access_token,
            "refrash_token": refresh_token,
            "token_type": "Bearer"
        }

        # JWT Bearer

        # headers = {"Access-Token": "Bearer token"}


@auth_router.get("/refresh")
async def use_refresh_token(token):

    # verificação do token

    usuario = verificar_token(token)
    access_token = criar_token(usuario.id)
    return{
        "access_token": access_token,
        "token_type": "Bearer"
    }
    
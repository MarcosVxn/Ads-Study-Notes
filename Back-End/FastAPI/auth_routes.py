from fastapi import APIRouter, Depends, HTTPException
from models import Usuario, db
from sqlalchemy.orm import Session
from dependencies import pegar_sessao
from main import bcrypt_context
from schemas import UsuarioSchema, LoginSchema

auth_router = APIRouter(prefix="/auth", tags=["auth"])


# Token Temporario
def criar_token(id_usuario):
    token = f"XX(TW88LCof]g6h?S0uH2[KtJ{id_usuario}"
    return token


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
    usuario = session.query(Usuario).filter(Usuario.email==login_schema.email).first()
    if not usuario:
        raise HTTPException(status_code=400, detail="Usuário não encontrado")
    else:
        access_token = criar_token(usuario.id)
        return{
            "access_token": access_token,
            "token_type": "Bearer"
        }

        # JWT Bearer

        # headers = {"Access-Token": "Bearer token"}
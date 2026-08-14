from sqlalchemy import create_engine, Column, String, Boolean, Integer, Float, ForeignKey
from sqlalchemy.orm import declarative_base
from sqlalchemy_utils.types import ChoiceType


# Aqui criamos a conexão de comunicação com o banco de dados pelo python
db = create_engine("sqlite:///data/banco.db")

# Aqui é a classe base do SQLAlchemy que rastreia e mapeia todas as tabelas criadas pelo python
Base = declarative_base()

# Criar as classes de modelo: Criar as classes correspondentes a cada tabela herdando da classe base

# Usuario
class Usuario(Base):
    __tablename__ = "usuarios"

    id = Column("id", Integer, primary_key= True, autoincrement=True)
    nome = Column("nome", String)
    email = Column("email", String)
    senha = Column("senha", String, nullable=False)
    ativo = Column("ativo", Boolean)
    admin = Column("admin", Boolean, default=False)

    def __init__(self, nome, email, senha, ativo=True, admin=False):
        self.nome = nome
        self.email = email
        self.senha = senha
        self.ativo = ativo
        self.admin = admin

# Pedidos
class Pedido(Base):
    __tablename__ = "pedidos"

    STATUS_PEDIDOS = (
        ("PENDENTE", "PENDENTE"),
        ("CANCELADO", "CANCELADO"),
        ("FINALIZADO", "FINALIZADO")
    )
    
    id = Column("id", Integer, primary_key= True, autoincrement=True)
    status = Column ("status", ChoiceType(choices=STATUS_PEDIDOS)) # pendente, cancelado, finalizado
    usuario = Column ("usuario", ForeignKey("usuarios.id"))
    preco = Column ("preco", Float)
    # itens =

    def __init__(self, usuario, status="PENDENTE", preco=0):
        self.usuario = usuario
        self.preco = preco
        self.status = status

# ItemPedido
class ItemPedido(Base):
    __tablename__ = "itens_pedido"

    id = Column("id", Integer, primary_key= True, autoincrement=True)
    quantidade = Column("quantidade", Integer)
    sabor = Column("sabor", String)
    tamanho = Column("tamanho", String)
    preco_unitario = Column("preco_unitario", Float)
    pedido = Column("pedido", ForeignKey("pedidos.id"))

    def __init__(self, quantidade, sabor, tamanho, preco_unitario, pedido):
        self.quantidade = quantidade
        self.sabor = sabor
        self.tamanho = tamanho
        self.preco_unitario = preco_unitario
        self.pedido = pedido

# Criar o banco fisicamente: Executar o comando para gerar as tabelas no arquivo do banco de dados 


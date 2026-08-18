from models import db
from sqlalchemy.orm import sessionmaker

def pegar_sessao():
    # O try tenta executar o código dentro dele.
    try:
        Session = sessionmaker(bind=db)
        session = Session()

        # vai retornar a respota sem encerrar a execução da função
        yield session
    # O finally vai sempre ser executado indepentente da resposta que o try der
    finally:
        session.close
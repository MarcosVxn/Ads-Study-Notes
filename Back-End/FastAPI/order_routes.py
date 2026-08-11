from fastapi import APIRouter

order_router = APIRouter(prefix="/pedidos", tags=["pedidos"])

# O @ define o método HTTP e o caminho da rota. Neste caso, quando houver uma requisição GET em /lista, a função abaixo será executada.
#Função Assíncrona (async): Permite que o servidor não fique travado esperando o processamento de uma rota demorada

@order_router.get("/")
async def pedidos():
    """
    Essa é a rota padrão de pedidos do nosso sistema. Todas as rotas dos pedidos precisam de autenticação
    """
    return {"mensagem": "Você acessou a rota de pedidos"}

#na função eu posso fazer a logica que eu quiser ela vai ser sempre executada quando eu estiver nessa rota e for feita uma requisição
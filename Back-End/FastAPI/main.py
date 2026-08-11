from fastapi import FastAPI

app = FastAPI()

from auth_routes import auth_router
from order_routes import order_router

app.include_router(auth_router)
app.include_router(order_router)

# O código acima registra as rotas externas na aplicação principal (app).

# Para rodar o código, executar no terminal: uvicorn main:app --reload
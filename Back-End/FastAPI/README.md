# 🍕 Pizzaria API

> ⚠️ **Status:** Em desenvolvimento  
> Projeto desenvolvido durante meus estudos de **Back-End com Python e FastAPI**, acompanhando o curso de **FastAPI da Hashtag Programação**.  
> **Aula 06/10 concluída — Indo para a Aula 07/10**

---

## 📚 Sobre o Projeto

Este projeto consiste no desenvolvimento do **Back-End de uma API REST para uma pizzaria**, criada com **Python e FastAPI**.

O projeto está sendo desenvolvido como parte dos meus estudos de **Back-End com Python e FastAPI**, acompanhando o curso de **FastAPI da Hashtag Programação**.

O objetivo principal é colocar em prática os conceitos apresentados durante as aulas, trabalhando com criação de APIs, organização de rotas, banco de dados, modelagem com ORM, migrations, dependências e autenticação.

A documentação deste repositório representa o estado atual do projeto durante o curso e será atualizada conforme o avanço das aulas.

---

## 🛠️ Tecnologias & Ferramentas

### Linguagem e Framework

- **Python** — linguagem utilizada no desenvolvimento da aplicação.
- **FastAPI** — framework utilizado para construção da API.
- **Uvicorn** — servidor utilizado para executar a aplicação.

### Banco de Dados

- **SQLite** — banco de dados utilizado no desenvolvimento local.
- **SQLAlchemy** — ORM utilizado para mapear e trabalhar com as tabelas do banco.
- **Alembic** — utilizado para criação e gerenciamento das migrations.

### Bibliotecas

- **Passlib + Bcrypt** — utilizado para realizar o hashing e a verificação das senhas.
- **Python-dotenv** — utilizado para gerenciamento de variáveis de ambiente.
- **Python-multipart** — suporte para processamento de dados enviados por formulários.
- **Python-Jose** — utilizado no trabalho com tokens JWT.

### Ferramentas

- **Visual Studio Code**
- **Git**
- **GitHub**

---

## 📁 Estrutura do Projeto

A estrutura atual do projeto está organizada desta forma:

```text
FastAPI/

│
├── alembic/
│   ├── versions/
│   │   └── 16e8ab904b9f_initial_migration.py
│   ├── env.py
│   ├── README
│   └── script.py.mako
│
├── data/
│   └── banco.db
│
├── .gitignore
├── alembic.ini
├── auth_routes.py
├── dependencies.py
├── main.py
├── models.py
├── order_routes.py
└── schemas.py
```

### Organização dos arquivos

**`main.py`**

Arquivo principal responsável pela inicialização da aplicação FastAPI e pelo registro das rotas.

**`auth_routes.py`**

Contém as rotas relacionadas à autenticação e usuários.

Durante o desenvolvimento do projeto, este arquivo passou a concentrar também partes relacionadas ao processo de login e autenticação utilizando tokens.

**`order_routes.py`**

Contém as rotas relacionadas aos pedidos.

**`models.py`**

Define os modelos utilizados pelo SQLAlchemy para representar as tabelas do banco.

**`schemas.py`**

Contém os schemas utilizados para estruturar os dados recebidos pela API.

**`dependencies.py`**

Responsável pelas dependências utilizadas pela aplicação, incluindo o gerenciamento da sessão do banco de dados.

**`alembic/`**

Diretório responsável pelo gerenciamento e histórico das migrations.

**`data/`**

Diretório utilizado para armazenar o banco SQLite durante o desenvolvimento local.

---

## 🚀 Funcionalidades Implementadas

### ✅ Aula 04/10

- [x] Configuração da aplicação FastAPI.
- [x] Execução da aplicação utilizando Uvicorn.
- [x] Organização das rotas utilizando `APIRouter`.
- [x] Conexão com banco de dados SQLite.
- [x] Integração do SQLAlchemy com a aplicação.
- [x] Criação dos modelos do banco.
- [x] Configuração do Alembic.
- [x] Criação e aplicação da migration inicial.
- [x] Configuração de dependências para acesso à sessão do banco.
- [x] Cadastro de usuários.
- [x] Hashing das senhas com `Passlib` e `Bcrypt`.
- [x] Estrutura inicial das rotas de autenticação.
- [x] Estrutura inicial das rotas de pedidos.
- [x] Configuração de variáveis de ambiente através de `.env`.
- [x] Documentação automática da API através do Swagger/OpenAPI.

### ✅ Aula 05/10

- [x] Criação de schemas para estruturar os dados recebidos pela API.
- [x] Criação do `LoginSchema`.
- [x] Implementação da rota `POST /auth/login`.
- [x] Busca do usuário pelo e-mail durante o login.
- [x] Tratamento de erro utilizando `HTTPException`.
- [x] Criação de uma função para geração temporária de token.
- [x] Retorno de `access_token` na resposta do login.
- [x] Estruturação do tipo de token como `Bearer`.
- [x] Continuação da estruturação do fluxo de autenticação.

### ✅ Aula 06/10

- [x] Verificação das credenciais do usuário utilizando `verify` do Bcrypt.
- [x] Validação da senha informada no login contra o hash armazenado no banco.
- [x] Introdução ao conceito de **JWT (JSON Web Token)**.
- [x] Estruturação de JWT em Header, Payload e Signature.
- [x] Utilização de uma `SECRET_KEY` para assinatura do token.
- [x] Utilização do algoritmo de assinatura, como `HS256`.
- [x] Utilização da informação `sub` para identificar o usuário no token.
- [x] Utilização da informação `exp` para definir a expiração do token.
- [x] Estudo sobre **Access Token** e **Refresh Token**.
- [x] Estudo sobre diferentes tempos de duração para Access Token e Refresh Token.
- [x] Estudo da rota `/auth/refresh`.
- [x] Aplicação correta do `Depends()` na assinatura de uma rota.
- [x] Estudo do `OAuth2PasswordBearer`.
- [x] Continuação da estruturação do processo de autenticação com tokens.

> ⚠️ **Observação:** os itens acima representam os conceitos e implementações trabalhados durante a Aula 06 conforme o material de estudo. O projeto continua em desenvolvimento e o fluxo de autenticação poderá ser aprimorado nas próximas aulas.

---

## 🗄️ Banco de Dados

O projeto utiliza **SQLite** durante o desenvolvimento.

O banco é armazenado localmente em:

```text
data/banco.db
```

A comunicação entre a aplicação e o banco é realizada utilizando **SQLAlchemy**.

Exemplo de configuração utilizada no projeto:

```python
from sqlalchemy import create_engine

db = create_engine("sqlite:///data/banco.db")
```

A classe base utilizada para os modelos é criada através do SQLAlchemy:

```python
from sqlalchemy.orm import declarative_base

Base = declarative_base()
```

---

## 🔄 Migrations

O projeto utiliza **Alembic** para controlar as alterações realizadas na estrutura do banco de dados.

A migration inicial foi criada e aplicada ao banco para gerar as estruturas necessárias.

As migrations ficam armazenadas em:

```text
alembic/

└── versions/
```

Comandos utilizados durante o desenvolvimento:

```bash
alembic revision --autogenerate -m "nome-da-migration"
```

```bash
alembic upgrade head
```

---

## 🧩 Models

Os modelos atuais são definidos em `models.py`.

### 👤 User

Tabela responsável pelo armazenamento dos usuários.

Principais campos:

- `id` — chave primária.
- `username` — nome do usuário.
- `email` — e-mail do usuário.
- `password` — senha armazenada em formato de hash.
- `is_staff` — indica privilégios administrativos.
- `is_active` — indica se o usuário está ativo.

### 🍕 Order

Tabela responsável pelos pedidos.

Principais campos:

- `id` — chave primária.
- `quantity` — quantidade de itens do pedido.
- `order_status` — status do pedido.
- `pizza_size` — tamanho da pizza.
- `user_id` — chave estrangeira relacionada ao usuário.

---

## 🌐 Rotas da API

### 🔐 Autenticação

#### `POST /auth/criar_conta`

Realiza o cadastro de um novo usuário.

Os dados recebidos incluem:

- E-mail
- Senha
- Nome

Antes de ser armazenada, a senha passa pelo processo de **hashing**.

#### `GET /auth/`

Rota inicial utilizada para verificar o módulo de autenticação.

#### `POST /auth/login`

Realiza o processo de login do usuário através do e-mail informado.

A API busca o usuário cadastrado pelo e-mail e verifica se a senha informada corresponde ao hash armazenado no banco.

Quando as credenciais são válidas, é gerado um token de acesso.

A resposta possui a estrutura:

```json
{
    "access_token": "token",
    "token_type": "Bearer"
}
```

#### `GET /auth/refresh`

Rota estudada durante a Aula 06 para trabalhar com a renovação do acesso utilizando o fluxo de **Refresh Token**.

A implementação envolve a validação do token e o acesso à sessão do banco através de dependência do FastAPI.

> ⚠️ **Observação:** o mecanismo de autenticação continua sendo desenvolvido durante o curso.

---

### 🍕 Pedidos

#### `GET /orders/`

Rota inicial utilizada para verificar o módulo de pedidos.

> Novas rotas e funcionalidades serão adicionadas conforme o avanço das aulas.

---

## 🔐 Autenticação

A partir das aulas de autenticação, o projeto passou a trabalhar com conceitos utilizados em aplicações reais para controlar o acesso aos recursos da API.

### Hashing de senhas

As senhas dos usuários não devem ser armazenadas diretamente em texto puro no banco.

Durante o cadastro, a senha é transformada em um **hash utilizando Bcrypt**.

No login, a senha informada pelo usuário é comparada com o hash armazenado utilizando a função `verify`.

O Bcrypt não descriptografa a senha armazenada. A comparação é realizada através do próprio algoritmo de hash.

### JWT

O **JSON Web Token (JWT)** é utilizado como uma credencial que pode ser enviada pelo cliente para comprovar sua autenticação.

Um JWT possui três partes principais:

```text
Header.Payload.Signature
```

- **Header** — informações sobre o tipo do token e algoritmo utilizado.
- **Payload** — informações carregadas pelo token, como o identificador do usuário e sua expiração.
- **Signature** — assinatura utilizada para verificar a integridade do token.

O payload trabalhado no projeto utiliza informações como:

```json
{
    "sub": "id_do_usuario",
    "exp": "data_de_expiracao"
}
```

> ⚠️ O payload de um JWT pode ser lido. Por isso, informações confidenciais, como senhas e chaves secretas, não devem ser armazenadas nele.

### SECRET_KEY

A `SECRET_KEY` é utilizada pelo servidor para assinar o JWT.

A assinatura permite verificar se o token foi alterado depois de ser criado.

A chave secreta deve permanecer protegida e não deve ser publicada no repositório.

### Access Token

O **Access Token** é o token utilizado para autorizar o acesso às rotas protegidas.

Ele possui duração curta, reduzindo o período de validade de uma credencial caso ela seja comprometida.

### Refresh Token

O **Refresh Token** possui uma duração maior e é utilizado para solicitar um novo Access Token quando o anterior expira.

Dessa forma, o usuário não precisa realizar novamente o login a cada expiração do Access Token.

---

## 🧩 Dependências do FastAPI

Durante a Aula 06 também foi trabalhado o funcionamento do `Depends()`.

O `Depends()` é utilizado pelo FastAPI para declarar dependências que devem ser resolvidas pelo framework.

Um exemplo utilizado no fluxo do projeto é a obtenção da sessão do banco:

```python
@auth_router.get("/refresh")
async def atualizar_sessao_token(
    token_enviado: str,
    session: Session = Depends(pegar_sessao)
):
    ...
```

Nesse caso, o FastAPI fornece a sessão para a função da rota.

Um ponto importante estudado foi que não devemos tentar executar `Depends()` manualmente dentro de uma função utilitária comum esperando receber diretamente o resultado da dependência.

A dependência deve ser declarada de forma que o FastAPI consiga resolvê-la durante o processamento da requisição.

---

## 🔑 OAuth2PasswordBearer

O FastAPI possui ferramentas específicas para trabalhar com autenticação.

Uma delas é o `OAuth2PasswordBearer`, utilizado para informar ao framework que uma rota trabalha com um token de autenticação enviado através do cabeçalho HTTP.

Esse mecanismo também está relacionado à documentação automática do Swagger/OpenAPI e ao botão de autorização disponível na interface.

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

Entre na pasta:

```bash
cd <PASTA_DO_PROJETO>
```

### 2. Crie o ambiente virtual

No Windows:

```bash
python -m venv venv
```

Ative o ambiente:

```bash
venv\Scripts\activate
```

### 3. Instale as dependências

```bash
pip install fastapi uvicorn sqlalchemy alembic passlib[bcrypt] python-dotenv python-multipart python-jose
```

### 4. Execute a aplicação

```bash
uvicorn main:app --reload
```

### 5. Acesse a API

Aplicação:

```text
http://127.0.0.1:8000
```

Documentação interativa:

```text
http://127.0.0.1:8000/docs
```

---

## 📖 O que estou aprendendo

Este projeto está sendo utilizado para praticar conceitos de desenvolvimento Back-End, incluindo:

- Construção de APIs REST com **FastAPI**.
- Organização de rotas com `APIRouter`.
- Utilização de dependências.
- Integração entre Python e banco de dados.
- Modelagem de tabelas com **SQLAlchemy**.
- Gerenciamento de migrations com **Alembic**.
- Persistência de dados utilizando **SQLite**.
- Criação e utilização de **Schemas**.
- Estruturação e validação dos dados recebidos pela API.
- Hashing de senhas.
- Verificação de senhas com Bcrypt.
- Estruturação de processos de autenticação.
- Implementação de login.
- Conceito de tokens de acesso.
- Conceito de **JWT**.
- Estrutura de Header, Payload e Signature.
- Utilização de `SECRET_KEY`.
- Conceito de `sub` e `exp` em JWT.
- Diferença entre Access Token e Refresh Token.
- Renovação de tokens.
- Utilização do `Depends()`.
- Utilização do `OAuth2PasswordBearer`.
- Tratamento de erros HTTP com `HTTPException`.
- Configuração de variáveis de ambiente.
- Organização de projetos Back-End.
- Documentação automática de APIs.

---

## 🎓 Aplicação dos Estudos

Este projeto também faz parte da minha preparação para um **próximo projeto do SENAI**.

Os conhecimentos desenvolvidos ao longo deste estudo estão sendo utilizados como base para aplicar conceitos de **Back-End, APIs, banco de dados, autenticação e organização de sistemas** em um novo projeto acadêmico.

---

## 🎯 Próximos Passos

O projeto ainda está em desenvolvimento.

As seis primeiras aulas do curso já foram concluídas. O próximo objetivo é avançar para a **Aula 07/10**, continuando a implementação e aprofundando os conhecimentos em desenvolvimento de APIs com FastAPI.

> 📌 **Progresso atual:** Aula 06 / 10

> ✅ **Aula 06 concluída**

> 🚀 **Indo para a Aula 07 / 10**

---

## 👨‍💻 Autor

**Marcos**

Estudante de **Análise e Desenvolvimento de Sistemas**

[![GitHub](https://img.shields.io/badge/GitHub-MarcosVxn-000000?style=flat&logo=github&logoColor=7A1FFF)](https://github.com/MarcosVxn)

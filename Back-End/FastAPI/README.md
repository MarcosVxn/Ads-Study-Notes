# 🍕 Pizzaria API

> ⚠️ **Status:** Em desenvolvimento  
> Projeto desenvolvido durante meus estudos de **Back-End com Python e FastAPI**, acompanhando o curso de **FastAPI da Hashtag Programação**.  
> **Aula 05/10 concluída — Indo para a Aula 06/10**

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

- **Passlib + Bcrypt** — utilizado para realizar o hashing das senhas.
- **Python-dotenv** — utilizado para gerenciamento de variáveis de ambiente.
- **Python-multipart** — suporte para processamento de dados enviados por formulários.

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

A API busca o usuário cadastrado pelo e-mail. Caso o usuário não seja encontrado, uma exceção HTTP é retornada.

Quando o usuário é encontrado, é gerado um **token temporário de acesso**.

A resposta possui a estrutura:

```json
{
    "access_token": "token",
    "token_type": "Bearer"
}
```

> ⚠️ **Observação:** o token utilizado atualmente é temporário e faz parte da implementação desenvolvida durante os estudos. O mecanismo definitivo de autenticação será desenvolvido conforme o avanço do projeto.

---

### 🍕 Pedidos

#### `GET /orders/`

Rota inicial utilizada para verificar o módulo de pedidos.

> Novas rotas e funcionalidades serão adicionadas conforme o avanço das aulas.

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
pip install fastapi uvicorn sqlalchemy alembic passlib[bcrypt] python-dotenv python-multipart
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
- Estruturação de processos de autenticação.
- Implementação de login.
- Conceito de tokens de acesso.
- Conceito de `Bearer`.
- Tratamento de erros HTTP com `HTTPException`.
- Configuração de variáveis de ambiente.
- Organização de projetos Back-End.
- Documentação automática de APIs.

---

## 🎓 Aplicação dos Estudos

Este projeto também faz parte da minha preparação para um **próximo projeto do SENAI**.

Os conhecimentos desenvolvidos ao longo deste estudo estão sendo utilizados como base para aplicar conceitos de **Back-End, APIs, banco de dados e organização de sistemas** em um novo projeto acadêmico.

---

## 🎯 Próximos Passos

O projeto ainda está em desenvolvimento.

As cinco primeiras aulas do curso já foram concluídas. O próximo objetivo é avançar para a **Aula 06/10**, continuando a implementação e aprofundando os conhecimentos em desenvolvimento de APIs com FastAPI.

> 📌 **Progresso atual:** Aula 05 / 10

> ✅ **Aula 05 concluída**

> 🚀 **Indo para a Aula 06 / 10**

---

## 👨‍💻 Autor

**Marcos**

Estudante de **Análise e Desenvolvimento de Sistemas**

[![GitHub](https://img.shields.io/badge/GitHub-MarcosVxn-000000?style=flat&logo=github&logoColor=7A1FFF)](https://github.com/MarcosVxn)

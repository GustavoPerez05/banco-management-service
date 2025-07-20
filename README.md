# banco-management-service

## 📌 Progresso do Projeto

### 🗓️ Dia 1 — Setup do Projeto (19/07/2025)
- Leitura completa do enunciado e alinhamento da estratégia com apoio da IA.
- Decisão pela utilização de:
  - Banco de dados **H2** (simples, leve e inline com o escopo do desafio)
  - **Clean Architecture** como padrão de organização de código
  - Gerenciador de dependências **Maven**
  - Containerização via **Docker**
  - Estrutura de pastas com separação clara entre `domain`, `application`, `adapters`, `infrastructure`, `config`
- Criação e estruturação do repositório no GitHub.
- Configuração de arquivos base:
  - `.gitignore`
  - `README.md`
  - `AI_USAGE.md`
  - `Dockerfile`
  - `docker-compose.yml`
- Configuração do projeto pelo Spring Initializr, com as dependências:
  - Spring Web, Data JPA, Validation, H2
  - Springdoc OpenAPI (adicionada manualmente)
- Build inicial rodado com sucesso usando Maven Wrapper.
- Commit inicial realizado com a mensagem:
  - `feat: estrutura inicial gerada com ajuda da IA`

---

### 🗓️ Dia 2 — Desenvolvimento da API + Testes + Docker (20/07/2025)
- Implementação do **EmployeeController** com os endpoints:
  - `GET /employees`
  - `POST /employees`
  - `DELETE /employees/{id}`
- Criação da classe de domínio `Employee` com os atributos `id`, `name`, `email` e `department`.
- Utilização do banco **H2** em memória para testes locais via Swagger UI.
- Testes manuais realizados com sucesso pelo Swagger:
  - Inserção de dados via `POST`
  - Consulta geral via `GET`
  - Exclusão via `DELETE`
- Observação: IDs seguem autoincremento, mesmo após deleções — comportamento aceito como ideal para este desafio.
- Implementação dos **testes unitários** com:
  - `JUnit 5` para estruturação de testes
  - `Mockito` para simulação de repositórios
- Correção do erro de reconhecimento das bibliotecas de teste:
  - Movido `EmployeeServiceTest` para o diretório correto `src/test/java`
- Verificação de sucesso dos testes com:
  - `./mvnw test`
  - Todos os testes passaram (`BUILD SUCCESS`)
- Instalação e configuração do **Docker Desktop** no Windows:
  - Uso do `WSL 2` (em vez do Hyper-V) como ambiente de virtualização
- Criação da imagem Docker com o comando:
  - `docker build -t banco-management-service .`
- Execução do container local com:
  - `docker run -p 8080:8080 banco-management-service`
  - Verificação do Swagger em `http://localhost:8080/swagger-ui.html`
- Configuração do **docker-compose.yml** para facilitar a orquestração futura.
- Commit do dia realizado com a mensagem:
  - `feat: crud + testes unitários + docker configurado com sucesso`

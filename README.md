### ***⚙️ Instruções para Execução Local (Método Maven)***

### 📦 Pré-requisitos:
- Java 17 ou superior
- Maven 3.8+
- Git instalado

### ▶️ **1º Passo:** Compilação do Projeto

```bash
./mvnw clean package
```

### 🚀 **2º Passo:** Execução da API 
```bash
./mvnw spring-boot:run
```

### 🌐 **3º Passo:** Local de Acesso a API  
```bash
http://localhost:8080/swagger-ui/index.html
```
---
### ***🐳 Instruções para Execução via Docker***

### 📦 Pré-requisitos:
- **Docker instalado**  
  - Versão recomendada: Docker Engine 20.10+  
  - Site oficial: [https://www.docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop)

- **Permissão para executar comandos Docker**  
  - No Windows: use o Docker Desktop com WSL 2 habilitado  
  - No Linux/macOS: o usuário deve estar no grupo `docker` ou usar `sudo` nos comandos

- **Porta 8080 disponível** no host  
  - A aplicação será exposta em `http://localhost:8080`

### ▶️ **1º Passo:** Build da Imagem (Compilação)

```bash
docker build -t banco-management-service .
```

### 🚀 2º Passo: Execução do Container
```bash
docker run -p 8080:8080 banco-management-service
```

### 🌐 3º Passo: Local de Acesso a API  
```bash
http://localhost:8080/swagger-ui/index.html
```
---
### 🧪 ***Como Rodar os Testes***

Para rodar os testes unitários com `JUnit 5` e `Mockito`, utilize o seguinte comando a partir da raiz do projeto:

```bash
./mvnw test
```
### ✅ Resultado Esperado:
```bash
BUILD SUCCESS
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
```
### 🧩 Cobertura de Testes
**Os testes implementados cobrem os principais fluxos da classe EmployeeService:**

- `Salvar funcionário`

- `Listar todos os funcionários`

- `Atualizar funcionário com ID existente`

- `Tentar atualizar funcionário inexistente (erro)`

- `Remover funcionário por ID`

***Todos os testes foram validados com sucesso e não requerem banco de dados externo (Uso do H2 BD).***

---
### 📬 Exemplos de Chamadas à API (via `curl`)

### 📩 Criar um novo funcionário (POST)

```bash
curl -X POST http://localhost:8080/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "Gustavo Perez",
  "email": "gustavo@banco.com.br",
  "department": "Tecnologia"
}'
```
### 🔍 Listar todos os funcionários (GET)

```bash 
curl -X GET http://localhost:8080/employees
```
### 🔎 Buscar funcionário por ID (GET)
```bash 
curl -X GET http://localhost:8080/employees/1
```
### 📝Atualizar um funcionário 📩
```bash 
curl -X PUT http://localhost:8080/employees/1 \
-H "Content-Type: application/json" \
-d '{
  "name": "Gustavo Perez Atualizado",
  "email": "joao@empresa.com",
  "department": "Arquitetura de Dados"
}'
```
### 🗑️ Remover um funcionário (DELETE)
```bash
curl -X DELETE http://localhost:8080/employees/1
```
### ✅ Code 200/201 (Sucesso em Ação)
***Resposta Esperada Após Qualquer Ação Correta (Exemplo):***

```bash
{
  "id": 1, 
  "name": "Gustavo Perez",
  "email": "gustavo@banco.com.br",
  "department": "Arquitetura de Dados"
}
```
### ⚠️ Erro 404 (ID inexistente)
```bash
curl -X GET http://localhost:8080/employees/999
```
***Resposta Esperada:***
```bash
{
  "error": "Employee with ID 999 not found"
}
```

### 💥 Erro 400 (Tipagem Inválida)
```bash
curl -X 'POST' \
  'http://localhost:8080/employees' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "string",
  "email": "string",
  "department": "string"
}'
```
***Resposta Esperada:***
```bash
{
  "timestamp": "2025-07-24T05:07:55.164+00:00",
  "status": 400,
  "error": "Bad Request",
  "path": "/employees"
}
```
---
### 📌 ***Progresso do Projeto***

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
```bash
"feat: estrutura inicial gerada com ajuda da IA"
  ```

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
```bash
"feat: crud + testes unitários + docker configurado com sucesso"
```

---

### 🗓️ Dia 3 — Melhorias nos Endpoints + Docker + DTOs + Testes (21/07/2025)
- Implementação do endpoint `GET /employees/{id}`, com retorno 404 para ID inexistente.
- Criação e validação do endpoint `PUT /employees/{id}` para atualização de dados.
- Validação do endpoint `DELETE /employees/{id}` com tratamento para casos inexistentes.
- Refatoração da estrutura para adoção de **DTOs (Data Transfer Objects)**:
  - Criação dos arquivos `CreateEmployeeRequest` e `UpdateEmployeeRequest`
  - Adaptação do `EmployeeController` para uso dos DTOs, removendo a exposição do campo `id` no Swagger
- Novos testes unitários criados e centralizados para o `EmployeeService`
- Verificações via Docker para garantir:
  - Execução completa da aplicação
  - Swagger funcionando com todos os endpoints esperados
  - Testes de CRUD finalizados com sucesso no ambiente isolado
- Commit final do dia realizado com a mensagem:
```bash
"feat: endpoints PUT/GET por ID + DTOs aplicados + testes únitarios centralizados"
```

---

### 🗓️ Dia 4 — Tratamento de Erros Amigáveis + Docker Estável (22/07/2025)
- Revisão completa da arquitetura REST e dos retornos HTTP.
- Implementação das exceções customizadas:
  - `ResourceNotFoundException`
  - `BadRequestException`
- Remoção do uso de `@ControllerAdvice` e `GlobalExceptionHandler` devido a conflitos com o Swagger.
- Adoção de uma nova estratégia para tratamento de erros:
  - Mensagens amigáveis retornadas diretamente nos métodos dos endpoints
  - Padrão adotado: `{ "error": "mensagem descritiva" }`
- Adaptação de todos os endpoints que podem retornar erro:
  - `GET /employees/{id}`
  - `PUT /employees/{id}`
  - `DELETE /employees/{id}`
- Verificação e ajuste do `EmployeeService` para lançar exceções customizadas sempre que necessário.
- Garantia de compatibilidade com o Swagger UI sem comprometer os retornos RESTful.
- Testes realizados via Swagger simulando erros:
  - Erro 400: envio de dados inválidos via `POST`
  - Erro 404: consulta ou exclusão com ID inexistente
  - Exemplo de retorno testado: `GET /employees/999` → `{ "error": "Employee with ID 999 not found" }`
- Validação da execução via Docker com os comandos:
  - `docker build -t banco-management-service .`
  - `docker run -p 8080:8080 banco-management-service`
- Abertura da documentação Swagger pela URL:
  - `http://localhost:8080/swagger-ui/index.html`
- Feedback positivo recebido de colega que já atua no Banco, destacando a clareza e consistência das mensagens de erro.
- Commit final do dia realizado com a mensagem:
```bash
"feat: tratamento de erros com mensagens amigáveis + exceções customizadas aplicadas nos endpoints"
```
---
### 🗓️ Dia 5 — Encerramento do Projeto + Validação Final (23/07/2025)
- Retomada do projeto para execução de testes finais e revisão completa da entrega.
- Testes manuais realizados com sucesso para todos os endpoints (`GET`, `POST`, `PUT`, `DELETE`) e seus respectivos fluxos de erro:
  - `400 Bad Request` com validações de campos obrigatórios e formatos incorretos
  - `404 Not Found` ao consultar, atualizar ou excluir funcionários inexistentes
- Verificação do comportamento do Swagger UI:
  - Campos apresentados corretamente
  - Documentação acessível e navegável em `http://localhost:8080/swagger-ui/index.html`
- Docker testado com sucesso:
  - Build e execução funcionais utilizando `docker build` e `docker run`
  - API acessível normalmente via container
- Testes unitários atualizados e executados com sucesso:
  - Total de 5 testes criados para a classe `EmployeeServiceTest`
  - Cobertura de:
    - Salvamento de funcionário
    - Listagem geral
    - Atualização (ID válido e inválido)
    - Exclusão
  - Utilização de `JUnit 5` e `Mockito`, sem dependência de ambiente externo
- Decisão consciente de não utilizar `Jacoco`, por já possuir cobertura sólida e validada nos testes unitários
- Projeto considerado **100% funcional, testado e pronto para entrega**
- Commit final do projeto realizado com a mensagem:
```bash
"git commit -m "test: validação e complementação final dos testes unitários do EmployeeService + Encerramento" "
  ```
---

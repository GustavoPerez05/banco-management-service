
## 🤖 Registro de Apoio de Inteligência Artificial (ChatGPT)

Este documento tem como objetivo descrever **como** e **em quais momentos** a inteligência artificial foi utilizada durante o desenvolvimento do projeto, garantindo total transparência, alinhamento com boas práticas e ética no uso de ferramentas de apoio.

---

### 📆 Dia 1 — Setup do Projeto (19/07/2025)

- **Leitura e planejamento inicial do desafio**:
  - ChatGPT auxiliou na compreensão geral do PDF do desafio.
  - Sugestão de tecnologias adequadas ao escopo e stack (H2, Clean Architecture, Docker, Maven).
- **Estruturação do repositório**:
  - Organização de pastas com base na Clean Architecture.
  - Criação e configuração de arquivos essenciais (`README.md`, `.gitignore`, `Dockerfile`, `docker-compose.yml`).
- **Geração do projeto Spring**:
  - Suporte na escolha das dependências e correção da ausência do Springdoc OpenAPI no Initializr.
- **Maven e Git**:
  - Suporte na utilização do `./mvnw`, permissões no Linux, e comandos `git init`, `add`, `commit`, `push`.
- **Commit inicial gerado com sugestão de mensagem semântica**.

---

### 📆 Dia 2 — Desenvolvimento da API + Testes + Docker (20/07/2025)

- **Implementação da camada de domínio e controller**:
  - A IA forneceu exemplos e estrutura para criar `Employee`, `EmployeeService`, `EmployeeRepository` e `EmployeeController`.
- **Criação dos testes unitários**:
  - Estruturação com `JUnit 5` e `Mockito`, com explicação do papel de cada anotação e função.
  - Suporte na resolução de erros por posicionamento incorreto dos testes (`main` vs `test`).
- **Execução e verificação dos testes**:
  - Auxílio na leitura dos logs gerados pelo `./mvnw test`.
- **Containerização do projeto**:
  - Suporte na instalação do Docker (escolha de arquitetura, WSL, permissões).
  - Criação do `Dockerfile` e execução da imagem com `docker build` e `docker run`.
  - Validação da aplicação rodando no `localhost:8080`.
- **Criação do docker-compose.yml**:
  - Estrutura mínima para levantar a aplicação de forma facilitada com `docker-compose up`.

---

### 📆 Dia 3 — Melhorias nos Endpoints + Docker + DTOs + Testes (22/07/2025)

- **Suporte na criação dos novos endpoints**:
  - Estruturação do método `GET /employees/{id}` com uso de `Optional` e `ResponseEntity`.
  - Implementação do `PUT /employees/{id}`, com atualização de atributos.
  - Ajustes no `DELETE /employees/{id}` para validar existência antes de exclusão.
- **Criação dos DTOs personalizados**:
  - Geração de `CreateEmployeeRequest` e `UpdateEmployeeRequest`.
  - Modificação do `EmployeeController` para aceitar os DTOs no lugar da entidade diretamente.
  - Redução de exposição do campo `id` no Swagger.
- **Verificações com Docker**:
  - Testes realizados via imagem Docker para garantir consistência em ambiente isolado.
  - Auxílio na identificação e solução de problemas ao rodar múltiplos containers ou builds desatualizados.
- **Centralização dos testes unitários**:
  - Organização final dos testes do `EmployeeService` para manter cobertura e clareza.
- **Suporte geral e correção de erros**:
  - Diagnóstico de falhas no Swagger UI (`/v3/api-docs`), tratamento de `Optional`, erros de build, entre outros.

---

### 📆 Dia 4 — Tratamento de Erros Amigáveis + Validação com Docker (22/07/2025)

- **Diagnóstico e remoção do GlobalExceptionHandler**:
  - Identificado, com apoio da IA, que o uso de `@ControllerAdvice` com exceções globais causava conflitos com o Swagger UI.
  - Sugestão da IA de migrar o tratamento para dentro dos métodos dos controllers para preservar a documentação automática.
  - Decisão consciente de remover a classe `GlobalExceptionHandler.java` do fluxo da aplicação.

- **Criação de exceções customizadas e tratamento local**:
  - Geradas as classes `BadRequestException` e `ResourceNotFoundException`, ambas estendendo `RuntimeException` com construtor de mensagem.
  - A IA reforçou a importância de não utilizar `@ResponseStatus`, preservando a flexibilidade e integridade do Swagger.
  - Definição do padrão de mensagens amigáveis no formato:
    ```json
    { "error": "mensagem descritiva" }
    ```
  - Refatoração completa do `EmployeeController` com blocos `try/catch` específicos para:
    - `GET /employees/{id}`
    - `PUT /employees/{id}`
    - `DELETE /employees/{id}`

- **Refatoração do EmployeeService**:
  - Com orientação da IA, os métodos `update()` e `delete()` passaram a lançar `ResourceNotFoundException` caso o ID não exista.
  - Garantia de que as regras de negócio estão protegidas contra chamadas inválidas.

- **Validação prática com Swagger + Docker**:
  - Utilização de chamadas via Swagger para simular os erros 400 e 404.
  - IA auxiliou na criação de cenários de teste para validação de erros:
    - Envio de dados inválidos no `POST`
    - Consulta e exclusão com ID inexistente
  - Docker utilizado como ambiente isolado:
    - `docker build -t banco-management-service .`
    - `docker run -p 8080:8080 banco-management-service`

- **Documentação e organização**:
  - Suporte da IA na escolha da mensagem semântica do commit do Dia 4:
    - `feat: tratamento de erros com mensagens amigáveis + exceções customizadas aplicadas nos endpoints`
  - Alinhamento com o padrão das atualizações anteriores no `README.md` e `AI_USAGE.md`

---
### 📆 Dia 5 — Encerramento e Validação Final (23/07/2025)

- **Planejamento do encerramento do projeto com apoio da IA**:
  - Definição de uma checklist final de entrega: testes, documentação, execução via Docker, cobertura de endpoints, commit semântico final.

- **Testes manuais validados com apoio da IA**:
  - Identificação e simulação de cenários 400 e 404 diretamente via Swagger.
  - Confirmação dos retornos padronizados `{ "error": "..." }` como esperado.

- **Análise e execução dos testes automatizados**:
  - IA revisou o arquivo `EmployeeServiceTest` completo e sugeriu:
    - Teste para atualização com ID inexistente
    - Teste para atualização com ID válido
  - Após inserção, foi realizada nova execução com `./mvnw test`, validando:
    - Todos os testes passaram com `BUILD SUCCESS`
    - Cobertura completa do fluxo de serviço

- **Documentação orientada por IA**:
  - Geração completa da seção “Instruções para execução e testes” com:
    - Execução local via `mvn spring-boot:run`
    - Execução via Docker (`build` + `run`)
    - Comandos `curl` para todos os endpoints com exemplos realistas
    - Formatação final das seções do `README.md`

- **Validação final do projeto**:
  - Revisão orientada pela IA sobre pré-requisitos, estrutura de pastas, fluxo RESTful e consistência das mensagens.
  - Sugestão de commit final:
    - `test: testes finais validados com sucesso para encerramento do projeto`


---

### 🔒 Observações Finais

A IA atuou como **parceira de apoio técnico**, não realizando o projeto de forma autônoma, mas contribuindo com:

- Sugestões de boas práticas
- Resolução de dúvidas pontuais
- Geração de código a partir de instruções explícitas do desenvolvedor
- Correções e diagnósticos com base em erros apresentados

Todo o trabalho foi acompanhado e validado por mim (o candidato), que entende e domina cada parte escrita neste projeto.


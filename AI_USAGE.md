
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

### 🔒 Observações Finais

A IA atuou como **parceira de apoio técnico**, não realizando o projeto de forma autônoma, mas contribuindo com:

- Sugestões de boas práticas
- Resolução de dúvidas pontuais
- Geração de código a partir de instruções explícitas do desenvolvedor
- Correções e diagnósticos com base em erros apresentados

Todo o trabalho foi acompanhado e validado por mim (o candidato), que entende e domina cada parte escrita neste projeto.


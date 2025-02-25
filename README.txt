# Desafio Java Spring Boot - API de Produtos

Uma aplicação Spring Boot para gerenciamento de produtos, integrada ao Oracle Database, com documentação Swagger e comunicação entre serviços via Feign Client.

## 📋 Funcionalidades Principais

- **API de Produtos**:
  - `POST /api/produto/interno`: Cria um novo produto (com validação de dados via DTO).
  - `GET /api/produto/interno`: Lista todos os produtos.
  - Documentação Swagger integrada.

- **Integração com Oracle**:
  - Utilização de JPA/Hibernate para operações CRUD.
  - Package/Procedure/Function no Oracle (exemplo de uso de recursos avançados).

- **Serviço Feign Client**:
  - Exemplo de comunicação entre serviços Spring Boot.
  - `GET /api/produto/{id}`: Consulta produto via API externa.

- **Testes Automatizados**:
  - Testes integração em um banco em memoria.

## 🚀 Tecnologias Utilizadas

- **Backend**:
  - Java 17
  - Spring Boot 3.4.3
  - Spring Data JPA
  - Spring Cloud OpenFeign
  - Lombok

- **Banco de Dados**:
  - Oracle 21c XE
  - Scripts SQL para criação de objetos (Oracle)
  - Banco H2 em memoria para teste

- **Ferramentas**:
  - Maven
  - Swagger (OpenAPI 3)

## ⚙️ Configuração do Ambiente

### Pré-requisitos
- Java 17
- Maven 3.9+
- Oracle Database 21c XE (ou Docker)
- IDE (IntelliJ/Eclipse/VSCode)

### Passos para Execução

1. **Clone o repositório**:
   ```bash
   git clone [URL_DO_REPOSITÓRIO]
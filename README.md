# Desafio Java Spring Boot - API de Produtos 🚀

Aplicação Spring Boot para gerenciamento de produtos com integração Oracle Database, documentação Swagger e comunicação entre serviços via Feign Client.

## 📌 Funcionalidades Principais

### **API de Produtos**
- `POST /api/produto/interno` - Cria novo produto com validação via DTO
- `GET /api/produto/interno` - Lista todos os produtos cadastrados
- Documentação Swagger integrada

### **Integração com Banco de Dados**
- Oracle 21c XE para ambiente produtivo
- H2 Database para testes de integração
- Operações CRUD com JPA/Hibernate
- Packages/Procedures/Functions no Oracle

### **Testes Automatizados**
- Testes de integração com banco em memória H2
- Cobertura básica das principais funcionalidades

## 🛠️ Tecnologias Utilizadas

| Categoria          | Tecnologias                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| **Backend**        | Java 17, Spring Boot 3.4.3, Spring Data JPA, Spring Cloud OpenFeign, Lombok |
| **Banco de Dados** | Oracle 21c XE (produção), H2 (testes)                                       |
| **Ferramentas**    | Maven, Swagger (OpenAPI 3), JUnit 5, Mockito                                |

## 🚀 Começando

### Pré-requisitos
- Java JDK 17
- Maven 3.9+
- Oracle Database 21c XE
- IDE de sua preferência (IntelliJ/Eclipse/VSCode)

### Configuração Inicial

1. **Clone o repositório**
   ```bash
   git clone https://github.com/LucasLanfredi/cvpProduto.git
   cd cvpProduto
2. **Configuração do Banco de Dados Oracle**
   -- Execute na sequência:
   1. src/main/resources/sql/create_user_database.sql
   2. src/main/resources/sql/create_entity.sql
   3. src/main/resources/sql/basic_values.sql
   4. src/main/resources/sql/procedures.sql
3. **Build do Projeto**
   mvn clean install -U
4. **Execução da Aplicação**
   mvn spring-boot:run

## 🧪 Testes
### Executar todos os testes
1. mvn test
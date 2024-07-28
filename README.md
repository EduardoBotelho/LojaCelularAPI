# LojaCelularAPI

# Loja de Celulares API

## Descrição

API para gerenciamento de uma loja de celulares. Inclui operações CRUD para celulares, capas de celular e vendas.

## Endpoints

### Celular
- `GET /api/celulares` - Listar todos os celulares
- `POST /api/celulares` - Adicionar um novo celular
- `GET /api/celulares/{id}` - Buscar um celular pelo ID
- `PUT /api/celulares/{id}` - Atualizar um celular pelo ID
- `DELETE /api/celulares/{id}` - Deletar um celular pelo ID

### CapaCelular
- `GET /api/capas` - Listar todas as capas de celular
- `POST /api/capas` - Adicionar uma nova capa de celular
- `GET /api/capas/{id}` - Buscar uma capa de celular pelo ID
- `PUT /api/capas/{id}` - Atualizar uma capa de celular pelo ID
- `DELETE /api/capas/{id}` - Deletar uma capa de celular pelo ID

### Venda
- `GET /api/vendas` - Listar todas as vendas
- `POST /api/vendas` - Adicionar uma nova venda
- `GET /api/vendas/{id}` - Buscar uma venda pelo ID
- `DELETE /api/vendas/{id}` - Deletar uma venda pelo ID

## Configuração

### Banco de Dados

Configure o banco de dados no arquivo `application.properties`.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/loja_celular
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Loja de Celulares e Capas

Este projeto é uma API REST para uma loja que vende celulares e capas de celular.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- PostgreSQL
- Docker

## Como Executar Localmente

### Pré-requisitos

- Java 17
- Maven
- PostgreSQL

### Passos

1. Clone o repositório:
   ```sh
   git clone https://github.com/EduardoBotelho/LojaCelularAPI.git
   cd LojaCelularAPI




```mermaidclassDiagram
    class Celular {
        Long id
        String marca
        String modelo
        String cor
        Double preco
        String dataLancamento
    }
    
    class CapaCelular {
        Long id
        String marca
        String modelo
        String cor
        Double preco
    }

    class Venda {
        Long id
        LocalDateTime dataVenda
        Double valorTotal
    }

    Venda --> "0..*" Celular : contém
    Venda --> "0..*" CapaCelular : contém
 ```

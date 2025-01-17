# Distribution Center API

Este projeto é uma API backend em Java, desenvolvida com **Spring Boot**, **Maven**, **PostgreSQL**, **Lombok**, e com testes unitários inclusos. O objetivo da API é processar pedidos e determinar qual centro de distribuição (CD) deve ser utilizado para o envio de cada item, com base nas informações fornecidas pela API de centros de distribuição.

## Objetivo

Desenvolver uma solução que processe pedidos e determine qual centro de distribuição (CD) deve ser usado para o envio de cada item com base nas informações fornecidas pela API de centros de distribuição.

## Requisitos Funcionais

- **Um pedido pode ter até 100 itens.**
- **API para Processar Pedidos**: A API deve ser capaz de processar um pedido e retornar os centros de distribuição (CDs) vinculados a cada item.
- **API para Consultar Pedidos**: A API deve permitir a consulta de pedidos, retornando os itens e seus respectivos centros de distribuição vinculados.
- **Integração com API "Consulta de CDs por Item"**: A API deve utilizar uma API externa para consultar e auxiliar na inteligência de determinar o CD ideal para o envio de um item.

## Tecnologias Utilizadas

- **Java 17+**: Linguagem de programação utilizada.
- **Spring Boot**: Framework principal para construção da API.
- **Maven**: Gerenciador de dependências e build.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar informações de pedidos e centros de distribuição.
- **Lombok**: Biblioteca para reduzir o boilerplate de código, como getters, setters e construtores.
- **JUnit / Mockito**: Ferramentas para testes unitários.

## Endpoints

### 1. Processar Pedido
**POST** `/api/pedido/processar`

**Descrição**: Processa um pedido e determina os centros de distribuição (CDs) associados a cada item.

**Corpo da requisição**:
```json
{
  "pedidoId": "12345",
  "itens": [
    { "itemId": "abc", "quantidade": 2 },
    { "itemId": "def", "quantidade": 1 }
  ]
}

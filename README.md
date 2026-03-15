# 📚 LiterAlura

Aplicação de linha de comando (CLI) para buscar, catalogar e gerenciar livros e autores. O sistema consome a [API Gutendex](https://gutendex.com/) para buscar obras literárias e armazena as informações em um banco de dados PostgreSQL.

## Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework:** Spring Boot (Console Application)
* **Banco de Dados:** PostgreSQL
* **Persistência:** Spring Data JPA e Hibernate

## Funcionalidades

Através de um menu interativo no console, o usuário pode:
1. **Buscar livro pelo título:** Consulta a API Gutendex e salva o livro e o autor no banco de dados.
2. **Listar livros registrados:** Exibe todos os livros salvos no banco local.
3. **Listar autores registrados:** Exibe os autores e os livros associados a eles.
4. **Listar autores vivos em determinado ano:** Filtra autores baseando-se no ano de nascimento e falecimento.
5. **Listar livros em um determinado idioma:** Filtra os livros salvos pelas siglas de idioma (es, en, fr, pt).

## Como Executar

Configure as variáveis de ambiente necessárias no arquivo `application.properties`. Você pode configurá-las na sua IDE ou diretamente no sistema operacional:

```env
DB_HOST=localhost:5432
DB_NAME=literalura_db
DB_USER=seu_usuario_postgres
DB_PASSWORD=sua_senha_postgres
```
Como o projeto utiliza spring.jpa.hibernate.ddl-auto=update, as tabelas serão criadas automaticamente pelo Hibernate ao iniciar a aplicação.

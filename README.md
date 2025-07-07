Starta o intellij, deixa baixar as dependências:
Depois Você só precisa rodar o projeto normalmente, e depois abrir o navegador em:
http://localhost:8080/h2-console

Preencha assim na tela de login do H2 Console:

    JDBC URL: jdbc:h2:mem:testdb

    User Name: sa
O banco do h2 é sql... então para testar só de exemplo adicionar autor e livro e vincular a ele
INSERT INTO AUTOR (id, nome) VALUES (1, 'Machado de Assis');
INSERT INTO LIVRO (id, titulo, autor_id) VALUES (1, 'Dom Casmurro', 1);
depois executa SELECT * FROM AUTOR;
SELECT * FROM LIVRO;

mas pode ir mais a fundo e atualizar, deletar, exibir etc...

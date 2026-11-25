INSERT INTO tb_autor (nome, nacionalidade)
VALUES ('anônimo', NULL);

INSERT INTO tb_role (authority)
VALUES ('ROLE_ADMIN');

INSERT INTO tb_role (authority)
VALUES ('ROLE_MEMBER');

CREATE UNIQUE INDEX uk_categoria_nome_lower
ON tb_categoria (lower(nome));

CREATE UNIQUE INDEX uk_membro_email_lower
ON tb_membro (lower(email));

CREATE UNIQUE INDEX uk_carteirinha_numero_lower
ON tb_carteirinha (lower(numero));
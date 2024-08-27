CREATE SEQUENCE sequence_meme START WITH 1 INCREMENT BY 50;

CREATE TABLE meme (
    id BIGINT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    data_cadastro date NOT NULL,
    url VARCHAR(255) NOT NULL,
    categoria_meme_id BIGINT,
    usuario_id BIGINT,
    CONSTRAINT pk_meme PRIMARY KEY (id)
    );
INSERT
INTO
  meme
  (nome, descricao, data_cadastro, url, usuario_id, categoria_meme_id)
VALUES
  ('Memes engracados', 'Meme do haddad', current_date, 'https://www.google.com/imgres?q=memes%20do%20haddad&imgurl=https%3A%2F%2Fwww.jornalopcao.com.br%2Fassets%2F2024%2F07%2FWhatsApp-Image-2024-07-18-at-11.54.25.jpeg&imgrefurl=https%3A%2F%2Fwww.jornalopcao.com.br%2Fbrasil%2Fmandataxar-confira-memes-que-internautas-fizeram-sobre-fernando-haddad-621790%2F&docid=EaJJOtjwkAkRYM&tbnid=tf2_8n_K-_WPMM&vet=12ahUKEwiunNjthZSIAxWbIbkGHe6jMfIQM3oECCwQAA..i&w=1600&h=1200&hcb=2&ved=2ahUKEwiunNjthZSIAxWbIbkGHe6jMfIQM3oECCwQAA', 1, 1);
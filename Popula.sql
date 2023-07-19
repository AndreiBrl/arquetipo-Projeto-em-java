insert into usuario (id_usuario, login, senha, tipo) values (1, 'user123', 'password123', 'Leitor');
insert into usuario (id_usuario, login, senha, tipo) values (2, 'password1', 'a12345678', 'Leitor');
insert into usuario (id_usuario, login, senha, tipo) values (3, 'hello123', 'qwerty123', 'Leitor');
insert into usuario (id_usuario, login, senha, tipo) values (4, 'a123456', 'letmein', 'Leitor');
insert into usuario (id_usuario, login, senha, tipo) values (5, 'abcdef', 'iloveyou', 'Leitor');
insert into usuario (id_usuario, login, senha, tipo) values (6, 'qwerty', 'a111111', 'Leitor');
insert into usuario (id_usuario, login, senha, tipo) values (7, 'sunshine', 'abc123', 'Leitor');
insert into usuario (id_usuario, login, senha, tipo) values (8, 'soccerfan', 'admin123', 'Leitor');
insert into usuario (id_usuario, login, senha, tipo) values (9, 'ilovecats', '123abc', 'Leitor');
insert into usuario (id_usuario, login, senha, tipo) values (10, 'summer2022', 'football', 'Leitor');
insert into usuario (id_usuario, login, senha, tipo) values (11, 'happyday', 'sunshine', 'Escritor');
insert into usuario (id_usuario, login, senha, tipo) values (12, 'coolguy', 'welcome', 'Escritor');
insert into usuario (id_usuario, login, senha, tipo) values (13, 'smileyface', '1234abcd', 'Escritor');
insert into usuario (id_usuario, login, senha, tipo) values (14, 'musiclover', 'monkey', 'Escritor');
insert into usuario (id_usuario, login, senha, tipo) values (15, 'beachbum', 'ilovecats', 'Escritor');
insert into usuario (id_usuario, login, senha, tipo) values (16, '123abc', 'a12345', 'Escritor');
insert into usuario (id_usuario, login, senha, tipo) values (17, 'footballfan', 'password1', 'Escritor');
insert into usuario (id_usuario, login, senha, tipo) values (18, 'readingrocks', 'hello123', 'Escritor');
insert into usuario (id_usuario, login, senha, tipo) values (19, 'gamingguru', 'a987654321', 'Escritor');
insert into usuario (id_usuario, login, senha, tipo) values (20, 'chocolatelover', 'summer2022', 'Escritor');
insert into usuario (id_usuario, login, senha, tipo) values (21, 'helloworld', 'chocolate', 'Editora');
insert into usuario (id_usuario, login, senha, tipo) values (22, 'letmein', '123abcxyz', 'Editora');
insert into usuario (id_usuario, login, senha, tipo) values (23, 'funtimes', '1qaz2wsx', 'Editora');
insert into usuario (id_usuario, login, senha, tipo) values (24, 'starrynight', 'a555555', 'Editora');
insert into usuario (id_usuario, login, senha, tipo) values (25, 'a987654321', 'trustno1', 'Editora');
insert into usuario (id_usuario, login, senha, tipo) values (26, 'easylogin', 'baseball', 'Editora');
insert into usuario (id_usuario, login, senha, tipo) values (27, 'ilovepizza', 'letsgo', 'Editora');
insert into usuario (id_usuario, login, senha, tipo) values (28, 'partytime', 'princess', 'Editora');
insert into usuario (id_usuario, login, senha, tipo) values (29, 'happy123', 'happy123', 'Editora');
insert into usuario (id_usuario, login, senha, tipo) values (30, 'simplyme', 'soccer', 'Editora');




insert into leitor (id_leitor,generoPreferido, escritorPreferido, numeroObrasLidas, nome,id_usuario)values (1,'Romance','William Shakespeare',21,'Sofia Martins',1);
insert into leitor (id_leitor,generoPreferido, escritorPreferido, numeroObrasLidas, nome,id_usuario)values (2,'Terror','Jane Austen',32,'Pedro Silva',2);
insert into leitor (id_leitor,generoPreferido, escritorPreferido, numeroObrasLidas, nome,id_usuario)values (3,'Comedia','Charles Dickens',13,'Ana Santos',3);
insert into leitor (id_leitor,generoPreferido, escritorPreferido, numeroObrasLidas, nome,id_usuario)values (4,'Drama','Ernest Hemingway',4,'Guilherme Costa',4);
insert into leitor (id_leitor,generoPreferido, escritorPreferido, numeroObrasLidas, nome,id_usuario)values (5,'Aventura','Virginia Woolf',35,'Beatriz Oliveira',5);
insert into leitor (id_leitor,generoPreferido, escritorPreferido, numeroObrasLidas, nome,id_usuario)values (6,'Romance','Fyodor Dostoevsky',16,'Miguel Pereira',6);
insert into leitor (id_leitor,generoPreferido, escritorPreferido, numeroObrasLidas, nome,id_usuario)values (7,'Terror','J.R.R. Tolkien',7,'Mariana Rodrigues',7);
insert into leitor (id_leitor,generoPreferido, escritorPreferido, numeroObrasLidas, nome,id_usuario)values (8,'Comedia','Gabriel García Márquez',8,'André Almeida',8);
insert into leitor (id_leitor,generoPreferido, escritorPreferido, numeroObrasLidas, nome,id_usuario)values (9,'Drama','Harper Lee',29,'Carolina Sousa',9);
insert into leitor (id_leitor,generoPreferido, escritorPreferido, numeroObrasLidas, nome,id_usuario)values (10,'Aventura','J.K. Rowling',10,'Tiago Fernandes',10);


insert into escritor(id_escritor, generoEscrita, numeroDeObras, livrosPublicados, nome,id_usuario)values (1,'Romance',3,5,'William Shakespeare',11);
insert into escritor(id_escritor, generoEscrita, numeroDeObras, livrosPublicados, nome,id_usuario)values (2,'Terror',4,2,'Jane Austen',12);
insert into escritor(id_escritor, generoEscrita, numeroDeObras, livrosPublicados, nome,id_usuario)values (3,'Comedia',5,6,'Charles Dickens',13);
insert into escritor(id_escritor, generoEscrita, numeroDeObras, livrosPublicados, nome,id_usuario)values (4,'Drama',6,7,'Ernest Hemingway',14);
insert into escritor(id_escritor, generoEscrita, numeroDeObras, livrosPublicados, nome,id_usuario)values (5,'Aventura',7,8,'Virginia Woolf',15);
insert into escritor(id_escritor, generoEscrita, numeroDeObras, livrosPublicados, nome,id_usuario)values (6,'Romance',8,9,'Fyodor Dostoevsky',16);
insert into escritor(id_escritor, generoEscrita, numeroDeObras, livrosPublicados, nome,id_usuario)values (7,'Terror',9,0,'J.R.R. Tolkien',17);
insert into escritor(id_escritor, generoEscrita, numeroDeObras, livrosPublicados, nome,id_usuario)values (8,'Comedia',10,2,'Gabriel García Márquez',18);
insert into escritor(id_escritor, generoEscrita, numeroDeObras, livrosPublicados, nome,id_usuario)values (9,'Drama',11,3,'Harper Lee',19);
insert into escritor(id_escritor, generoEscrita, numeroDeObras, livrosPublicados, nome,id_usuario)values (10,'Aventura',12,1,'J.K. Rowling',20);


insert into editora (id_editora,numeroAutoresPublicados, nome,id_usuario)values (1,10,'Prime Books',21);
insert into editora (id_editora,numeroAutoresPublicados, nome,id_usuario)values (2,11,'Stellar Publishing',22);
insert into editora (id_editora,numeroAutoresPublicados, nome,id_usuario)values (3,12,'Universal Press',23);
insert into editora (id_editora,numeroAutoresPublicados, nome,id_usuario)values (4,13,'Bright Horizon Books',24);
insert into editora (id_editora,numeroAutoresPublicados, nome,id_usuario)values (5,14,'Evergreen Publications',25);
insert into editora (id_editora,numeroAutoresPublicados, nome,id_usuario)values (6,15,'Golden Pen Press',26);
insert into editora (id_editora,numeroAutoresPublicados, nome,id_usuario)values (7,16,'Crystal Clear Books',27);
insert into editora (id_editora,numeroAutoresPublicados, nome,id_usuario)values (8,17,'Starlight Publishing',28);
insert into editora (id_editora,numeroAutoresPublicados, nome,id_usuario)values (9,18,'Clearview Editions',29);
insert into editora (id_editora,numeroAutoresPublicados, nome,id_usuario)values (10,19,'Boundless Books',30);

    

  
    
	insert into historia (id_historia, id_escritor, titulo, genero, preco) values (1, 1, 'O Segredo das Estrelas', 'Romance', 2);
insert into historia (id_historia, id_escritor, titulo, genero, preco) values (2, 2, 'A Jornada do Destino', 'Terror', 0);
insert into historia (id_historia, id_escritor, titulo, genero, preco) values (3, 3, 'Entre Dois Mundos', 'Romance', 0);
insert into historia (id_historia, id_escritor, titulo, genero, preco) values (4, 3, 'O Mistério da Mansão Abandonada', 'Drama', 10);
insert into historia (id_historia, id_escritor, titulo, genero, preco) values (5, 5, 'O Poder da Imaginação', 'Aventura', 15);
insert into historia (id_historia, id_escritor, titulo, genero, preco) values (6, 5, 'Além das Fronteiras', 'Romance', 0);
insert into historia (id_historia, id_escritor, titulo, genero, preco) values (7, 5, 'A Trilha da Coragem', 'Terror', 0);
insert into historia (id_historia, id_escritor, titulo, genero, preco) values (8, 8, 'O Lado Oculto da Lua', 'Comedia', 0);
insert into historia (id_historia, id_escritor, titulo, genero, preco) values (9, 10, 'O Enigma do Espelho', 'Drama', 0);
insert into historia (id_historia, id_escritor, titulo, genero, preco) values (10, 10, 'O Suspiro do Vento', 'Aventura', 4);


INSERT INTO leitura (id_leitura,paginasLidas,  nota, id_historia, id_leitor)
VALUES
    (1,100,4, 1, 1),
    (2,150,3, 2, 2),
    (3,200,5, 3, 3),
    (4,80, NULL, 4, 4),
    (5,250,4, 5, 5),
    (6,120,3, 6, 6),
    (7,180,5, 7, 7),
    (8,90, NULL, 8, 8),
    (9,300,4, 9, 9),
	(10,300, 10, 9, 2),
    (11,300, 15, 9, 3),
    (12,300, 20, 9, 4),
    (13,140,25, 10, 10);

INSERT INTO avaliacao (id_avaliacao,nota, id_historia, id_editora)
VALUES
    ( 1, 4, 1, 1),
    ( 2, 3, 2, 2),
    ( 3, 5, 3, 3),
    ( 4, 2, 4, 1),
    ( 5, 4, 5, 2),
    ( 6, 3, 6, 3),
    ( 7, 5, 7, 1),
    ( 8, 2, 8, 2),
    ( 9, 4, 9, 3),
    ( 10,3, 10, 1);


insert into colaborativa (Id_colaborativa,id_historia, id_escritor) values (1	,	10	,	5	);
insert into colaborativa (Id_colaborativa,id_historia, id_escritor) values (2	,	9	,	3	);
insert into colaborativa (Id_colaborativa,id_historia, id_escritor) values (3	,	8	,	4	);
insert into colaborativa (Id_colaborativa,id_historia, id_escritor) values (4	,	7	,	2	);
insert into colaborativa (Id_colaborativa,id_historia, id_escritor) values (5	,	6	,	3	);
insert into colaborativa (Id_colaborativa,id_historia, id_escritor) values (6	,	5	,	1	);
insert into colaborativa (Id_colaborativa,id_historia, id_escritor) values (7	,	4	,	6	);
insert into colaborativa (Id_colaborativa,id_historia, id_escritor) values (8	,	3	,	6	);
insert into colaborativa (Id_colaborativa,id_historia, id_escritor) values (9	,	2	,	3	);
insert into colaborativa (Id_colaborativa,id_historia, id_escritor) values (10	,	1	,	4	);



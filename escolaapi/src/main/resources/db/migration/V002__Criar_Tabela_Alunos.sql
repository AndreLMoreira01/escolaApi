 create table aluno(
    id Bigint not null primary key auto_increment,
    nomealuno varchar(150),
    curso_id int not null
 );

 INSERT INTO aluno(nomealuno, curso_id) VALUES('Rogério', 4);
 INSERT INTO aluno(nomealuno, curso_id) VALUES('Maria', 1);
 INSERT INTO aluno(nomealuno, curso_id) VALUES('Joana', 1);
 INSERT INTO aluno(nomealuno, curso_id) VALUES('José', 3);
 INSERT INTO aluno(nomealuno, curso_id) VALUES('Ana Clara', 4);
 INSERT INTO aluno(nomealuno, curso_id) VALUES('Betania', 2);
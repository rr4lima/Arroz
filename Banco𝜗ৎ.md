# *Banco de dados*: 

create database RevisaoBanco;
use RevisaoBanco;

create table tb_usuarioss(
id_usuario int primary key,
usuario varchar(50) not null,
login varchar(50) not null unique,
senha varchar(50) not null,
perfil varchar(15) not null
);


describe usuario;
select * from tb_usuarioss;

insert into usuario(id, nome, login, senha)
values(1, 'Rafaela', '123', '552311');

insert into usuario(id, nome, login, senha)
values(2, 'Kauani', '456', '160255','arroz123');

select * from usuario;

update usuario set usuario = 'Kauani' where id = 2;
delete from tb_usuarioss where id_usuario = 1;

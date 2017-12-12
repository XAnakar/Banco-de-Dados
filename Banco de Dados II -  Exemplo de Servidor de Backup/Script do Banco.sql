create database Sockets;
use Sockets;

create table Aluno( 
	Cod integer not null auto_increment,
	nome varchar(255),
    cpf integer(11),
    matricula integer (8),
    ano integer (4),
    primary key (Cod) 
)


drop database sockets;

select * from aluno;
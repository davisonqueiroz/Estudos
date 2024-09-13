create database exercicio;

use exercicio;

create table Carro(
Placa varchar(8) not null primary key,
Modelo varchar(30) not null,
Ano int not null,
Cor varchar(20) not null
);

create table Pessoa(
Id int auto_increment primary key,
CPF varchar(14) not null,
Nome varchar(40) not null
);

alter table Carro
add Proprietario int not null;


alter table Carro
add constraint Proprietario 
foreign key(Proprietario) references Pessoa(Id);

select * from Carro;

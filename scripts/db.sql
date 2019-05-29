drop table producto;
drop table categoria;


create table categoria(
	id integer auto_increment primary key, 
	nombre varchar(32) not null
)

create table producto21(
	id integer auto_increment primary key,
	nombre varchar(64) not null,
	cantidad integer not null,
	categoria_id integer not null, 
	foreign key (categoria_id) references categoria(id)
)

create table materia(
	id integer auto_increment primary key,
	nombre varchar(64) not null
)

insert into materia(nombre) values('Laboratorio de aplicaciones empresariales');
insert into materia(nombre) values('Desarrollo para plataforma web II');
insert into materia(nombre) values('Desarrollo de software I');

insert into materia(nombre) values('LAE');
insert into materia(nombre) values('WEB');


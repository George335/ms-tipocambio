
create table if not exists tbl_tipo_cambio(
	id int auto_increment primary key not null,
	nombre varchar_ignorecase(50) not null,
	valor double not null,
	abreviado varchar_ignorecase(5) not null
);

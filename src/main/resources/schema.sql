
create table if not exists tbl_tipo_cambio(
	id int auto_increment primary key not null,
	nombre varchar_ignorecase(50) not null,
	valor double not null,
	abreviado varchar_ignorecase(5) not null
);

create table if not exists tipo_cambio(
	id int auto_increment primary key not null,
	pais_origen varchar_ignorecase(50) not null,
	pais_destino varchar_ignorecase(50) not null,
	monto_origen double not null,
	monto_destino double not null
);

create table if not exists usuario_acceso(
	id int auto_increment primary key not null,
	nombre_usuario varchar_ignorecase(50) not null,
	clave varchar_ignorecase(250) not null
);

create table if not exists historial_conversion(
	id int auto_increment primary key not null,
	nombre_usuario_modificador varchar_ignorecase(50) not null,
	monto_convertir varchar_ignorecase(50) not null,
	moneda_origen varchar_ignorecase(50) not null,
	moneda_destino varchar_ignorecase(50) not null,
	monto_convertido varchar_ignorecase(50) not null,
	tipo_cambio varchar_ignorecase(50) not null
);
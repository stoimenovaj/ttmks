drop table user_roles

drop table roles

drop table users

drop table setovi

drop table mechevi

drop table natprevari

drop table igrachi

drop table spagja

drop table timovi

drop table ligi

drop table fazi

drop table turniri

drop table sali

drop table sudii

drop table registrirani_lica

drop table gradovi

drop table sezoni

drop table kategorii


create table Kategorii (
	id_kategorija serial primary key,
	ime_kategorija varchar(40) not null unique
)

create table Sezoni (
	id_sezona serial primary key,
	pretsedatel varchar(30) not null,
	godina varchar(9) not null,
	check(godina ~ '[0-9]{4}/[0-9]{4}')
)

create table Gradovi (
	id_grad serial primary key,
	ime_grad varchar(30) not null unique
)

create table Registrirani_Lica (
	id_lice serial primary key,
	ime_lice varchar(20) not null,
	prezime_lice varchar(20) not null,
	godini_lice Integer not null,
	id_grad Integer references gradovi(id_grad) not null,
	check(godini_lice >= 0),
	unique(ime_lice,prezime_lice,godini_lice)
)

create table Sudii (
	id_lice_sudija Integer references registrirani_lica(id_lice),
	titula varchar(30) not null,
	primary key(id_lice_sudija)
)

create table Sali (
	id_sala serial primary key,
	ime_sala varchar(50) not null unique,
	id_grad Integer references gradovi(id_grad) not null
)

create table Turniri (
	id_turnir serial primary key,
	ime_turnir varchar(50) not null,
	data_na_odrzhuvanje date not null,
	participacija Integer default 0 not null,
	id_sala Integer references sali(id_sala) not null,
	id_sezona Integer references sezoni(id_sezona) not null,
	check(data_na_odrzhuvanje < (now() + interval '1 second')),
	check(participacija >= 0),
	unique(ime_turnir,id_sezona,data_na_odrzhuvanje)
)

create table Fazi (
	reden_broj serial,
	id_turnir Integer not null,
	id_kategorija integer not null, 
	opis_faza varchar(4) not null,
	broj_faza integer,
	foreign key(id_turnir, id_kategorija) references turniri(id_turnir, id_kategorija),
	primary key(reden_broj,id_turnir, id_kategorija),
	unique(id_turnir,opis_faza),
	check(opis_faza in ('1','1/2','1/4','1/8','1/16','1/32','1/64'))
)


create table Ligi (
	id_liga serial,
	id_sezona Integer references sezoni(id_sezona),
	ime_liga varchar(40) not null,
	primary key(id_liga,id_sezona),
	check(lower(ime_liga) in (
		'супер лига - машки',
		'супер лига - женски',
		'прва лига - машки',
		'прва лига - женски',
		'втора лига - машки',
		'втора лига - женски',
		'трета лига - машки',
		'трета лига - женски')
		),
	unique(id_sezona,ime_liga)
)

create table Timovi (
	id_tim serial primary key,
	ime_tim varchar(30) not null,
	godina_osnovan Integer not null,
	kontakt_email varchar(50) not null unique,
	kontakt_telefon varchar(12),
	kontakt_lice varchar(30),
	id_grad Integer references gradovi(id_grad) not null,
	check(godina_osnovan <= extract(year from now())),
	check(kontakt_email like '_%@_%._%')
)

create table Spagja(
	id_liga Integer not null,
	id_sezona Integer not null,
	id_tim Integer references timovi(id_tim) not null,
	tim_poeni Integer not null,
	foreign key(id_liga,id_sezona) references ligi(id_liga,id_sezona),
	primary key(id_liga,id_sezona,id_tim)
)

create table Igrachi (
	id_lice_igrach Integer references registrirani_Lica(id_lice),
	posleden_lekarski_pregled date not null,
	opis_na_reket varchar(100) not null,
	id_tim Integer references timovi(id_tim),
	id_kategorija Integer references kategorii(id_kategorija),
	primary key (id_lice_igrach),
	check(posleden_lekarski_pregled < (now() + interval '1 second'))
)

create table Natprevari (
	id_natprevar serial primary key,
	data_odigran date not null,
	id_tim_domakjin Integer references timovi(id_tim) not null,
	id_tim_gostin Integer references timovi(id_tim) not null,
	id_sala Integer references sali(id_sala),
	id_liga Integer,
	id_sezona Integer,
	kolo Integer,
	dobieni_mechevi_domakjin Integer,
	dobieni_mechevi_gostin Integer,
	foreign key (id_liga,id_sezona) references ligi(id_liga,id_sezona),
	check(data_odigran < (now() + interval '1 second')),
	check(id_tim_domakjin != id_tim_gostin),
	unique(data_odigran,id_tim_domakjin,id_tim_gostin)
)

create table Mechevi (
	id_mech serial primary key,
	id_lice_igrach_domakjin Integer references igrachi(id_lice_igrach) not null,
	id_lice_igrach_gostin Integer references igrachi(id_lice_igrach) not null,
	lice_id_sudija Integer references sudii(id_lice_sudija),
	id_natprevar Integer references natprevari(id_natprevar),
	faza_id_turnir Integer,
	faza_id_kategorija Integer,
	faza_reden_broj Integer,
	dobieni_setovi_domakjin Integer,
	dobieni_setovi_gostin Integer,
	foreign key (faza_id_turnir,faza_id_kategorija,faza_reden_broj) references fazi(id_turnir,id_kategorija,reden_broj),
	check(id_lice_igrach_domakjin != id_lice_igrach_gostin),
	unique(id_lice_igrach_domakjin,id_lice_igrach_gostin,id_natprevar)
)

create table Setovi (
	reden_broj serial,
	id_mech Integer references mechevi(id_mech),
	poeni_gostin Integer not null,
	poeni_domakjin Integer not null,
	primary key (reden_broj,id_mech)
)

create table Users (
	id bigserial NOT NULL,
	created_at timestamp NOT NULL,
	updated_at timestamp NOT NULL,
	email varchar(40) NULL,
	"name" varchar(40) NULL,
	"password" varchar(100) NULL,
	username varchar(15) NULL,
	CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
	CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username),
	CONSTRAINT users_pkey PRIMARY KEY (id)
)

create table Roles (
	id bigserial NOT NULL,
	"name" varchar(60) NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id),
	CONSTRAINT uk_nb4h0p6txrmfc0xbrd1kglp9t UNIQUE (name)
)

create table User_roles (
	user_id int8 NOT NULL,
	role_id int8 NOT NULL,
	CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id)
)

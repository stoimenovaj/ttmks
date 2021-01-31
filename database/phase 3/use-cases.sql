
-- scenario 1

-- povik za site turniri so nivnite sezoni
-- input: -
-- output: id_turnir, ime_turnir, data_na_odrzhuvanje, godina

select distinct t.id_turnir, t.ime_turnir, t.data_na_odrzhuvanje, s.godina from turniri as t
inner join sezoni as s on t.id_turnir=s.id_sezona

-- povik za kategorii na odreden turnir
-- input: id_turnir (1)
-- output: id_kategorija, ime_kategorija

select * from kategorii
where id_kategorija in 
(
	select id_kategorija from turniri
	where id_turnir=1
)

-- povik za site fazi za odreden turnir so odredena kategorija
-- input: id_turnir (1), id_kategorija (1)
-- output: opis_faza, id_lice, ime_lice, prezime_lice

select f.opis_faza, m.id_mech, f.broj_faza, rl.id_lice, rl.ime_lice, rl.prezime_lice from fazi as f
inner join mechevi as m on m.faza_id_turnir=1 and m.faza_id_kategorija=1 and m.faza_reden_broj=f.reden_broj
inner join registrirani_lica as rl on m.id_lice_igrach_domakjin=rl.id_lice or m.id_lice_igrach_gostin=rl.id_lice
where f.id_turnir=1 and f.id_kategorija=1

-- scenario 1


-- scenario 2

-- povik za site sezoni
-- input: -
-- output: id_sezona, pretsedatel, godina

select * from sezoni as s

-- povik za site ligi vo oredena sezona
-- input: sezona_id (3)
-- output: id_liga, ime_liga

select l.id_liga, ime_liga from ligi as l
where l.id_sezona=3

-- povik za dobivanje na informacii za natprevari vo odredena odredena liga i sezona
-- input: sezona_id (3), liga_id(1)
-- output: id_natprevar, domakin, gostin, dobieni_mechevi_domakjin, dobieni_mechevi_gostin

select n.id_natprevar, (
	select ime_tim from timovi as t
	where n.id_tim_domakjin=t.id_tim
) as domakin, (
	select ime_tim from timovi as t
	where n.id_tim_gostin=t.id_tim
), n.dobieni_mechevi_domakjin, n.dobieni_mechevi_gostin from natprevari as n
where n.id_sezona=3 and n.id_liga=1

-- povik za dobivanje na informacii na odigrani mechevi vo natprevar
-- input: natprevar_id(6)
-- output: id_mech, domakjin_ime, domakijn_prezime, gostin_ime, gostin_prezime, dobieni_setovi_domakjin, dobieni_setovi_gostin

select m.id_mech, (
	select rl.ime_lice from mechevi as inm
	inner join registrirani_lica as rl on inm.id_lice_igrach_domakjin=rl.id_lice
	where inm.id_mech=m.id_mech
) as domakjin_ime, (
	select rl.prezime_lice from mechevi as inm
	inner join registrirani_lica as rl on inm.id_lice_igrach_domakjin=rl.id_lice
	where inm.id_mech=m.id_mech
) as domakjin_prezime, (
	select rl.ime_lice from mechevi as inm
	inner join registrirani_lica as rl on inm.id_lice_igrach_gostin=rl.id_lice
	where inm.id_mech=m.id_mech
) as gostin_ime, (
	select rl.prezime_lice from mechevi as inm
	inner join registrirani_lica as rl on inm.id_lice_igrach_gostin=rl.id_lice
	where inm.id_mech=m.id_mech
) as gostin_prezime, m.dobieni_setovi_domakjin, m.dobieni_setovi_gostin from mechevi as m
where m.id_natprevar=6

-- povik za dobivanje na rezultati od set za daden mech
-- input: mech_id(15)
-- output: poeni_gostin, poeni_domakjin

select poeni_gostin, poeni_domakjin from setovi as s
where s.id_mech=15

-- scenario 2


-- scenario 3

-- povik za informacii za site sezoni
-- input: -
-- output: id_sezona, godina

select s.id_sezona, s.godina from sezoni as s

-- povik za informacii za site ligi vo odredena sezona
-- input: sezona_id (3)
-- output: id_liga, ime_liga

select l.id_liga, l.ime_liga from ligi as l
where l.id_sezona=3

-- povik za informacii za site timovi koi igraat vo odredena liga vo odredena sezona
-- input: sezona_id (3), id_liga (1)
-- output: id_tim, ime_tim, ime_grad, godina_osnovan

select s.id_tim, t.ime_tim, g.ime_grad, t.godina_osnovan from spagja as s
inner join timovi as t on t.id_tim=s.id_tim
inner join gradovi as g on t.id_grad=g.id_grad
where s.id_liga=1 and s.id_sezona=3

-- povik za dobivanje na site igraci vo odreden tim sortitani po odigrani mechevi vo odredena liga vo odredena sezona
-- input: tim_id (1), sezona_id (3), liga_id (1) 
-- output: ime_lice, prezime_lice, broj_mechevi

select rl.ime_lice, rl.prezime_lice, subq.broj_mechevi from (
	select i.id_lice_igrach, count(*) as broj_mechevi from igrachi as i
	inner join mechevi as m 
	on (m.id_lice_igrach_domakjin=i.id_lice_igrach or m.id_lice_igrach_gostin=i.id_lice_igrach) and m.id_natprevar is not null
	where m.id_natprevar in 
	(
		select n.id_natprevar from natprevari as n
		where n.id_liga=1 and n.id_sezona=3
	)
	group by i.id_lice_igrach
) as subq
inner join registrirani_lica as rl on rl.id_lice=subq.id_lice_igrach
order by subq.broj_mechevi desc

-- scenario 3


-- scenario 4

-- povik za dobivanje informacii za site sezoni
-- input: -
-- output: id_sezona, godina

select s.id_sezona, s.godina from sezoni as s

-- povik za dobivanje na informacii za site ligi vo odredena sezona
-- input: sezona_id (3)
-- output: id_sezona, ime_liga

select l.id_liga, l.ime_liga from ligi as l
where l.id_sezona=3


-- povik za dobivanje na site timovi vo odredena liga i sezona
-- input: sezona_id (3), liga_id (1)
-- output: id_tim, ime_tim, ime_grad

select s.id_tim, t.ime_tim, g.ime_grad from spagja as s
inner join timovi as t on t.id_tim=s.id_tim
inner join gradovi as g on t.id_grad=g.id_grad
where s.id_liga=1 and s.id_sezona=3


-- povik za kreiranje na natprevar
-- input: data_odigran, id_tim_domakjin (1), id_tim_gostin (4), id_sala (3), id_liga (1), id_sezona (3), kolo (3)
-- output: -

insert into natprevari(data_odigran,id_tim_domakjin,id_tim_gostin,id_sala,id_liga,id_sezona,kolo)
values (now(), 1, 4, 3, 1, 3, 3)

-- povik za dobivanje na site igraci od odreden tim
-- input: tim_id (1)
-- output: id_lice_igrach, ime_lice, prezime_lice

select i.id_lice_igrach, rl.ime_lice, rl.prezime_lice from igrachi as i
inner join registrirani_lica as rl on rl.id_lice=i.id_lice_igrach
where i.id_tim=1

-- povik za kreiranje na mech od odreden natprevar
-- input: id_lice_igrach_domakjin (243), id_lice_igrach_gostin (18), lice_id_sudija (133), id_natprevar (14)
-- output: -

insert into mechevi(id_lice_igrach_domakjin, id_lice_igrach_gostin, lice_id_sudija, id_natprevar)
values (243, 18, 133, 15)

-- povik za kreiranje na set od odreden mech
-- input: id_mech, poeni_gostin, poeni_domakjin
-- output: -

insert into setovi(id_mech, poeni_domakjin, poeni_gostin)
values (28, 11, 9)

-- scenario 4
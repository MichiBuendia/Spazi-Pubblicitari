drop database if exists luciocrusca_spazipub;

create database luciocrusca_spazipub default charset=utf8;

use luciocrusca_spazipub;

create table banner (
  id integer auto_increment not null,
  codice varchar(20),
  descrizione varchar(200),
  area numeric(10,4),
  primary key (id)
) Engine=InnoDB;

insert into banner (codice,descrizione,area) values
  ('LGSMALL', 'ACME Foods small size logo', 0.15);
insert into banner (codice,descrizione,area) values
  ('PESTO', 'Genoa Pesto Italian Recipe', 5.3);
insert into banner (codice,descrizione,area) values
  ('HAZLNUTC', 'Cream', 1.9);
insert into banner (codice,descrizione,area) values
  ('LGMED', 'ACME Foods med size logo', 0.53);
insert into banner (codice,descrizione,area) values
  ('DECTRT', 'De Cecco', 6);

create table campagna_pubblicitaria (
  id integer auto_increment not null,
  nome varchar(20),
  primary key (id)
) Engine=InnoDB;

insert into campagna_pubblicitaria (nome) values ('a');
insert into campagna_pubblicitaria (nome) values ('b');
insert into campagna_pubblicitaria (nome) values ('c');
insert into campagna_pubblicitaria (nome) values ('d');
insert into campagna_pubblicitaria (nome) values ('e');
insert into campagna_pubblicitaria (nome) values ('f');
insert into campagna_pubblicitaria (nome) values ('g');
insert into campagna_pubblicitaria (nome) values ('h');
insert into campagna_pubblicitaria (nome) values ('i');

create table tariffa_inserzione (
  id integer auto_increment not null,
  nome_testata varchar(20),
  nome_tariffa varchar(20),
  area_max numeric(10,4),
  costo numeric(10,4),
  primary key (id)
) Engine=InnoDB;

insert into tariffa_inserzione (nome_testata, nome_tariffa, area_max, costo) values
  ('Repubblica', 'Economy', 1, 5900);
insert into tariffa_inserzione (nome_testata, nome_tariffa, area_max, costo) values
  ('Repubblica', 'Message', 5, 7900);
insert into tariffa_inserzione (nome_testata, nome_tariffa, area_max, costo) values
  ('Repubblica', 'Impact', 30, 12900);
insert into tariffa_inserzione (nome_testata, nome_tariffa, area_max, costo) values
  ('Libero', 'Light', 1.5, 6500);
insert into tariffa_inserzione (nome_testata, nome_tariffa, area_max, costo) values
  ('Libero', 'Sicura', 7.5, 9900);
insert into tariffa_inserzione (nome_testata, nome_tariffa, area_max, costo) values
  ('Libero', 'Super', 40, 13900);
insert into tariffa_inserzione (nome_testata, nome_tariffa, area_max, costo) values
  ('IFQ', 'Base', 0.7, 5200);
insert into tariffa_inserzione (nome_testata, nome_tariffa, area_max, costo) values
  ('IFQ', 'Standard', 3, 6900);
insert into tariffa_inserzione (nome_testata, nome_tariffa, area_max, costo) values
  ('IFQ', 'Maxi', 25, 11500);

create table inserzione (
  id integer auto_increment not null,
  id_campagna integer not null,
  id_banner integer not null,
  numero_pagine integer not null,
  primary key (id),
  constraint foreign key (id_campagna) references 
     campagna_pubblicitaria(id),
  constraint foreign key (id_banner) references 
     banner(id)
) Engine=InnoDB;

insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (1, 3, 2);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (2, 2, 1);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (2, 3, 1);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (3, 3, 1);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (3, 4, 1);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (4, 1, 2);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (4, 4, 1);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (5, 4, 2);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (5, 1, 1);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (6, 1, 3);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (7, 2, 7);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (8, 5, 1);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (8, 3, 1);
insert into inserzione (id_campagna, id_banner, numero_pagine) values
  (9, 5, 6);

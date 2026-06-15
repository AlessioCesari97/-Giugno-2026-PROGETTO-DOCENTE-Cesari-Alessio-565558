insert into tournament(name,year,description) values ('Serie A 2026',2026,'Campionato italiano di calcio con le migliori squadre italiane');


insert into team(name,foundation_year,city,image) values ('AS Roma',1927,'Roma','roma.png');
insert into team(name,foundation_year,city,image) values ('Inter',1908,'Milano','inter.png');
insert into team(name,foundation_year,city,image) values ('Juventus',1897,'Torino','juventus.png');
insert into team(name,foundation_year,city,image) values ('AC Milan',1899,'Milano','milan.png');
insert into team(name,foundation_year,city,image) values ('Napoli',1926,'Napoli','napoli.png');
insert into team(name,foundation_year,city,image) values ('Lazio',1900,'Roma','lazio.png');


insert into tournament_team(tournament_id,team_id) values (1,1);
insert into tournament_team(tournament_id,team_id) values (1,2);
insert into tournament_team(tournament_id,team_id) values (1,3);
insert into tournament_team(tournament_id,team_id) values (1,4);
insert into tournament_team(tournament_id,team_id) values (1,5);
insert into tournament_team(tournament_id,team_id) values (1,6);


insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Paulo','Dybala','1993-11-15','Attaccante',177,'dybala.png',1);
insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Lorenzo','Pellegrini','1996-06-19','Centrocampista',186,'pellegrini.png',1);

insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Lautaro','Martinez','1997-08-22','Attaccante',174,'lautaro.png',2);
insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Nicolo','Barella','1997-02-07','Centrocampista',172,'barella.png',2);

insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Dusan','Vlahovic','2000-01-28','Attaccante',190,'vlahovic.png',3);
insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Manuel','Locatelli','1998-01-08','Centrocampista',185,'locatelli.png',3);

insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Rafael','Leao','1999-06-10','Attaccante',188,'leao.png',4);
insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Mike','Maignan','1995-07-03','Portiere',191,'maignan.png',4);

insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Romelu','Lukaku','1993-05-13','Attaccante',191,'lukaku.png',5);
insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Giovanni','Di Lorenzo','1993-08-04','Difensore',183,'dilorenzo.png',5);

insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Mattia','Zaccagni','1995-06-16','Attaccante',177,'zaccagni.png',6);
insert into player(first_name,last_name,birth_date,role,height,image,team_id) values ('Alessio','Romagnoli','1995-01-12','Difensore',185,'romagnoli.png',6);



insert into referee(first_name,last_name,referee_code) values ('Daniele','Orsato','ARB001');
insert into referee(first_name,last_name,referee_code) values ('Davide','Massa','ARB002');
insert into referee(first_name,last_name,referee_code) values ('Maurizio','Mariani','ARB003');



insert into match(date_time,location,goals_home,goals_away,status,tournament_id,home_team_id,away_team_id,referee_id) values ('2026-06-10 20:45:00','Stadio Olimpico',2,1,'PLAYED',1,1,2,1);

insert into match(date_time,location,goals_home,goals_away,status,tournament_id,home_team_id,away_team_id,referee_id) values ('2026-06-12 21:00:00','San Siro',3,0,'PLAYED',1,4,5,2);

insert into match(date_time,location,goals_home,goals_away,status,tournament_id,home_team_id,away_team_id,referee_id) values ('2026-07-01 20:30:00','Allianz Stadium',null,null,'SCHEDULED',1,3,6,3);

insert into match(date_time,location,goals_home,goals_away,status,tournament_id,home_team_id,away_team_id,referee_id) values ('2026-07-05 18:00:00','San Siro',null,null,'SCHEDULED',1,2,4,1);



insert into app_user(username,password,role) values ('admin','$2a$10$4voe9gwmWe.GKX3RL8xvcuwSiG0Y0YsrNq9kSPkQNXIfK3u5JvcFK','ADMIN');

insert into app_user(username,password,role) values ('user','$2a$10$4voe9gwmWe.GKX3RL8xvcuwSiG0Y0YsrNq9kSPkQNXIfK3u5JvcFK','USER');
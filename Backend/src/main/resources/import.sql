INSERT INTO public."MITGLIED" (
"Email", "Passwort", "Rolle") VALUES (
'Max@Muster.com'::character varying, 'veryEncrypedPassword'::character varying, 'Mitglied
'::character varying)
 returning id;

 INSERT INTO public."MITGLIED" (
"Email", "Passwort", "Rolle") VALUES (
'severin.machaz@bluewin.ch'::character varying, 'ENCYRTPED_PWD
'::character varying, 'ADMIN'::character varying)
 returning id;

INSERT INTO public."BUCHUNG" (
"Datum", "Halbtag", "Status", mitglied_id) VALUES (
'NOW()'::timestamp without time zone, true::boolean, true::boolean, '1'::bigint)
 returning id;

 INSERT INTO public."BUCHUNG" (
"Datum", "Halbtag", "Status", mitglied_id) VALUES (
'NOW()'::timestamp without time zone, false::boolean, false::boolean, '1'::bigint)
 returning id;

 INSERT INTO public."CAFEUSER" (
"Timestamp", mitglied_id) VALUES (
'NOW()'::timestamp without time zone, '1'::bigint)
 returning id;

INSERT INTO public."MONITOR" (
id) VALUES (
'1'::bigint)
 returning id;

 INSERT INTO public."MONITORAUSLEIHE" (
"Datum", monitor_id, mitglied_id) VALUES (
'NOW()
'::timestamp without time zone, '1'::bigint, '1'::bigint)
 returning id;
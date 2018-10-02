INSERT INTO users (user_name, password, email_address, user_permission) VALUES ('Dani1', '12345', 'f3ral.riser@gmail.com', 'admin');
INSERT INTO users (user_name, password, email_address, user_permission) VALUES ('Dani2', '12345', 'gyonidanielhivatalos@gmail.com', 'guest');

INSERT INTO feltetek (nev, ar) VALUES ('Sajt', '100');
INSERT INTO feltetek (nev, ar) VALUES ('Sonka', '150');
INSERT INTO feltetek (nev, ar) VALUES ('Szalami', '150');
INSERT INTO feltetek (nev, ar) VALUES ('Bacon', '200');
INSERT INTO feltetek (nev, ar) VALUES ('Kolbasz', '200');
INSERT INTO feltetek (nev, ar) VALUES ('Lilahagyma', '130');
INSERT INTO feltetek (nev, ar) VALUES ('Csipospaprika', '180');

INSERT INTO alapok (nev,ar) VALUES ('Paradicsomos', '300');
INSERT INTO alapok (nev,ar) VALUES ('Tejfolos', '320');
INSERT INTO alapok (nev,ar) VALUES ('Mustaros', '350');

INSERT INTO tesztak (nev, ar) VALUES ('Vastag', '350');
INSERT INTO tesztak (nev, ar) VALUES ('Vekony', '300');

INSERT INTO pizzak(ar,nev,alap_id,teszta_id) VALUES(1300,'Magyaros',1,1);
INSERT INTO pizzak_feltetek(pizza_id,feltetek_id) VALUES(1,1);
INSERT INTO pizzak_feltetek(pizza_id,feltetek_id) VALUES(1,2);
INSERT INTO pizzak_feltetek(pizza_id,feltetek_id) VALUES(1,4);
INSERT INTO pizzak_feltetek(pizza_id,feltetek_id) VALUES(1,5);
INSERT INTO pizzak_feltetek(pizza_id,feltetek_id) VALUES(1,6);

INSERT INTO feltetek_pizzak(pizzak_id,feltet_id) VALUES(1,1);
INSERT INTO feltetek_pizzak(pizzak_id,feltet_id) VALUES(1,2);
INSERT INTO feltetek_pizzak(pizzak_id,feltet_id) VALUES(1,4);
INSERT INTO feltetek_pizzak(pizzak_id,feltet_id) VALUES(1,5);
INSERT INTO feltetek_pizzak(pizzak_id,feltet_id) VALUES(1,6);

INSERT INTO alapok_pizzak(alap_id,pizzak_id) VALUES (1,1);
INSERT INTO tesztak_pizzak(teszta_id,pizzak_id) VALUES (1,1);
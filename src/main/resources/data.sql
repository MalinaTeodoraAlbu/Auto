INSERT INTO Clienti (nume, adresa, telefon) VALUES ('Ion Popescu', 'Strada Mare 1, București', '0722123456');
INSERT INTO Clienti (nume, adresa, telefon) VALUES ('Maria Ionescu', 'Strada Mică 2, Cluj-Napoca', '0743123456');


INSERT INTO Solicitari (id, client_id, locatie_Solicitare, stare) VALUES (1, 1, 'Strada Principală, Nr. 10, București', 'SOLICITARE_TRIMISA');
INSERT INTO Solicitari (id, client_id, locatie_Solicitare, stare) VALUES (2, 2, 'Strada Secundară, Nr. 5, Cluj-Napoca', 'SOLICITARE_TRIMISA');

INSERT INTO Servicii (descriere, tarif, solicitare_id) VALUES ('Înlocuire baterie', 250.50, 1);
INSERT INTO Servicii (descriere, tarif, solicitare_id) VALUES ('Înlocuire PC', 250.50, 1);
INSERT INTO Servicii (descriere, tarif, solicitare_id) VALUES ('Schimb ulei', 150.00, 2);



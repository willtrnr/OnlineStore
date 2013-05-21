--
-- OnlineStore
--

--
-- Skrillex intermission
--
DROP TABLE panier;
DROP TABLE itemscommandes;
DROP TABLE commandes;
DROP TABLE clients;
DROP TABLE itemdisques;
DROP TABLE artistes;
DROP TABLE itemdvds;
DROP TABLE realisateurs;
DROP TABLE itemlivres;
DROP TABLE auteurs;
DROP TABLE items;
DROP TABLE genres;

--
-- Create tables
--
CREATE TABLE genres (
  id INTEGER NOT NULL,
  itemtype SMALLINT NOT NULL,
  nom VARCHAR2(50) NOT NULL,
  CONSTRAINT pk_genre PRIMARY KEY (id)
);
COMMIT;

CREATE TABLE items (
  id INTEGER NOT NULL,
  itemtype SMALLINT NOT NULL,
  titre VARCHAR2(50) NOT NULL,
  prix NUMBER(38, 2) NOT NULL,
  stock INTEGER,
  stocklimit INTEGER,
  genre INTEGER,
  CONSTRAINT pk_items PRIMARY KEY (id),
  CONSTRAINT fk_items_genres FOREIGN KEY (genre) REFERENCES genres(id)
);
COMMIT;

CREATE TABLE auteurs (
  id INTEGER NOT NULL,
  nom VARCHAR2(50) NOT NULL,
  CONSTRAINT pk_auteurs PRIMARY KEY (id)
);
COMMIT;

CREATE TABLE itemlivres (
  item INTEGER NOT NULL,
  auteur INTEGER,
  CONSTRAINT pk_itemlivres PRIMARY KEY (item),
  CONSTRAINT fk_itemlivres_items FOREIGN KEY (item) REFERENCES items(id) ON DELETE CASCADE,
  CONSTRAINT fk_itemlivres_auteurs FOREIGN KEY (auteur) REFERENCES auteurs(id) ON DELETE SET NULL
);
COMMIT;

CREATE TABLE realisateurs (
  id INTEGER NOT NULL,
  nom VARCHAR2(50) NOT NULL,
  CONSTRAINT pk_realisateurs PRIMARY KEY (id)
);
COMMIT;

CREATE TABLE itemdvds (
  item INTEGER NOT NULL,
  realisateur INTEGER,
  CONSTRAINT pk_itemdvds PRIMARY KEY (item),
  CONSTRAINT fk_itemdvds_items FOREIGN KEY (item) REFERENCES items(id) ON DELETE CASCADE,
  CONSTRAINT fk_itemdvds_realisateurs FOREIGN KEY (realisateur) REFERENCES realisateurs(id) ON DELETE SET NULL
);
COMMIT;

CREATE TABLE artistes (
  id INTEGER NOT NULL,
  nom VARCHAR2(50) NOT NULL,
  CONSTRAINT pk_artistes PRIMARY KEY (id)
);
COMMIT;

CREATE TABLE itemdisques (
  item INTEGER NOT NULL,
  artiste INTEGER,
  CONSTRAINT pk_itemdisques PRIMARY KEY (item),
  CONSTRAINT fk_itemdisques_items FOREIGN KEY (item) REFERENCES items(id) ON DELETE CASCADE,
  CONSTRAINT fk_itemdisques_artistes FOREIGN KEY (artiste) REFERENCES artistes(id) ON DELETE SET NULL
);
COMMIT;

CREATE TABLE clients (
  id INTEGER NOT NULL,
  nom VARCHAR2(50) NOT NULL,
  prenom VARCHAR2(50) NOT NULL,
  addresse VARCHAR2(255),
  ville VARCHAR2(50),
  ccnumber VARCHAR2(16),
  ccmonth SMALLINT,
  ccyear SMALLINT,
  cctype VARCHAR2(10),
  CONSTRAINT pk_clients PRIMARY KEY (id)
);
COMMIT;

CREATE TABLE commandes (
  id INTEGER NOT NULL,
  client INTEGER,
  tstamp DATE NOT NULL,
  pst NUMBER(38, 2),
  gst NUMBER(38, 2),
  total NUMBER(38, 2) NOT NULL,
  CONSTRAINT pk_commandes PRIMARY KEY (id),
  CONSTRAINT fk_commandes_clients FOREIGN KEY (client) REFERENCES clients(id) ON DELETE SET NULL
);
COMMIT;

CREATE TABLE itemscommandes (
  commande INTEGER NOT NULL,
  item INTEGER NOT NULL,
  prix NUMBER(38, 2) NOT NULL,
  qte INTEGER NOT NULL,
  CONSTRAINT pk_itemscommandes PRIMARY KEY (commande, item),
  CONSTRAINT fk_itemscommandes_commandes FOREIGN KEY (commande) REFERENCES commandes(id) ON DELETE CASCADE,
  CONSTRAINT fk_itemscommandes_items FOREIGN KEY (item) REFERENCES items(id)
);
COMMIT;

CREATE TABLE panier (
  client INTEGER,
  sessid VARCHAR2(32),
  item INTEGER NOT NULL,
  qte INTEGER NOT NULL,
  CONSTRAINT pk_panier PRIMARY KEY (client, sessid, item),
  CONSTRAINT fk_panier_clients FOREIGN KEY (client) REFERENCES clients(id) ON DELETE CASCADE,
  CONSTRAINT fk_panier_items FOREIGN KEY (item) REFERENCES items(id) ON DELETE CASCADE
);
COMMIT;

--
-- Skrillex time again
--
DROP SEQUENCE seq_genres;
DROP SEQUENCE seq_items;
DROP SEQUENCE seq_auteurs;
DROP SEQUENCE seq_realisateurs;
DROP SEQUENCE seq_artistes;
DROP SEQUENCE seq_clients;
DROP SEQUENCE seq_commandes;

--
-- REDNECK AUTOINCREMENT (props to the Sublime Text 2 snippets, best feature ever)
--
CREATE SEQUENCE seq_genres START WITH 1000;
CREATE OR REPLACE TRIGGER ai_genres BEFORE INSERT ON genres FOR EACH ROW BEGIN
  SELECT seq_genres.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
COMMIT;

CREATE SEQUENCE seq_items START WITH 10000;
CREATE OR REPLACE TRIGGER ai_items BEFORE INSERT ON items FOR EACH ROW BEGIN
  IF :OLD.id IS NULL OR :OLD.id = 0 THEN
    SELECT seq_items.NEXTVAL INTO :NEW.id FROM DUAL;
  END IF;
END;
/
COMMIT;

CREATE SEQUENCE seq_auteurs START WITH 1000;
CREATE OR REPLACE TRIGGER ai_auteurs BEFORE INSERT ON auteurs FOR EACH ROW BEGIN
  SELECT seq_auteurs.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
COMMIT;

CREATE SEQUENCE seq_realisateurs START WITH 1000;
CREATE OR REPLACE TRIGGER ai_realisateurs BEFORE INSERT ON realisateurs FOR EACH ROW BEGIN
  SELECT seq_realisateurs.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
COMMIT;

CREATE SEQUENCE seq_artistes START WITH 1000;
CREATE OR REPLACE TRIGGER ai_artistes BEFORE INSERT ON artistes FOR EACH ROW BEGIN
  SELECT seq_artistes.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
COMMIT;

CREATE SEQUENCE seq_clients START WITH 10000;
CREATE OR REPLACE TRIGGER ai_clients BEFORE INSERT ON clients FOR EACH ROW BEGIN
  SELECT seq_clients.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
COMMIT;

CREATE SEQUENCE seq_commandes START WITH 10000;
CREATE OR REPLACE TRIGGER ai_commandes BEFORE INSERT ON commandes FOR EACH ROW BEGIN
  SELECT seq_commandes.NEXTVAL INTO :NEW.id FROM DUAL;
END;
/
COMMIT;

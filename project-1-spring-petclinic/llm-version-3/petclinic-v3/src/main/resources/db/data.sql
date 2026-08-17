INSERT INTO pet_types (name) VALUES ('cat');
INSERT INTO pet_types (name) VALUES ('dog');
INSERT INTO pet_types (name) VALUES ('lizard');
INSERT INTO pet_types (name) VALUES ('snake');
INSERT INTO pet_types (name) VALUES ('bird');
INSERT INTO pet_types (name) VALUES ('hamster');

INSERT INTO specialties (name) VALUES ('radiology');
INSERT INTO specialties (name) VALUES ('surgery');
INSERT INTO specialties (name) VALUES ('dentistry');

INSERT INTO vets (first_name, last_name) VALUES ('James', 'Carter');
INSERT INTO vets (first_name, last_name) VALUES ('Helen', 'Leary');
INSERT INTO vets (first_name, last_name) VALUES ('Linda', 'Douglas');
INSERT INTO vets (first_name, last_name) VALUES ('Rafael', 'Ortega');

INSERT INTO vet_specialties VALUES (2, 1);
INSERT INTO vet_specialties VALUES (3, 2);
INSERT INTO vet_specialties VALUES (3, 3);
INSERT INTO vet_specialties VALUES (4, 2);

INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES ('George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES ('Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES ('Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES ('Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');

INSERT INTO pets (name, birth_date, type_id, owner_id) VALUES ('Leo', '2010-09-07', 1, 1);
INSERT INTO pets (name, birth_date, type_id, owner_id) VALUES ('Basil', '2012-08-06', 6, 2);
INSERT INTO pets (name, birth_date, type_id, owner_id) VALUES ('Rosy', '2011-04-17', 2, 3);
INSERT INTO pets (name, birth_date, type_id, owner_id) VALUES ('Iggy', '2010-11-30', 3, 4);

INSERT INTO visits (pet_id, visit_date, description) VALUES (1, '2023-01-08', 'Rabies shot');
INSERT INTO visits (pet_id, visit_date, description) VALUES (2, '2023-03-04', 'Spayed');

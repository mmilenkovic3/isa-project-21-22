#Authority
insert into booking_db.authority values(1, 'ROLE_ADMIN');
insert into booking_db.authority values(2, 'ROLE_USERS');
insert into booking_db.authority values(3, 'ROLE_BOATOWNER');
insert into booking_db.authority values(4, 'ROLE_COTTAGEOWNER');
insert into booking_db.authority values(5, 'ROLE_INSTRUCTOR');

#Cottage
INSERT INTO `booking_db`.`cotagge` (`id_cottage`, `address`, `grade`, `info`, `name`, `num_bed`, `num_room`, `price`, `promo_description`) VALUES ('1', 'Gagarinova 1', '7', 'Predivna vikendica.', 'Elsa', '3', '2', '500', 'La la la');
INSERT INTO `booking_db`.`cotagge` (`id_cottage`, `address`, `grade`, `info`, `name`, `num_bed`, `num_room`, `price`, `promo_description`) VALUES ('2', 'Trg Mladenaca 10', '10', 'Uzivancija.', 'Rodrigez', '2', '1', '200', 'Ohooo');
INSERT INTO `booking_db`.`cotagge` (`id_cottage`, `address`, `grade`, `info`, `name`, `num_bed`, `num_room`, `price`, `promo_description`) VALUES ('3', 'Lovacka 8', '10', 'Sesir nakrivi lakse se zivi.', 'Nevena', '4', '3', '800', 'Zurka ludnica');
INSERT INTO `booking_db`.`cotagge` (`id_cottage`, `address`, `grade`, `info`, `name`, `num_bed`, `num_room`, `price`, `promo_description`) VALUES ('4', 'Novosadska 23', '8', 'Neposredno proed sume.', 'Lola', '2', '1', '300', 'Sala zabava');
INSERT INTO `booking_db`.`cotagge` (`id_cottage`, `address`, `grade`, `info`, `name`, `num_bed`, `num_room`, `price`, `promo_description`) VALUES ('5', 'Ambasadorska 40', '9', 'Leposava', 'Adriana No', '4', '4', '500', 'Prednost mladi');

#Boat
INSERT INTO `booking_db`.`boat` (`id_boat`, `address`, `cancellation_type`, `capacity`, `engine_power`, `enginge_num`, `grade`, `length`, `max_speed`, `name`, `navigation_equipment`, `price`, `promo_description_boat`, `type`) VALUES ('1', 'Dunavska 1', 'PAYBACK', '4', '40', '100', '8', '4', '230', 'Kometa', 'RADAR', '400', 'Brza kao kometa.', 'CAMAC');
INSERT INTO `booking_db`.`boat` (`id_boat`, `address`, `cancellation_type`, `capacity`, `engine_power`, `enginge_num`, `grade`, `length`, `max_speed`, `name`, `navigation_equipment`, `price`, `promo_description_boat`, `type`) VALUES ('2', 'Novi Prilaz 3', 'NOT_PAYBACK', '6', '70', '20', '10', '6', '220', 'Abrit', 'FISH_FINDER', '700', 'Samo hrabri dolaze u obzir.', 'BROD');
INSERT INTO `booking_db`.`boat` (`id_boat`, `address`, `cancellation_type`, `capacity`, `engine_power`, `enginge_num`, `grade`, `length`, `max_speed`, `name`, `navigation_equipment`, `price`, `promo_description_boat`, `type`) VALUES ('3', 'Adamoviceva 26', 'PAYBACK', '3', '140', '3', '9', '3', '180', 'TDBM ', 'GPS', '300', 'He he he', 'CAMAC');


#Adventure
INSERT INTO `booking_db`.`adventure` (`id_adventure`, `address`, `bio`, `cancellation_type`, `capacity`, `grade`, `name`, `price`, `promo_description_adventure`) VALUES ('1', 'Niksicka 2', 'Instruktor carina', 'PAYBACK', '4', '10', 'Avantura', '400', 'Dodji i zabavi se.');
INSERT INTO `booking_db`.`adventure` (`id_adventure`, `address`, `bio`, `cancellation_type`, `capacity`, `grade`, `name`, `price`, `promo_description_adventure`) VALUES ('2', 'Sokotska ', 'Sta reci.', 'NOT_PAYBACK', '2', '8', 'Jungle', '200', 'Jungle mania');

#Users
INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `approved_by_admin`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (2, 1,'Gagrinova 10',1, 'Novi Sad', 'Srbija', 'patient0874@gmail.com', 'Srdjan', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '064/89-96-321', 'Mekic');
INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `approved_by_admin`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (1 ,1, 'Novosadska 188', 1, 'Zrenjanin','Srbija', 'pharmacistpharmacy33@gmail.com', 'Maja', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '062/87-54-456', 'Gojkov');

INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `approved_by_admin`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (3, 1,'Novi Breg 3',1, 'Novi Sad', 'Srbija', 'vlasnikvikendice@gmail.com', 'Ana', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '064/81-91-321', 'Anic');
INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `approved_by_admin`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (4 ,1, 'Srpska 47', 1, 'Zrenjanin','Srbija', 'vlasnikbroda@gmail.com', 'Borislav', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '063/87-00-452', 'Bebic');
INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `approved_by_admin`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (5 ,1, 'Tepsija 1', 1, 'Beograd','Srbija', 'instruktor@gmail.com', 'Ivan', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '063/811-00-52', 'Srbic');


INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `approved_by_admin`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (6, 1,'Eon 33',1, 'Novi Sad', 'Srbija', 'vlasnikvikendice1@gmail.com', 'Medina', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '061/11-91-121', 'Grgic');
INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `approved_by_admin`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (7 ,1, 'Pirotska 19', 1, 'Zrenjanin','Srbija', 'vlasnikbroda1@gmail.com', 'Gorana', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '063/87-50-434', 'Radic');
INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `approved_by_admin`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (8 ,1, 'Krba Like 1', 1, 'Beograd','Srbija', 'instruktor1@gmail.com', 'Fahreta', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '063/431-65-12', 'Bregic');

INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `approved_by_admin`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (9, 1,'Ambasadorska 199',1, 'Novi Sad', 'Srbija', 'vlasnikvikendice2@gmail.com', 'Lana', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '064/56-91-123', 'Amidzic');

#user_authority
insert into `booking_db`.`user_authority` (user_id, authority_id) values (1,1);
insert into `booking_db`.`user_authority` (user_id, authority_id) values (2,2);
insert into `booking_db`.`user_authority` (user_id, authority_id) values (3,4); #Cottage owner
insert into `booking_db`.`user_authority` (user_id, authority_id) values (4,3); #Boat owner
insert into `booking_db`.`user_authority` (user_id, authority_id) values (5,5); #Instructor
insert into `booking_db`.`user_authority` (user_id, authority_id) values (6,4); #Cottage owner
insert into `booking_db`.`user_authority` (user_id, authority_id) values (7,3); #Boat owner
insert into `booking_db`.`user_authority` (user_id, authority_id) values (8,5); #Instructor
insert into `booking_db`.`user_authority` (user_id, authority_id) values (9,4); #Cottage owner

insert into `booking_db`.`admin` (id) values (1);
INSERT INTO `booking_db`.`client` (`id`, `penality`, `points`, `royal_type`) VALUES (2, 0, 0,'NONE');
insert into `booking_db`.`boat_owner` (id) values (4);
insert into `booking_db`.`boat_owner` (id) values (7);
insert into `booking_db`.`cottage_owner` (id) values (3);
insert into `booking_db`.`cottage_owner` (id) values (6);
insert into `booking_db`.`cottage_owner` (id) values (9);
insert into `booking_db`.`instructor` (id) values (8);
insert into `booking_db`.`instructor` (id) values (5);

#cottageOwner_cottages
INSERT INTO `booking_db`.`cottage_owner_cottages` (`cottage_owner_id`, `cottages_id_cottage`) VALUES ('3', '1');
INSERT INTO `booking_db`.`cottage_owner_cottages` (`cottage_owner_id`, `cottages_id_cottage`) VALUES ('3', '2');
INSERT INTO `booking_db`.`cottage_owner_cottages` (`cottage_owner_id`, `cottages_id_cottage`) VALUES ('6', '3');
INSERT INTO `booking_db`.`cottage_owner_cottages` (`cottage_owner_id`, `cottages_id_cottage`) VALUES ('6', '5');
INSERT INTO `booking_db`.`cottage_owner_cottages` (`cottage_owner_id`, `cottages_id_cottage`) VALUES ('9', '4');

#boatOwner_boats
INSERT INTO `booking_db`.`boat_owner_boats` (`boat_owner_id`, `boats_id_boat`) VALUES ('4', '1');
INSERT INTO `booking_db`.`boat_owner_boats` (`boat_owner_id`, `boats_id_boat`) VALUES ('7', '2');
INSERT INTO `booking_db`.`boat_owner_boats` (`boat_owner_id`, `boats_id_boat`) VALUES ('7', '3');

#instructor_adventure_adventures
INSERT INTO `booking_db`.`instructor_adventures` (`instructor_id`, `adventures_id_adventure`) VALUES ('5', '1');
INSERT INTO `booking_db`.`instructor_adventures` (`instructor_id`, `adventures_id_adventure`) VALUES ('8', '2');

#staff
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('1', 'Internet');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('2', 'Masina za sudje');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('3', 'Fen');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('4', 'TV');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('5', 'Klima');

#Rules
INSERT INTO `booking_db`.`rules` (`id_rules`, `description`) VALUES ('1', 'Zabranjeni ljubimci');
INSERT INTO `booking_db`.`rules` (`id_rules`, `description`) VALUES ('2', 'Zabranjeno pusenje');
INSERT INTO `booking_db`.`rules` (`id_rules`, `description`) VALUES ('3', 'Sami sredjujete svoj otpad');
INSERT INTO `booking_db`.`rules` (`id_rules`, `description`) VALUES ('4', 'Nema buke od 13:00 do 15:00');
#ove mogu za brod
INSERT INTO `booking_db`.`rules` (`id_rules`, `description`) VALUES ('5', 'Zabranjeno skakanje');
INSERT INTO `booking_db`.`rules` (`id_rules`, `description`) VALUES ('6', 'Zabranjeno naslanjati se na ograd');

INSERT INTO `booking_db`.`rules` (`id_rules`, `description`) VALUES ('7', 'Zabranjeno lomiti biljke');
INSERT INTO `booking_db`.`rules` (`id_rules`, `description`) VALUES ('8', 'Zabranjeno fotografisanje');
INSERT INTO `booking_db`.`rules` (`id_rules`, `description`) VALUES ('9', 'Zabranjeno hodati po travi');
INSERT INTO `booking_db`.`rules` (`id_rules`, `description`) VALUES ('10', 'Molimo vas vratite sve kako je bilo. Hvala');

#cottage_rules
insert into cottage_rules values (1, 1);
insert into cottage_rules values (1, 2);
insert into cottage_rules values (1, 10);
insert into cottage_rules values (2, 1);
insert into cottage_rules values (2, 3);
insert into cottage_rules values (2, 9);
insert into cottage_rules values (2, 10);
insert into cottage_rules values (3, 2);
insert into cottage_rules values (3, 10);
insert into cottage_rules values (4, 2);
insert into cottage_rules values (4, 10);
insert into cottage_rules values (4, 9);
insert into cottage_rules values (5, 9);
insert into cottage_rules values (5, 10);

#boat_rules
INSERT INTO `booking_db`.`boat_rules` (`boat_id_boat`, `rules_id_rules`) VALUES ('1', '5');
INSERT INTO `booking_db`.`boat_rules` (`boat_id_boat`, `rules_id_rules`) VALUES ('1', '8');
INSERT INTO `booking_db`.`boat_rules` (`boat_id_boat`, `rules_id_rules`) VALUES ('1', '2');
INSERT INTO `booking_db`.`boat_rules` (`boat_id_boat`, `rules_id_rules`) VALUES ('2', '1');
INSERT INTO `booking_db`.`boat_rules` (`boat_id_boat`, `rules_id_rules`) VALUES ('2', '6');
INSERT INTO `booking_db`.`boat_rules` (`boat_id_boat`, `rules_id_rules`) VALUES ('3', '4');
INSERT INTO `booking_db`.`boat_rules` (`boat_id_boat`, `rules_id_rules`) VALUES ('3', '10');

#adventure_rules
INSERT INTO `booking_db`.`adventure_rules` (`adventure_id_adventure`, `rules_id_rules`) VALUES ('1', '8');
INSERT INTO `booking_db`.`adventure_rules` (`adventure_id_adventure`, `rules_id_rules`) VALUES ('1', '5');
INSERT INTO `booking_db`.`adventure_rules` (`adventure_id_adventure`, `rules_id_rules`) VALUES ('2', '9');
INSERT INTO `booking_db`.`adventure_rules` (`adventure_id_adventure`, `rules_id_rules`) VALUES ('2', '2');

#Fishing_kit
INSERT INTO `booking_db`.`fishing_kit` (`id_fishing_kit`, `name`) VALUES ('1', 'Pecaljka');
INSERT INTO `booking_db`.`fishing_kit` (`id_fishing_kit`, `name`) VALUES ('2', 'Sesir');
INSERT INTO `booking_db`.`fishing_kit` (`id_fishing_kit`, `name`) VALUES ('3', 'Stolica');
INSERT INTO `booking_db`.`fishing_kit` (`id_fishing_kit`, `name`) VALUES ('4', 'Mamac');
INSERT INTO `booking_db`.`fishing_kit` (`id_fishing_kit`, `name`) VALUES ('5', 'Hrana');
INSERT INTO `booking_db`.`fishing_kit` (`id_fishing_kit`, `name`) VALUES ('6', 'Suncobran');
INSERT INTO `booking_db`.`fishing_kit` (`id_fishing_kit`, `name`) VALUES ('7', 'Kanta');
INSERT INTO `booking_db`.`fishing_kit` (`id_fishing_kit`, `name`) VALUES ('8', 'Ribolovacka mreza');
INSERT INTO `booking_db`.`fishing_kit` (`id_fishing_kit`, `name`) VALUES ('9', 'Crvi za pecanje');

#boat_fishingKit
INSERT INTO `booking_db`.`boat_fishing_kit` (`boat_id_boat`, `fishing_kits_id_fishing_kit`) VALUES ('1', '1');
INSERT INTO `booking_db`.`boat_fishing_kit` (`boat_id_boat`, `fishing_kits_id_fishing_kit`) VALUES ('1', '2');
INSERT INTO `booking_db`.`boat_fishing_kit` (`boat_id_boat`, `fishing_kits_id_fishing_kit`) VALUES ('1', '3');
INSERT INTO `booking_db`.`boat_fishing_kit` (`boat_id_boat`, `fishing_kits_id_fishing_kit`) VALUES ('1', '5');
INSERT INTO `booking_db`.`boat_fishing_kit` (`boat_id_boat`, `fishing_kits_id_fishing_kit`) VALUES ('1', '6');
INSERT INTO `booking_db`.`boat_fishing_kit` (`boat_id_boat`, `fishing_kits_id_fishing_kit`) VALUES ('2', '8');
INSERT INTO `booking_db`.`boat_fishing_kit` (`boat_id_boat`, `fishing_kits_id_fishing_kit`) VALUES ('2', '1');
INSERT INTO `booking_db`.`boat_fishing_kit` (`boat_id_boat`, `fishing_kits_id_fishing_kit`) VALUES ('2', '3');
INSERT INTO `booking_db`.`boat_fishing_kit` (`boat_id_boat`, `fishing_kits_id_fishing_kit`) VALUES ('3', '1');
INSERT INTO `booking_db`.`boat_fishing_kit` (`boat_id_boat`, `fishing_kits_id_fishing_kit`) VALUES ('3', '6');

#adventure_fishing_kit
INSERT INTO `booking_db`.`adventure_fishing_kit` (`adventure_id_adventure`, `fishing_kits_id_fishing_kit`) VALUES ('1', '3');
INSERT INTO `booking_db`.`adventure_fishing_kit` (`adventure_id_adventure`, `fishing_kits_id_fishing_kit`) VALUES ('1', '6');
INSERT INTO `booking_db`.`adventure_fishing_kit` (`adventure_id_adventure`, `fishing_kits_id_fishing_kit`) VALUES ('2', '1');
INSERT INTO `booking_db`.`adventure_fishing_kit` (`adventure_id_adventure`, `fishing_kits_id_fishing_kit`) VALUES ('2', '8');
INSERT INTO `booking_db`.`adventure_fishing_kit` (`adventure_id_adventure`, `fishing_kits_id_fishing_kit`) VALUES ('2', '4');
INSERT INTO `booking_db`.`adventure_fishing_kit` (`adventure_id_adventure`, `fishing_kits_id_fishing_kit`) VALUES ('2', '2');


# RESERVATION STANDARD COTTAGE
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`)
VALUES ('1', 'PAYBACK', '0', '2', '2', '0', '500', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'COTTAGE', '2022-02-01', '14:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`)
VALUES ('2', 'NOT_PAYBACK', '0', '3', '10', '0', '800', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'COTTAGE', '2022-01-28', '10:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`)
 VALUES ('3', 'PAYBACK', '0', '2', '5', '0', '450', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'COTTAGE', '2022-02-10', '09:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`)
 VALUES ('4', 'PAYBACK', '0', '2', '8', '0', '600', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'COTTAGE', '2022-02-02', '07:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`)
VALUES ('5', 'PAYBACK', '0', '4', '7', '0', '450', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'COTTAGE', '2022-02-02', '07:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`)
VALUES ('6', 'PAYBACK', '0', '4', '6', '0', '300', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'COTTAGE', '2022-01-29', '10:00:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('7', 'NOT_PAYBACK', '0', '2', '10', '0', '600', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'COTTAGE', '2022-02-23', '12:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('8', 'PAYBACK', '0', '2', '10', '0', '500', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'COTTAGE', '2022-02-23', '12:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('9', 'PAYBACK', '0', '3', '4', '0', '400', '0', 'NOT_CANCEL', 'ACTION', 'FREE', 'COTTAGE', '2022-02-20', '13:00:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('10', 'NOT_PAYBACK', '0', '2', '1', '0', '300', '0', 'NOT_CANCEL', 'ACTION', 'FREE', 'COTTAGE', '2022-02-20', '15:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('11', 'PAYBACK', '0', '2', '2', '0', '250', '0', 'NOT_CANCEL', 'ACTION', 'FREE', 'COTTAGE', '2022-01-10', '10:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('12', 'PAYBACK', '0', '4', '3', '0', '600', '0', 'NOT_CANCEL', 'ACTION', 'FREE', 'COTTAGE', '2022-02-06', '14:00');



#COTTAGE ID _RES ID
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (1,2);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (2,1);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (3,5);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (4,4);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (5,6);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (2,3);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (2,7);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (4,8);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (1,9);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (2,10);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (2,11);
insert into `booking_db`.`cottage_reservation` (`cottage_id`,`reservation_id`) values (5,12);

#Actionst
INSERT INTO `booking_db`.`actions` (`id_action`, `end_date`, `id_reservation`, `price`, `price_with_discount`, `start_date`) VALUES ('1', '2022-02-23', '9', '400', '250', '2022-02-20');
INSERT INTO `booking_db`.`actions` (`id_action`, `end_date`, `id_reservation`, `price`, `price_with_discount`, `start_date`) VALUES ('2', '2022-02-22', '10', '300', '150', '2022-02-20');
INSERT INTO `booking_db`.`actions` (`id_action`, `end_date`, `id_reservation`, `price`, `price_with_discount`, `start_date`) VALUES ('3', '2022-01-12', '11', '250', '200', '2022-01-10');
INSERT INTO `booking_db`.`actions` (`id_action`, `end_date`, `id_reservation`, `price`, `price_with_discount`, `start_date`) VALUES ('4', '2022-02-10', '12', '600', '400', '2022-02-06');


#Boat standard reservation
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('13', 'PAYBACK', '0', '3', '5', '0', '500', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'BOAT', '2022-02-01', '10:00');
insert into `booking_db`.`boat_reservation`(`boat_id`,`reservation_id`) values (3,13);

INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('14', 'PAYBACK', '0', '6', '5', '0', '800', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'BOAT', '2022-01-30', '09:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('15', 'NOT_PAYBACK', '0', '4', '14', '0', '1200', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'BOAT', '2022-02-01', '10:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('16', 'NOT_PAYBACK', '0', '6', '7', '0', '600', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'BOAT', '2022-02-28', '12:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('17', 'PAYBACK', '0', '3', '7', '0', '500', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'BOAT', '2022-02-28', '12:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('18', 'PAYBACK', '0', '4', '7', '0', '1000', '0', 'NOT_CANCEL', 'STANDARD', 'FREE', 'BOAT', '2022-02-28', '12:00');

insert into `booking_db`.`boat_reservation`(`boat_id`,`reservation_id`) values (2,14);
insert into `booking_db`.`boat_reservation`(`boat_id`,`reservation_id`) values (1,15);
insert into `booking_db`.`boat_reservation`(`boat_id`,`reservation_id`) values (2,16);
insert into `booking_db`.`boat_reservation`(`boat_id`,`reservation_id`) values (3,17);
insert into `booking_db`.`boat_reservation`(`boat_id`,`reservation_id`) values (1,18);

INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('19', 'PAYBACK', '0', '3', '2', '0', '500', '0', 'NOT_CANCEL', 'ACTION', 'FREE', 'BOAT', '2022-03-10', '08:00:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('20', 'PAYBACK', '0', '4', '4', '0', '600', '0', 'NOT_CANCEL', 'ACTION', 'FREE', 'BOAT', '2022-03-11', '16:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('21', 'NOT_PAYBACK', '0', '6', '10', '0', '500', '0', 'NOT_CANCEL', 'ACTION', 'FREE', 'BOAT', '2022-01-01', '12:00');

insert into `booking_db`.`boat_reservation`(`boat_id`,`reservation_id`) values (3,19);
insert into `booking_db`.`boat_reservation`(`boat_id`,`reservation_id`) values (1,20);
insert into `booking_db`.`boat_reservation`(`boat_id`,`reservation_id`) values (2,21);

INSERT INTO `booking_db`.`actions` (`id_action`, `end_date`, `id_reservation`, `price`, `price_with_discount`, `start_date`) VALUES ('5', '2022-01-11', '21', '500', '400', '2022-01-01');
INSERT INTO `booking_db`.`actions` (`id_action`, `end_date`, `id_reservation`, `price`, `price_with_discount`, `start_date`) VALUES ('6', '2022-03-15', '20', '600', '250', '2022-03-11');
INSERT INTO `booking_db`.`actions` (`id_action`, `end_date`, `id_reservation`, `price`, `price_with_discount`, `start_date`) VALUES ('7', '2022-03-12', '21', '500', '150', '2022-01-10');

INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`)
 VALUES (	22,	'NOT_PAYBACK',		0,	4	,10	,0,	600	,0,	'NOT_CANCEL'	,'STANDARD',	'FREE	','ADVENTURE',	'2022-01-28',	'16:00:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`)
VALUES (	23	,'PAYBACK',		0	,2	,3,	0,	450	,0,	'NOT_CANCEL',	'STANDARD',	'FREE',	'ADVENTURE',	'2022-02-02' ,	'13:00:0',0);
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`)
VALUES (		24	,'PAYBACK'	,	0	, 4,	6	,0,	1500,	0,'NOT_CANCEL','STANDARD','FREE','ADVENTURE','2022-02-10','19:00:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`)
VALUES (		25,'PAYBACK'	,	0,	6	,6	,0	,600,	0	,'NOT_CANCEL',	'STANDARD','FREE','ADVENTURE','2022-02-10','19:00');


insert into `booking_db`.`adventure_reservation` (`adventure_id`, `reservation_id`) values (1,22);
insert into `booking_db`.`adventure_reservation` (`adventure_id`, `reservation_id`) values (2,23);
insert into `booking_db`.`adventure_reservation` (`adventure_id`, `reservation_id`) values (1,24);
insert into `booking_db`.`adventure_reservation` (`adventure_id`, `reservation_id`) values (2,25);

INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('26', 'PAYBACK', '0', '6', '1', '0', '500', '0', 'NOT_CANCEL', 'ACTION', 'FREE', 'ADVENTURE', '2022-03-02', '10:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('27', 'NOT_PAYBACK', '0', '4', '2', '0', '400', '0', 'NOT_CANCEL', 'ACTION', 'FREE', 'ADVENTURE', '2022-03-10', '12:00');
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `cancellation_type`, `grade`, `max_persons`, `num_days`, `points`, `price`, `procent`, `reservation_cancel_type`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`) VALUES ('28', 'NOT_PAYBACK', '0', '4', '3', '0', '200', '0', 'NOT_CANCEL', 'ACTION', 'FREE', 'ADVENTURE', '2022-01-02', '10:00');


insert into `booking_db`.`adventure_reservation` (`adventure_id`, `reservation_id`) values (1,27);
insert into `booking_db`.`adventure_reservation` (`adventure_id`, `reservation_id`) values (1,28);
insert into `booking_db`.`adventure_reservation` (`adventure_id`, `reservation_id`) values (2,26);

INSERT INTO `booking_db`.`actions` (`id_action`, `end_date`, `id_reservation`, `price`, `price_with_discount`, `start_date`) VALUES ('8', '2022-03-12', '27', '400', '250', '2022-03-10');
INSERT INTO `booking_db`.`actions` (`id_action`, `end_date`, `id_reservation`, `price`, `price_with_discount`, `start_date`) VALUES ('9', '2022-03-02', '26', '500', '350', '2022-03-02');
INSERT INTO `booking_db`.`actions` (`id_action`, `end_date`, `id_reservation`, `price`, `price_with_discount`, `start_date`) VALUES ('10', '2022-01-05', '28', '200', '150', '2022-01-02');













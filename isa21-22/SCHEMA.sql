insert into authority values(1, 'ROLE_ADMIN');
insert into authority values(2, 'ROLE_USERS');
insert into authority values(3, 'ROLE_BOATOWNER');
insert into authority values(4, 'ROLE_COTTAGEOWNER');
insert into authority values(5, 'ROLE_INSTRUCTOR');

INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('1', 'Internet');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('2', 'Masina za sudje');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('3', 'Fen');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('4', 'TV');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('5', 'Klima');

INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (1, 1, 'Novosadska 1', 'Novi Sad', 'Srbija', 'aa@gmail.com', 'Ana', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '0638754', 'Anic');
INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (2, 1, 'Novosadska 2', 'Novi Sad', 'Srbija', 'sonja@gmail.com', 'Sonja', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '0638754', 'Sonic');

insert into `booking_db`.`user_authority` (user_id, authority_id) values (2,2);
insert into `booking_db`.`user_authority` (user_id, authority_id) values (1,1);
insert into client (id) values (2)
insert into admin (id) values(1)

#reservation

INSERT INTO `booking_db`.`reservation` (`id_reservation`,  `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (1,  4, 420, 'STANDARD', 'FREE', 'COTTAGE', '2022-01-13', '14:00','NOT_CANCEL','PAYBACK',1);
INSERT INTO `booking_db`.`reservation` (`id_reservation`,  `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (2, 2, 500, 'STANDARD', 'FREE', 'COTTAGE', '2022-01-18', '18:00','NOT_CANCEL','NOT_PAYBACK',3);
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (3,  2, 300, 'STANDARD', 'FREE', 'COTTAGE', '2022-01-23', '15:00','NOT_CANCEL','NOT_PAYBACK',5);
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (4,  2, 300, 'ACTION', 'FREE', 'COTTAGE', '2022-01-25',  '16:00','NOT_CANCEL','NOT_PAYBACK',2);

INSERT INTO `booking_db`.`reservation` (`id_reservation`,  `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (5,  4, 500, 'STANDARD', 'FREE', 'BOAT', '2022-02-12',  '17:00','NOT_CANCEL','NOT_PAYBACK',1);
INSERT INTO `booking_db`.`reservation` (`id_reservation`,  `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`,`reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (6,  4, 600, 'ACTION', 'FREE', 'BOAT', '2022-02-17', '13:00','NOT_CANCEL','PAYBACK',4);
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (7,  4, 600, 'STANDARD', 'FREE', 'BOAT', '2022-02-20', '10:00', 'NOT_CANCEL','NOT_PAYBACK',1);

INSERT INTO `booking_db`.`reservation` (`id_reservation`,  `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`,`reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (8,  2, 200, 'ACTION', 'FREE', 'INSTRUCTOR', '2022-01-25',  '11:00','NOT_CANCEL','PAYBACK',2);
INSERT INTO `booking_db`.`reservation` (`id_reservation`, `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (9, 2, 250, 'STANDARD', 'FREE', 'INSTRUCTOR', '2022-01-22', '19:00','NOT_CANCEL','PAYBACK',3);
INSERT INTO `booking_db`.`reservation` (`id_reservation`,  `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (10,  4, 500, 'STANDARD', 'FREE', 'INSTRUCTOR', '2022-01-20',  '14:00','NOT_CANCEL','NOT_PAYBACK',4);

INSERT INTO `booking_db`.`reservation` (`id_reservation`, `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (11,  3, 800, 'STANDARD', 'FREE', 'COTTAGE', '2022-01-25', '16:00','NOT_CANCEL','NOT_PAYBACK',3);
INSERT INTO `booking_db`.`reservation` (`id_reservation`,  `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (12,  4, 300, 'STANDARD', 'FREE', 'COTTAGE', '2022-01-13', '14:00','NOT_CANCEL','PAYBACK',1);
INSERT INTO `booking_db`.`reservation` (`id_reservation`,  `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (13,  4, 400, 'STANDARD', 'FREE', 'COTTAGE', '2022-01-13', '14:00','NOT_CANCEL','NOT_PAYBACK',1);
INSERT INTO `booking_db`.`reservation` (`id_reservation`,  `max_persons`, `price`, `reservation_fast_type`, `reservation_status`, `reservation_type`, `start_date`, `start_time`, `reservation_cancel_type`,`cancellation_type`,`num_days`) VALUES (14,  5, 400, 'STANDARD', 'FREE', 'COTTAGE', '2022-01-13', '14:00','NOT_CANCEL','NOT_PAYBACK',1);

#Cottage
INSERT INTO `booking_db`.`cotagge` (`id_cottage`, `address`, `grade`, `info`, `name`, `num_bed`, `num_room`, `price`, `promo_description`) VALUES ('1', 'Novosadska 3', '8', 'Nema neke dodatne.', 'Vila Elsa', '2', '3', '120', 'Acc');
INSERT INTO `booking_db`.`cotagge` (`id_cottage`, `address`, `grade`, `info`, `name`, `num_bed`, `num_room`, `price`, `promo_description`) VALUES ('2', 'Gagarinova 5', '9', 'No', 'Sonja ', '5', '2', '500', 'aaa');
INSERT INTO `booking_db`.`cotagge` (`id_cottage`, `address`, `grade`, `info`, `name`, `num_bed`, `num_room`, `price`, `promo_description`) VALUES ('3', 'Skolska 4', '10', 'Ambaar', 'Krofnica', '2', '1', '200', 'ccc');
INSERT INTO `booking_db`.`cotagge` (`id_cottage`, `address`, `grade`, `info`, `name`, `num_bed`, `num_room`, `price`, `promo_description`) VALUES ('4', 'Partizanska 1', '7', 'VOtka', 'Boska', '1', '1', '150', 'vvv');
INSERT INTO `booking_db`.`cotagge` (`id_cottage`, `address`, `grade`, `info`, `name`, `num_bed`, `num_room`, `price`, `promo_description`) VALUES ('5', 'Ambasadorska 10', '8.5', 'Ser', 'Kleopatra', '3', '2', '200', 'aaaaaaa');

#cottage_reservation
insert into booking_db.cottage_reservation (`cottage_id`, `reservation_id`) values (1, 2);
insert into booking_db.cottage_reservation (`cottage_id`, `reservation_id`) values (2, 3);
insert into booking_db.cottage_reservation (`cottage_id`, `reservation_id`) values (3, 1);
insert into booking_db.cottage_reservation (`cottage_id`, `reservation_id`) values (1, 11);
insert into booking_db.cottage_reservation (`cottage_id`, `reservation_id`) values (2, 4);
insert into booking_db.cottage_reservation (`cottage_id`, `reservation_id`) values (3, 12);
insert into booking_db.cottage_reservation (`cottage_id`, `reservation_id`) values (4, 13);
insert into booking_db.cottage_reservation (`cottage_id`, `reservation_id`) values (5, 14);
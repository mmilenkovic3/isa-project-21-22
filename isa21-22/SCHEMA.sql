insert into authority values(1, 'ROLE_ADMIN');
insert into authority values(2, 'ROLE_USER');
insert into authority values(3, 'ROLE_BOATOWNER');
insert into authority values(4, 'ROLE_COTTAGEOWNER');
insert into authority values(5, 'ROLE_INSTRUCTOR');

INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('1', 'Internet');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('2', 'Masina za sudje');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('3', 'Fen');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('4', 'TV');
INSERT INTO `booking_db`.`staff` (`id_staff`, `name`) VALUES ('5', 'Klima');

INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (1, 1, 'Novosadska 1', 'Novi Sad', 'Srbija', 'aa@gmail.com', 'Ana', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '0638754', 'Anic');
insert into booking_db.user_authority (user_id, authority_id) values(1,1)

INSERT INTO `booking_db`.`users` (`id`, `account_enabled`, `address`, `city`, `country`, `email`, `name`, `password`, `phone_number`, `surname`) VALUES (2, 1, 'Novosadska 2', 'Novi Sad', 'Srbija', 'sonja@gmail.com', 'Sonja', '$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6', '0638754', 'Sonic');
insert into booking_db.user_authority (user_id, authority_id) values(2,2)
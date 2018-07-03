/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.5.52-MariaDB : Database - polyclinic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`polyclinic` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `polyclinic`;

/*Table structure for table `doctor` */

DROP TABLE IF EXISTS `doctor`;

CREATE TABLE `doctor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `num_ap` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phones` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `specialization` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `station_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK18ol1khga6nxf2m09ce8nsrhs` (`station_id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `doctor` */

insert  into `doctor`(`id`,`full_name`,`num_ap`,`phones`,`specialization`,`station_id`) values 
(17,'Иванов И.П.','110','(097) 123-54-32','Терапевт-участковый',38),
(18,'Шмиголь В.П. ','111','(098) 238-58-23','Терапевт-участковый',45),
(19,'Рицик А.О.','313','(050) 234-99-02','Терапевт-участковый',41),
(20,'Павелкив Н.В.','323','(066) 323-55-33','Кардиолог',NULL),
(21,'Чайковская И.С.','324','(099) 434-74-72','Эндокринолог',NULL),
(22,'Зубрис Н.В.','306','(095) 429-95-01','Гастроэнтеролог',NULL),
(23,'Рыбалко В.В.','308','(073) 842-99-05','Хирург',NULL),
(24,'Зуева Г.И. ','310','(099) 942-58-18','Травматолог',NULL),
(25,'Новицкая Е.А.','326','(050) 415-85-81','Окулист',NULL),
(26,'Ткаченко А.М.','417','(093) 002-31-51','ЛОР',NULL);

/*Table structure for table `doctor_patients` */

DROP TABLE IF EXISTS `doctor_patients`;

CREATE TABLE `doctor_patients` (
  `doctor_id` bigint(20) NOT NULL,
  `patients_id` bigint(20) NOT NULL,
  PRIMARY KEY (`doctor_id`,`patients_id`),
  UNIQUE KEY `UK_6s26o6r8wft61kauac80aytbb` (`patients_id`),
  UNIQUE KEY `unq_doctor_patients_doctor_id` (`doctor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `doctor_patients` */

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adress` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `complaints` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `diagnosis` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `full_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phones` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `doctor_id` bigint(20) DEFAULT NULL,
  `station_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_patient_birth_date` (`birth_date`),
  KEY `FKmer5utvy1hiff7ovs6f4bjtnw` (`doctor_id`),
  KEY `FKkxm3irw7pgmy7kw5r9l8esw89` (`station_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `patient` */

insert  into `patient`(`id`,`adress`,`birth_date`,`complaints`,`diagnosis`,`full_name`,`phones`,`doctor_id`,`station_id`) values 
(1,'ул. Иванова 34 кв. 44','1981-05-11','Повышенное давление','-','Геращенко В.П.','(099) 100-33-01',17,38),
(3,'Донецкая 33','1972-05-25','Боли в животе','Язва','Орехов А.У.','(099) 999-14-99',22,41),
(5,'ул. Рабочая 181','1992-07-22','Стал хуже видеть левый глаз','Катаракта','Рахимов А.О.','(093) 414-15-77',25,39),
(6,'пр-т. св.Кирилла и Мефодия 4 кв. 104','1992-10-23','Пропал аппетит','Направление к гастроэнтерологу','Долматов Ф.Е.','(095) 743-58-22',18,45),
(7,'ул. Лавренева 6 кв. 51','1996-05-24','Красное горло, больно глотать','Ангина','Егоров Р.В.','(095) 476-16-44',26,46);

/*Table structure for table `reception` */

DROP TABLE IF EXISTS `reception`;

CREATE TABLE `reception` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `begin_date_time` datetime DEFAULT NULL,
  `doctor_id` bigint(20) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ssqraklqu7bphxhmaofyrk4y` (`doctor_id`),
  KEY `FKe3t7e0y7c5me32wnf115nigep` (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `reception` */

insert  into `reception`(`id`,`begin_date_time`,`doctor_id`,`patient_id`) values 
(56,'2018-05-28 13:30:00',18,3),
(55,'2018-05-11 11:45:00',25,6),
(54,'2018-05-25 09:00:00',24,5),
(53,'2018-05-18 15:10:00',23,3),
(52,'2018-05-26 10:00:00',20,1),
(51,'2018-05-22 15:25:00',17,7),
(50,'2018-05-24 14:15:00',17,5),
(48,'2018-05-14 12:54:00',17,1);

/*Table structure for table `schedule` */

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fri` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `thu` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tue` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `web` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `doctor_id` bigint(20) DEFAULT NULL,
  `sat` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FKqixlhugy7jvrwut9o2s6hqnu8` (`doctor_id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `schedule` */

insert  into `schedule`(`id`,`fri`,`mon`,`thu`,`tue`,`web`,`doctor_id`,`sat`) values 
(2,'08:00 - 12:30','08:00 - 12:30','08:00 - 12:30','-','-',17,'-'),
(14,'-','-','08:00 - 12:30','-','12:00 - 16:00',19,'08:00 - 12:30'),
(13,'08:30 - 12:00','08:30 - 12:00','12:00 - 15:30','12:00 - 15:30','08:30 - 12:00',18,'12:00 - 15:30'),
(15,'08:00 - 12:30','08:00 - 12:30','-','-','08:00 - 12:30',20,'-'),
(16,'-','12:00 - 16:00','12:00 - 16:00','12:00 - 16:00','-',21,'12:00 - 16:00'),
(17,'12:00 - 16:00','12:00 - 16:00','12:00 - 16:00','12:00 - 16:00','-',22,'-'),
(18,'08:00 - 12:00','08:00 - 12:00','12:00 - 16:00','08:00 - 12:00','12:00 - 16:00',23,'-'),
(19,'08:00 - 12:00','08:00 - 12:00','-','-','08:00 - 12:00',24,'08:00 - 12:00'),
(20,'12:00 - 16:00','-','-','08:00 - 12:00','08:00 - 12:00',25,'-'),
(21,'08:00 - 12:00','-','-','08:00 - 12:00','08:00 - 12:00',26,'-');

/*Table structure for table `station` */

DROP TABLE IF EXISTS `station`;

CREATE TABLE `station` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `streets` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `station` */

insert  into `station`(`id`,`streets`) values 
(46,'ул. Благоева, ул. Лавренева'),
(45,'пр-т. св.Кирилла и Мефодия'),
(44,'ул. Комкова, пр-т. Строителей'),
(38,'ул Иванова'),
(39,'ул. Рабочая (от ул. Макарова)'),
(40,'ул. 1-я Западная, ул. 2-я Западная, ул. 3-я Западная, ул. 4-я Западная, ул. 5-я Западная, '),
(41,'ул. Донецкая, пер. Макеевский'),
(42,'ул. Ивана Богуна (быв. Ильича)'),
(43,'ул. Москвина, ул. Шумская, ул. Леси Украинки, ул. Качалова'),
(47,'ул. Фонтанная');

/*Table structure for table `station_doctors` */

DROP TABLE IF EXISTS `station_doctors`;

CREATE TABLE `station_doctors` (
  `station_id` bigint(20) NOT NULL,
  `doctors_id` bigint(20) NOT NULL,
  PRIMARY KEY (`station_id`,`doctors_id`),
  UNIQUE KEY `UK_tfeodb18ou4fsgmmr6a50wgbt` (`doctors_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `station_doctors` */

/*Table structure for table `station_patients` */

DROP TABLE IF EXISTS `station_patients`;

CREATE TABLE `station_patients` (
  `station_id` bigint(20) NOT NULL,
  `patients_id` bigint(20) NOT NULL,
  PRIMARY KEY (`station_id`,`patients_id`),
  UNIQUE KEY `UK_33phtkxb8hr74deotr4j0jfgd` (`patients_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `station_patients` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

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
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `doctor` */

/*Table structure for table `doctor_patients` */

DROP TABLE IF EXISTS `doctor_patients`;

CREATE TABLE `doctor_patients` (
  `doctor_id` bigint(20) NOT NULL,
  `patients_id` bigint(20) NOT NULL,
  PRIMARY KEY (`doctor_id`,`patients_id`),
  UNIQUE KEY `UK_6s26o6r8wft61kauac80aytbb` (`patients_id`)
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
  KEY `FKmer5utvy1hiff7ovs6f4bjtnw` (`doctor_id`),
  KEY `FKkxm3irw7pgmy7kw5r9l8esw89` (`station_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `patient` */

/*Table structure for table `station` */

DROP TABLE IF EXISTS `station`;

CREATE TABLE `station` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `streets` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `station` */

insert  into `station`(`id`,`streets`) values 
(1,'ул Магара, ул Мира'),
(6,'пр-т Строителей, ул. Лавренева'),
(4,'ул Южная, ул Совхозная, ул Заднепровская'),
(7,'ул. Рабочая (от ул. Макарова)'),
(8,'ул. Ивана Богуна '),
(9,'ул 1-я Западная, ул. 2 Западная, ул 3-я Западная, ул 4-я Западная, ул 5-я Западная,'),
(10,'пр-т. Св. Кирилла и Мефодия'),
(11,'ул. Донецкая'),
(12,'ул. Москвина, ул. Шумская, ул. Леси Украинки'),
(13,'ул. Комкова, ул. Качалова, ул. Перова'),
(14,'ул. Благоева, ул. Фонтанная');

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

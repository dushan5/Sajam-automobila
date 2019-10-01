/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 5.7.21 : Database - sajamautomobila
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sajamautomobila` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sajamautomobila`;

/*Table structure for table `grad` */

DROP TABLE IF EXISTS `grad`;

CREATE TABLE `grad` (
  `sifraGrada` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nazivGrada` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sifraGrada`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `grad` */

insert  into `grad`(`sifraGrada`,`nazivGrada`) values 
(0,'Beograd'),
(1,'Kragujevac'),
(2,'Leipzig'),
(3,'Dortmund'),
(4,'Wolfsburg'),
(5,'Munchen'),
(6,'Frankfurt'),
(7,'Mannheim'),
(8,'Ingolstadt'),
(9,'Bremen'),
(10,'Detroit, Michigan'),
(11,'Kansas City, Kansas'),
(12,'Warren, Ohio'),
(13,'Louisville, Kentucky'),
(14,'Chicago, Illinois'),
(15,'Toledo, Ohio'),
(16,'Fremont, California'),
(17,'San Antonio, Texas'),
(18,'Kosovska Mitrovica'),
(19,'Tokyo'),
(20,'Yokohama'),
(21,'Osaka'),
(22,'Kyoto'),
(23,'Paris');

/*Table structure for table `modelautomobila` */

DROP TABLE IF EXISTS `modelautomobila`;

CREATE TABLE `modelautomobila` (
  `sifraModelaAutomobila` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sifraProizvodjaca` bigint(20) unsigned NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `godinaNastanka` int(4) DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `vrednostModela` double DEFAULT NULL,
  `sifraTipaModela` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`sifraModelaAutomobila`,`sifraProizvodjaca`),
  KEY `sifraUmetnickogDela` (`sifraProizvodjaca`),
  KEY `tipUmetnickogDela` (`sifraTipaModela`),
  CONSTRAINT `modelautomobila_ibfk_2` FOREIGN KEY (`sifraTipaModela`) REFERENCES `tipmodelaautomobila` (`sifraTipaModela`) ON DELETE SET NULL,
  CONSTRAINT `modelautomobila_ibfk_3` FOREIGN KEY (`sifraProizvodjaca`) REFERENCES `proizvodjac` (`sifraProizvodjaca`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

/*Data for the table `modelautomobila` */

insert  into `modelautomobila`(`sifraModelaAutomobila`,`sifraProizvodjaca`,`naziv`,`godinaNastanka`,`opis`,`vrednostModela`,`sifraTipaModela`) values 
(27,16,'Focus',2008,'Porodicni kompaktan automobil za gradsku voznju',350000,1),
(28,14,'Corola',2001,'Standardan gradski automobil',400000,2),
(29,16,'Fiesta',2005,'Izdrzljiv i prilagodljiv automobil za svakodnevno koriscenje',380000,1),
(30,22,'A8',2010,'Poslednji model iz A serije',520000,4),
(31,22,'Q8',2014,'Odlicne performanse u svim vremenskim uslovima i na razlicitim terenima',580000,6),
(32,22,'R8',2015,'Proglasen za automobil godine u svojoj kategoriji ',750000,3),
(33,17,'CLS Coupe',2014,'Standardan i prepoznatljiv kvalitet nemackih luksuznih automobila ',750000,4),
(34,17,'GLS',2013,'Dostupan samo na trzistu Zapadne Evrope',550000,6),
(35,18,'Lancer',2006,'Model koji je proslavio brend Mitsubishi i uvrstio ga u sam vrh u Japanu',300000,3),
(38,20,'Impreza',2007,'Subaruov najpopularniji model ',290000,3),
(39,18,'Eclipse',2012,'Odlican odnos cene i kvaliteta',350000,5);

/*Table structure for table `modelnasajmu` */

DROP TABLE IF EXISTS `modelnasajmu`;

CREATE TABLE `modelnasajmu` (
  `sifraProizvodjaca` bigint(20) unsigned NOT NULL,
  `sifraModelaAutomobila` bigint(20) unsigned NOT NULL,
  `sifraPostavke` bigint(20) unsigned NOT NULL,
  `oznakaModela` int(11) DEFAULT NULL,
  PRIMARY KEY (`sifraProizvodjaca`,`sifraModelaAutomobila`,`sifraPostavke`),
  KEY `sifraUmetnickogDela` (`sifraModelaAutomobila`),
  KEY `sifraIzlozbe` (`sifraPostavke`),
  CONSTRAINT `modelnasajmu_ibfk_1` FOREIGN KEY (`sifraProizvodjaca`) REFERENCES `modelautomobila` (`sifraProizvodjaca`) ON DELETE CASCADE,
  CONSTRAINT `modelnasajmu_ibfk_2` FOREIGN KEY (`sifraModelaAutomobila`) REFERENCES `modelautomobila` (`sifraModelaAutomobila`) ON DELETE CASCADE,
  CONSTRAINT `modelnasajmu_ibfk_3` FOREIGN KEY (`sifraPostavke`) REFERENCES `postavka` (`sifraPostavke`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `modelnasajmu` */

insert  into `modelnasajmu`(`sifraProizvodjaca`,`sifraModelaAutomobila`,`sifraPostavke`,`oznakaModela`) values 
(14,28,22,5),
(16,27,21,6),
(17,33,13,2),
(17,33,14,1),
(17,33,16,1),
(17,33,17,2),
(17,33,21,1),
(17,34,13,3),
(17,34,15,2),
(17,34,17,5),
(17,34,21,3),
(17,34,22,2),
(18,35,14,3),
(18,35,16,5),
(18,35,22,3),
(18,39,13,5),
(18,39,17,3),
(18,39,19,1),
(18,39,22,4),
(20,38,13,6),
(20,38,17,4),
(22,30,13,1),
(22,30,14,5),
(22,30,17,1),
(22,30,19,2),
(22,30,21,5),
(22,30,22,1),
(22,31,15,1),
(22,31,20,1),
(22,31,21,4),
(22,32,16,4),
(22,32,21,2);

/*Table structure for table `postavka` */

DROP TABLE IF EXISTS `postavka`;

CREATE TABLE `postavka` (
  `sifraPostavke` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `datumOd` date DEFAULT NULL,
  `datumDo` date DEFAULT NULL,
  `sifraGrada` bigint(20) unsigned DEFAULT NULL,
  `sifraZaposlenog` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`sifraPostavke`),
  KEY `sifraGrada` (`sifraGrada`),
  KEY `sifraZaposlenog` (`sifraZaposlenog`),
  CONSTRAINT `postavka_ibfk_1` FOREIGN KEY (`sifraGrada`) REFERENCES `grad` (`sifraGrada`) ON DELETE CASCADE,
  CONSTRAINT `postavka_ibfk_2` FOREIGN KEY (`sifraZaposlenog`) REFERENCES `zaposleni` (`sifraZaposlenog`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `postavka` */

insert  into `postavka`(`sifraPostavke`,`naziv`,`datumOd`,`datumDo`,`sifraGrada`,`sifraZaposlenog`) values 
(13,'Minhenski internacionalni sajam','2018-03-06','2018-03-30',5,1),
(14,'Novogodisnji sajam sa popustima','2018-12-27','2019-01-08',10,1),
(15,'Medjunarodni sajam SUV vozila','2019-06-12','2019-06-28',12,1),
(16,'Tradicionalni beogradski sajam','2019-03-24','2019-03-31',0,1),
(17,'Iternationale Automobil-Ausstellung','2019-09-03','2019-09-19',6,1),
(18,' Paris Mondial de l’ Automobile)','2018-10-01','2018-10-16',23,1),
(19,'Sajam Zapadne Amerike','2019-03-21','2019-03-29',17,1),
(20,'aa','2019-03-19','2019-03-28',0,1),
(21,'Minhenski internacionalni sajam8989898','2019-04-06','2019-04-16',5,1),
(22,'Postavka sep-okt 19','2019-09-24','2019-10-10',6,1);

/*Table structure for table `proizvodjac` */

DROP TABLE IF EXISTS `proizvodjac`;

CREATE TABLE `proizvodjac` (
  `sifraProizvodjaca` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(20) DEFAULT NULL,
  `osnivac` varchar(50) DEFAULT NULL,
  `rukovodilac` varchar(50) DEFAULT NULL,
  `info` varchar(100) DEFAULT NULL,
  `kontakt` varchar(15) DEFAULT NULL,
  `sifraGrada` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`sifraProizvodjaca`),
  KEY `cityFK` (`sifraGrada`),
  CONSTRAINT `cityFK` FOREIGN KEY (`sifraGrada`) REFERENCES `grad` (`sifraGrada`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `proizvodjac` */

insert  into `proizvodjac`(`sifraProizvodjaca`,`naziv`,`osnivac`,`rukovodilac`,`info`,`kontakt`,`sifraGrada`) values 
(14,'Toyota','Kiichiro Toyoda','Akio Toyoda ','Trenutno najprodavaniji i najpopularniji brend na svetu','0666392665',19),
(16,'Ford','Henry Ford','James Hackett','Duga tradicija i pouzdan kvalitet','063528234',15),
(17,'Mercedes-Benz','Karl Benz','Dieter Zetsche','Najpoznatiji luksuzni nemacki brend','0666352449',9),
(18,'Mitsubishi','Mitsubishi heavy industries','Osamu Masuko','2012. bio je 19. najprodavaniji automobil na svetu, 6. u Japanu','0611234561',21),
(19,'Nissan','Yoshisuke Aikawa','Hiroto Saikawa','Japanski multinacionalni proizvodjac sa sedistem u Osaki','0621234567',20),
(20,'Subaru','Endo Kagasuke','Mori Ikuo','Nadredjena organizacije mu je Tojota','0653321311',19),
(22,'Audi','August Horh','Torsten Hamman','Nemacki proizvodjac luksuznih automobila i clan Volkswagen grupacije','0632546541',8),
(24,'Peugeot','Armand Peugeot','Carlos Tavares','Francusko preduzece osnovano davne 1896. godine u Parizu ','0621212123',23);

/*Table structure for table `tipmodelaautomobila` */

DROP TABLE IF EXISTS `tipmodelaautomobila`;

CREATE TABLE `tipmodelaautomobila` (
  `sifraTipaModela` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nazivTipaModela` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sifraTipaModela`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `tipmodelaautomobila` */

insert  into `tipmodelaautomobila`(`sifraTipaModela`,`nazivTipaModela`) values 
(1,'porodicni'),
(2,'gradski'),
(3,'sportski'),
(4,'luksuzni'),
(5,'konvertibilni'),
(6,'SUV'),
(7,'pikap'),
(8,'super');

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `sifraZaposlenog` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) DEFAULT NULL,
  `prezime` varchar(20) DEFAULT NULL,
  `jmbg` varchar(13) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sifraZaposlenog`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`sifraZaposlenog`,`ime`,`prezime`,`jmbg`,`email`,`username`,`password`) values 
(1,'Dusan','Kojanic','1311994220036','dusan@gmail.com','dusan','dusan'),
(2,'Pera','Peric','0909988456738','pera@gmail.com','pera','pera');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

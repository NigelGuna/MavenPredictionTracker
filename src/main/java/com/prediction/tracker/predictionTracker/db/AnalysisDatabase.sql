-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: analysis
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.30-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `february`
--

DROP TABLE IF EXISTS `february`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `february` (
  `bet_id` int(11) NOT NULL AUTO_INCREMENT,
  `match_date` date DEFAULT NULL,
  `team_one` varchar(255) DEFAULT NULL,
  `team_two` varchar(255) DEFAULT NULL,
  `prediction` varchar(255) DEFAULT NULL,
  `is_correct` varchar(255) DEFAULT NULL,
  `bet_amount` decimal(10,2) DEFAULT '0.00',
  `profit_or_loss` decimal(10,2) DEFAULT '0.00',
  `other_notes` varchar(255) DEFAULT NULL,
  `bet_odds` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`bet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `february`
--

LOCK TABLES `february` WRITE;
/*!40000 ALTER TABLE `february` DISABLE KEYS */;
INSERT INTO `february` VALUES (1,'2019-02-12','Vici Gaming','Room310','Vici Gaming','yes',0.00,0.00,'unsure',0.00),(2,'2019-02-12','Aster','Vici Gaming','Aster','No',0.00,0.00,'unsure',0.00),(3,'2019-02-12','OG','Vega','OG','Yes',0.00,0.00,'sure',0.00),(4,'2019-02-12','Alliance','Kaban','Alliance','Yes',0.00,0.00,'sure',0.00),(5,'2019-02-12','Gambit','ThePango','Gambit','Yes',0.00,0.00,'unsure',0.00),(6,'2019-02-12','NIP','Empire','NIP','Yes',0.00,0.00,'sure',0.00),(7,'2019-02-13','The Pango','Winstrike','Winstrike','string',0.00,0.00,'unsure',0.00),(8,'2019-02-13','NIP','Gambit','NIP','string',0.00,0.00,'sure',0.00),(9,'2019-02-13','Vega','Pavaga','Vega','string',0.00,0.00,'yolo',0.00);
/*!40000 ALTER TABLE `february` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-13 14:58:18

-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: petclinic2
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `surname` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(150) CHARACTER SET ascii COLLATE ascii_general_ci DEFAULT NULL,
  `mobilephone` varchar(150) CHARACTER SET ascii COLLATE ascii_general_ci DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `address` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `area` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pobox` varchar(25) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `note1` varchar(600) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `note2` varchar(600) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `note3` varchar(600) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--
-- ORDER BY:  `id`

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'ΟΝΟΜΑ','ΕΠΩΝΥΜΟ','test@test.com','1234567890','1234567890','2021-11-02',NULL,'ΔΡΟΜΟΣ','ΑΘΗΝΑ','12345','ΕΛΛΑΔΑ','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed venenatis, nulla id eleifend varius, mi nulla blandit nunc, ac dictum libero sem sed leo. Nulla convallis gravida ante, quis blandit leo volutpat sed. Suspendisse rutrum nisl ac neque efficitur, id egestas ex scelerisque. Proin nec sapien ac dui venenatis gravida in ut leo. Proin vel aliquam justo. Mauris fringilla mi nec libero accumsan congue. Phasellus id interdum est, in luctus magna. ','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed venenatis, nulla id eleifend varius, mi nulla blandit nunc, ac dictum libero sem sed leo. ','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed venenatis, nulla id eleifend varius, mi nulla blandit nunc, ac dictum libero sem sed leo. ');
INSERT INTO `customer` VALUES (2,'GewCustomerg2','GewCustomerg2','test@test.com','1234567890','1234567890','2021-11-02',NULL,NULL,NULL,NULL,NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed venenatis, nulla id eleifend varius, mi nulla blandit nunc, ac dictum libero sem sed leo. ',NULL,NULL);
INSERT INTO `customer` VALUES (3,'GewCustomerg2','EewCustomerg2','test@test.com','1234567890','1234567890','2021-11-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `customer` VALUES (4,'GewCustomerg1','EewCustomerg1','test@test.com','1234567890','1234567890','2021-11-02',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed venenatis, nulla id eleifend varius, mi nulla blandit nunc, ac dictum libero sem sed leo. ');
INSERT INTO `customer` VALUES (5,'MewCustomerg1','MewCustomerg1','test@test.com','1234567890','1234567890','2021-11-02',NULL,NULL,NULL,NULL,NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed venenatis, nulla id eleifend varius, mi nulla blandit nunc, ac dictum libero sem sed leo. ','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed venenatis, nulla id eleifend varius, mi nulla blandit nunc, ac dictum libero sem sed leo. ',NULL);
INSERT INTO `customer` VALUES (6,'ColCustomerg1','ColSCustomerg1','test@test.com','1234567890','1234567890','2022-02-02',NULL,NULL,NULL,NULL,NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed venenatis, nulla id eleifend varius, mi nulla blandit nunc, ac dictum libero sem sed leo. ',NULL,NULL);
INSERT INTO `customer` VALUES (7,'ColCustomerg1New','ColSCustomerg1NEW','newtest@test.com','1234567890','1234567890','2022-03-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `customer` VALUES (8,'dfsgmen','fdsfgf','','210123456789','210123456789','2022-03-18',NULL,'fsdffgdf','Kaisariani','16121','Greece','A note1','A note 2','A third note');
INSERT INTO `customer` VALUES (9,'GmenColCustomerg1New','GmenColSCustomerg1NEW','Gmennewtest@test.com','1234567890','1234567890','2022-03-18',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `customer` VALUES (10,'dfsdfs','dsfsdfs','','213432432454','231243343124','2022-03-18',NULL,'fsdfsdfsdf','2312egfge','233434','grgerger','','','');
INSERT INTO `customer` VALUES (11,'ΓΙΩΡΓΟΣ','ΜΕΝΤΖΙΚΩΦ','gmentzik@gmail.com','2112222222','6975111111','2022-03-20',NULL,'ΑΔΡΙΑΝΟΥΠΟΛITSAS 76','ΚΑΙΣΑΡΙΑΝΗ','1611','Ελλαδα','','','');
INSERT INTO `customer` VALUES (12,'ΓΙΩΡΓΟΣ','ΑΠΟΣΤΟΛΑΚΗΣ','mmdk@mkkmk.com','1212121212','0123456789','2022-04-29',NULL,'ΚΟΥΚΟΥΝΑΡΙΩΝ 26','ΒΡΙΛΛΙΣΙΑ','12356','ΕΛΛΑΔΑ','','','');
INSERT INTO `customer` VALUES (13,'ΤΕΣΤ','ΤΕΣΤ','','01234569789','01234569789','2022-04-30',NULL,'ΤΕΣΤ','ΤΕΣΤ','ΤΕΣΤ','ΤΕΣΤ','','','');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--
-- ORDER BY:  `installed_rank`

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','init','SQL','V1__init.sql',794732228,'root','2021-10-30 19:14:03',530,1);
INSERT INTO `flyway_schema_history` VALUES (2,'2','user table','SQL','V2__user_table.sql',1734379376,'root','2021-10-30 19:14:03',205,1);
INSERT INTO `flyway_schema_history` VALUES (3,'3','add users and roles','SQL','V3__add_users_and_roles.sql',-305824301,'root','2021-10-30 19:14:03',16,1);
INSERT INTO `flyway_schema_history` VALUES (4,'4','add columns to customer table','SQL','V4__add_columns_to_customer_table.sql',943477843,'root','2022-02-02 19:40:45',82,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `species` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gender` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `par_ind` (`customer_id`),
  CONSTRAINT `FK_customerId` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--
-- ORDER BY:  `id`

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pethistory`
--

DROP TABLE IF EXISTS `pethistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pethistory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pet_id` int NOT NULL,
  `date` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `text` text COLLATE utf8mb4_unicode_ci,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `par_ind` (`pet_id`),
  CONSTRAINT `FK_PetId` FOREIGN KEY (`pet_id`) REFERENCES `pet` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pethistory`
--
-- ORDER BY:  `id`

LOCK TABLES `pethistory` WRITE;
/*!40000 ALTER TABLE `pethistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `pethistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--
-- ORDER BY:  `id`

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN');
INSERT INTO `roles` VALUES (2,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--
-- ORDER BY:  `id`

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6',1);
INSERT INTO `user` VALUES (2,'user','$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6',1);
INSERT INTO `user` VALUES (4,'george2','$2a$10$VRaj7NyJP5q3DHE6Bv3ty.OkQU.9REk.xTzECEy97fCwrrl3T32Lm',1);
INSERT INTO `user` VALUES (5,'george3','$2a$10$ij5b7xdAXnFWTUE3cr9kHOQglHSL4CjChmTrPRcP6I9aLsYFCDatS',1);
INSERT INTO `user` VALUES (6,'admin2','$2a$10$GN2poVal3oT8sNKQuiNnbOMdaB9EXw3vR5utYoHZCIvy6mQLMDfZO',1);
INSERT INTO `user` VALUES (7,'admin3','$2a$10$PIlt4KeczilkgG9ikv5z6O1xHKJFz1kE61SEMsQC4SC.Nea.t8WGe',1);
INSERT INTO `user` VALUES (8,'admin4','$2a$10$Ytm08M2cdkMMapuFfPW13uGTvpaksMk44d/xstzhb/nfhpCMN4fme',1);
INSERT INTO `user` VALUES (9,'admin5','$2a$10$7AXzWAoryQSELBm22klYq.PJ.KebqjHkaJRjwXUC/OpG6.jV5o54W',1);
INSERT INTO `user` VALUES (10,'admin6','$2a$10$x49RV0c0ALEHez9odEhERebgGFb4/o3OG0OcAPbs65apPQEmqB1hK',1);
INSERT INTO `user` VALUES (11,'admin7','$2a$10$jI9IRjL2obcnmlXilVJqV.dTX.d3iEEYYL3znuFALFLT2UPo6/5g.',1);
INSERT INTO `user` VALUES (12,'admin8','$2a$10$E5vEXKFVXvgbgsZKJDFhMOLQaIfKfMqBjPTB4dvDN7THFyz05Xd/6',1);
INSERT INTO `user` VALUES (13,'admin9','$2a$10$QjveqfqPh49l3fKB9jI0jOa3ev3JyGhYzmwSzVNCR7S9tnif9Aabu',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1);
INSERT INTO `users_roles` VALUES (2,2);
INSERT INTO `users_roles` VALUES (4,2);
INSERT INTO `users_roles` VALUES (5,2);
INSERT INTO `users_roles` VALUES (6,1);
INSERT INTO `users_roles` VALUES (7,1);
INSERT INTO `users_roles` VALUES (8,2);
INSERT INTO `users_roles` VALUES (9,2);
INSERT INTO `users_roles` VALUES (10,1);
INSERT INTO `users_roles` VALUES (11,1);
INSERT INTO `users_roles` VALUES (12,1);
INSERT INTO `users_roles` VALUES (13,1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-23 18:12:34

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `surname` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL ,
  `phone` varchar(150) CHARACTER SET ascii COLLATE ascii_general_ci DEFAULT NULL,
  `mobilephone` varchar(150) CHARACTER SET ascii COLLATE ascii_general_ci DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `pets`
--

DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `species` varchar(200) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY par_ind (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `pethistory`
--

DROP TABLE IF EXISTS `pethistory`;
CREATE TABLE `pethistory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pet_id` int NOT NULL,
  `date` varchar(200) NOT NULL,
  `text` text,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY par_ind (pet_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE pet
ADD CONSTRAINT `FK_customerId` FOREIGN KEY (`customer_id`) 
REFERENCES `customer` (`id`);

ALTER TABLE pethistory
ADD CONSTRAINT `FK_PetId` FOREIGN KEY (`pet_id`) 
REFERENCES `pet` (`id`);
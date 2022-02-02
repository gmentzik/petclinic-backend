--
-- ADD NEW COLUMNS TO CUSTOMERS TABLE
--
	ALTER TABLE `customer`
	ADD `address` varchar(150) DEFAULT NULL,
	ADD `area` varchar(150) DEFAULT NULL,
	ADD `pobox` varchar(25) DEFAULT NULL,
	ADD `country` varchar(150) DEFAULT NULL,
	ADD `note1` varchar(600) DEFAULT NULL,
	ADD `note2` varchar(600) DEFAULT NULL,
	ADD `note3` varchar(600) DEFAULT NULL;
	
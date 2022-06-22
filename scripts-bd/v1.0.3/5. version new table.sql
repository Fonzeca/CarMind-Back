CREATE TABLE `version` (
  `id` int NOT NULL,
  `store_release_notes` varchar(1000) DEFAULT NULL,
  `store_type` varchar(50) NOT NULL,
  `store_version` varchar(15) NOT NULL
) ENGINE=InnoDB
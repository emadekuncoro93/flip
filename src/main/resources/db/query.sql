CREATE TABLE `disbursement` (
  `id` bigint NOT NULL,
  `amount` int DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `bank_code` varchar(20) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `beneficiary_name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `receipt` varchar(255) DEFAULT NULL,
  `time_served` datetime DEFAULT NULL,
  `fee` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

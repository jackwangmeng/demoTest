CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(128) NOT NULL COMMENT '账户姓名',
  `amount` decimal (11,3) NOT NULL COMMENT '账户金额',
  `type` int(11) NOT NULL ,
  `is_lock` bit(1) NOT NULL DEFAULT b'1' COMMENT '账户锁定',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
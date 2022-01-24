CREATE TABLE `peer_to_peer_msg` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sender_id` varchar(30) NOT NULL DEFAULT '',
  `receiver_id` varchar(30) NOT NULL DEFAULT '',
  `send_content` text NOT NULL,
  `is_readed` tinyint(3) NOT NULL DEFAULT '0',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
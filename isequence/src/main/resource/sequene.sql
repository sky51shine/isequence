CREATE TABLE `sequence` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '����',
  `gmt_modified` datetime NOT NULL COMMENT '�޸�ʱ��',
  `name` varchar(64) NOT NULL COMMENT 'sequence����',
  `value` bigint(20) unsigned NOT NULL COMMENT 'sequenceֵ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk COMMENT='sequence'

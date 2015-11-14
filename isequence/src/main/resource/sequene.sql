CREATE TABLE `sequence` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` varchar(64) NOT NULL COMMENT 'sequence名称',
  `value` bigint(20) unsigned NOT NULL COMMENT 'sequence值',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk COMMENT='sequence'

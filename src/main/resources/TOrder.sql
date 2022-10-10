-- auto Generated on 2020-12-01
-- DROP TABLE IF EXISTS t_order;
CREATE TABLE t_order(
	order_id INT (11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
	en_code VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'enCode',
	order_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'orderTime',
	pro_code VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'proCode',
	order_num VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'orderNum',
	fee_code VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'feeCode',
	fee_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'feeName',
	unit_price VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'unitPrice',
	order_fee VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'orderFee',
	fee_period VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'feePeriod',
	validity VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'validity',
	order_note VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'orderNote',
	PRIMARY KEY (order_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 't_order';

DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `item_id` int(11) NOT NULL auto_increment,
  `category` varchar(20) NOT NULL, 
  `item_name` varchar(50) NOT NULL,
  `parent_id` int(11) NOT NULL default '0',
  PRIMARY KEY (`item_id`)
) TYPE=MyISAM;

insert into `dictionary` (`category`, `item_name`) values('customer_type', 'Client'); 
insert into `dictionary` (`category`, `item_name`) values('customer_type', 'Supplier'); 
insert into `dictionary` (`category`, `item_name`) values('form_type', 'Sale'); 
insert into `dictionary` (`category`, `item_name`) values('form_type', 'Purchase'); 
insert into `dictionary` (`category`, `item_name`) values('product_type', 'General'); 
insert into `dictionary` (`category`, `item_name`) values('product_color', 'White');
insert into `dictionary` (`category`, `item_name`) values('product_color', 'Red'); 
insert into `dictionary` (`category`, `item_name`) values('product_color', 'Yellow'); 
insert into `dictionary` (`category`, `item_name`) values('product_color', 'Green'); 
insert into `dictionary` (`category`, `item_name`) values('product_color', 'Pink'); 


DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL auto_increment,
  `customer_type_id` int(11) NOT NULL,
  `customer_type_name` varchar(50) NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  `company_name` varchar(100),
  `telephone` varchar(20),
  `address` varchar(100),
  `email` varchar(50),
  `QQ` varchar(20),
  `acount` varchar(50),
  PRIMARY KEY (`customer_id`),
  FOREIGN KEY (`customer_type_id`) REFERENCES dictionary(`item_id`)

)TYPE=MyISAM;

DROP TABLE IF EXISTS `form`;
CREATE TABLE `form` (
  `form_id` int(11) NOT NULL auto_increment,
  `form_type_Id` int(11) NOT NULL,
  `form_type_name` varchar(50) NOT NULL,
  `total` float NOT NULL,
  `input_date` DATE NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`form_id`),
  FOREIGN KEY (`form_type_Id`) REFERENCES dictionary(`item_id`),
  FOREIGN KEY (`customer_id`) REFERENCES customer(`customer_id`)
)TYPE=MyISAM;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL auto_increment,
  `product_name` varchar(50) NOT NULL,
  `product_type_id` int(11) NOT NULL,
  `product_type_name` varchar(50) NOT NULL,
  `description` varchar(1000),
  `price` float NOT NULL,
  `product_color_id` int(11),
  `product_color_name` varchar(50) NOT NULL, 
  PRIMARY KEY (`product_id`),
  FOREIGN KEY (`product_type_id`) REFERENCES dictionary(`item_id`),
  FOREIGN KEY (`product_color_id`) REFERENCES dictionary(`item_id`)
)TYPE=MyISAM;

DROP TABLE IF EXISTS `form_detail`;
CREATE TABLE `form_detail` (
  `form_detail_id` int(11) NOT NULL auto_increment,
  `form_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL, 
  `quantity` int(5)  NOT NULL,
   `total` float NOT NULL,
  PRIMARY KEY (`form_detail_id`),
 FOREIGN KEY (`form_id`) REFERENCES form(`form_id`),
 FOREIGN KEY (`product_Id`) REFERENCES product(`product_id`)
)TYPE=MyISAM;

 
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `product_id` int(11) NOT NULL auto_increment,
  `quantity` int(5)  NOT NULL,
  PRIMARY KEY (`product_id`),
  FOREIGN KEY (`product_Id`) REFERENCES product(`product_id`)
)TYPE=MyISAM;


insert into `customer` (`customer_type_id`, `customer_type_name`, `customer_name`, `company_name`, `telephone`, `address`, `email`, `QQ`, `acount`) values
('1', 'Client', 'Andy Customer', 'AT&T', '452178451', 'New Address Road 456', 'andy7842@126.com', '78451256', 'Bank:7854 1256 3289 721'); 

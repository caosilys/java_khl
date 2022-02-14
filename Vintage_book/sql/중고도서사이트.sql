CREATE SCHEMA `vintige_book` ;

use vintige_book;

CREATE TABLE `member` (
	`me_id`	varchar(20)	NOT NULL,
    `me_resi_num` varchar(13) NULL,
    `me_pw`	varchar(255)	NULL,
	`me_name`	varchar(20)	NULL,
	`me_gender`	varchar(20)	NULL,
	`me_address`	varchar(50)	NULL,
	`me_post_num`	varchar(10)	NULL,
	`me_phone`	varchar(20)	NULL,
	`me_email`	varchar(50)	NULL,
	`me_bank`	varchar(20)	NULL,
	`me_account`	varchar(20)	NULL,
	`me_score`	int	NULL,
	`me_point`	int	NULL,
	`me_gr_num`	int	NOT NULL
);


CREATE TABLE `greade` (
	`gr_num`	int	NOT NULL,
	`gr_name`	varchar(20)	NULL
);

CREATE TABLE `order_delivery` (
	`or_de_it_num`	int	NOT NULL,
	`or_buyer`	varchar(20)	NOT NULL,
	`or_invoice`	varchar(20)	NULL,
	`or_address`	varchar(50)	NULL,
	`or_post_num`	varchar(10)	NULL
);

CREATE TABLE `image` (
	`im_num`	int	NOT NULL,
	`im_link`	int	NULL,
	`im_name`	varchar(255)	NULL,
	`im_path`	varchar(255)	NULL,
	`im_out`	varchar(20)	NULL
);

CREATE TABLE `area` (
	`ar_num`	int	NOT NULL,
	`ar_name`	varchar(20)	NULL,
	`ar_it_num`	int	NOT NULL
);

CREATE TABLE `comment` (
	`co_num`	int	NOT NULL,
	`co_it_num`	int	NOT NULL,
	`co_me_id`	varchar(20)	NOT NULL,
	`co_content`	varchar(255)	NULL,
	`co_date`	datetime	NULL,
	`co_del`	varchar(20)	NULL
);

CREATE TABLE `item` (
	`it_num`	int	NOT NULL,
	`it_me_seller`	varchar(20)	NOT NULL,
	`it_name`	varchar(50)	NULL,
	`it_writer`	varchar(20)	NULL,
	`it_price`	int	NULL,
	`it_detail`	longtext	NULL,
	`it_date`	datetime	NULL,
	`it_st_num`	int	NOT NULL,
	`it_im_link`	int	NULL,
	`it_ge_name1`	varchar(20)	NOT NULL,
	`it_ge_name2`	varchar(20)	NOT NULL,
	`it_ge_name3`	varchar(20)	NOT NULL,
	`it_ty_num`	int	NOT NULL
);

CREATE TABLE `state` (
	`st_num`	int	NOT NULL,
	`st_name`	varchar(20)	NULL
);

CREATE TABLE `order_direct` (
	`or_di_it_num`	int	NOT NULL,
	`or_buyer`	varchar(20)	NOT NULL,
	`or_ar_num`	int	NOT NULL,
	`or_time`	varchar(20)	NULL,
	`or_detail`	varchar(255)	NULL
);

CREATE TABLE `notice` (
	`no_num`	int	NOT NULL,
	`no_me_sender`	varchar(20)	NOT NULL,
	`no_me_receiver`	varchar(20)	NOT NULL,
	`no_content`	varchar(255)	NULL,
	`no_read`	varchar(20)	NULL,
	`no_del`	varchar(20)	NULL,
	`no_im_link`	int	NULL
);

CREATE TABLE `wish` (
	`wi_num`	int	NOT NULL,
	`wi_me_id`	varchar(20)	NOT NULL,
	`wi_it_num`	int	NOT NULL
);

CREATE TABLE `genre` (
	`ge_name`	varchar(20)	NOT NULL
);

CREATE TABLE `type` (
	`ty_num`	int	NOT NULL,
	`ty_name`	varchar(20)	NULL
);

-- 여기까지 생성

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `greade` ADD CONSTRAINT `PK_GREADE` PRIMARY KEY (
	`gr_num`
);

ALTER TABLE `order_delivery` ADD CONSTRAINT `PK_ORDER_DELIVERY` PRIMARY KEY (
	`or_de_it_num`
);

ALTER TABLE `image` ADD CONSTRAINT `PK_IMAGE` PRIMARY KEY (
	`im_num`
);

ALTER TABLE `area` ADD CONSTRAINT `PK_AREA` PRIMARY KEY (
	`ar_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`co_num`
);

ALTER TABLE `item` ADD CONSTRAINT `PK_ITEM` PRIMARY KEY (
	`it_num`
);

ALTER TABLE `state` ADD CONSTRAINT `PK_STATE` PRIMARY KEY (
	`st_num`
);

ALTER TABLE `order_direct` ADD CONSTRAINT `PK_ORDER_DIRECT` PRIMARY KEY (
	`or_di_it_num`
);

ALTER TABLE `notice` ADD CONSTRAINT `PK_NOTICE` PRIMARY KEY (
	`no_num`
);

ALTER TABLE `wish` ADD CONSTRAINT `PK_WISH` PRIMARY KEY (
	`wi_num`
);

ALTER TABLE `genre` ADD CONSTRAINT `PK_GENRE` PRIMARY KEY (
	`ge_name`
);

ALTER TABLE `type` ADD CONSTRAINT `PK_TYPE` PRIMARY KEY (
	`ty_num`
);

-- 여기까지 PK

ALTER TABLE `vintige_book`.`area` 
CHANGE COLUMN `ar_name` `ar_name` VARCHAR(20) NOT NULL,
CHANGE COLUMN `ar_num` `ar_num` INT NOT NULL AUTO_INCREMENT ;

ALTER TABLE `vintige_book`.`comment` 
CHANGE COLUMN `co_num` `co_num` INT NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `co_content` `co_content` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `co_date` `co_date` DATETIME NOT NULL DEFAULT now() ,
CHANGE COLUMN `co_del` `co_del` VARCHAR(20) NOT NULL DEFAULT 'N' ;

ALTER TABLE `vintige_book`.`greade` 
CHANGE COLUMN `gr_name` `gr_name` VARCHAR(20) NOT NULL ;


ALTER TABLE `vintige_book`.`image` 
CHANGE COLUMN `im_num` `im_num` INT NOT NULL AUTO_INCREMENT,
CHANGE COLUMN `im_link` `im_link` INT NOT NULL ,
CHANGE COLUMN `im_name` `im_name` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `im_path` `im_path` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `im_out` `im_out` VARCHAR(20) NOT NULL DEFAULT 'item' ;

ALTER TABLE `vintige_book`.`item` 
CHANGE COLUMN `it_num` `it_num` INT NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `it_name` `it_name` VARCHAR(50) NOT NULL ,
CHANGE COLUMN `it_writer` `it_writer` VARCHAR(20) NOT NULL ,
CHANGE COLUMN `it_price` `it_price` INT NOT NULL ,
CHANGE COLUMN `it_date` `it_date` DATETIME NOT NULL DEFAULT now() ,
CHANGE COLUMN `it_st_num` `it_st_num` INT NOT NULL DEFAULT 0 ,
CHANGE COLUMN `it_ge_name2` `it_ge_name2` VARCHAR(20) NULL ,
CHANGE COLUMN `it_ge_name3` `it_ge_name3` VARCHAR(20) NULL ,
CHANGE COLUMN `it_ty_num` `it_ty_num` INT NOT NULL DEFAULT 1 ;

ALTER TABLE `vintige_book`.`member` 
CHANGE COLUMN `me_resi_num` `me_resi_num` VARCHAR(13) NOT NULL ,
CHANGE COLUMN `me_pw` `me_pw` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `me_name` `me_name` VARCHAR(20) NOT NULL ,
CHANGE COLUMN `me_phone` `me_phone` VARCHAR(20) NOT NULL ,
CHANGE COLUMN `me_email` `me_email` VARCHAR(50) NOT NULL ,
CHANGE COLUMN `me_score` `me_score` INT NOT NULL DEFAULT 10 ,
CHANGE COLUMN `me_point` `me_point` INT NOT NULL DEFAULT 0 ,
CHANGE COLUMN `me_gr_num` `me_gr_num` INT NOT NULL DEFAULT 1 ,
ADD UNIQUE INDEX `me_resi_num_UNIQUE` (`me_resi_num` ASC) VISIBLE;
;
  
  ALTER TABLE `vintige_book`.`notice` 
CHANGE COLUMN `no_num` `no_num` INT NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `no_content` `no_content` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `no_read` `no_read` VARCHAR(20) NOT NULL DEFAULT 'N' ,
CHANGE COLUMN `no_del` `no_del` VARCHAR(20) NOT NULL DEFAULT 'N' ;

ALTER TABLE `vintige_book`.`order_delivery` 
CHANGE COLUMN `or_address` `or_address` VARCHAR(50) NOT NULL ,
CHANGE COLUMN `or_post_num` `or_post_num` VARCHAR(10) NOT NULL ;

ALTER TABLE `vintige_book`.`state` 
CHANGE COLUMN `st_name` `st_name` VARCHAR(20) NOT NULL ;

ALTER TABLE `vintige_book`.`wish` 
CHANGE COLUMN `wi_num` `wi_num` INT NOT NULL AUTO_INCREMENT ;

-- 여기까지 추가설정

ALTER TABLE `member` ADD CONSTRAINT `FK_greade_TO_member_1` FOREIGN KEY (
	`me_gr_num`
)
REFERENCES `greade` (
	`gr_num`
);

ALTER TABLE `order_delivery` ADD CONSTRAINT `FK_item_TO_order_delivery_1` FOREIGN KEY (
	`or_de_it_num`
)
REFERENCES `item` (
	`it_num`
);

ALTER TABLE `order_delivery` ADD CONSTRAINT `FK_member_TO_order_delivery_1` FOREIGN KEY (
	`or_buyer`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `area` ADD CONSTRAINT `FK_item_TO_area_1` FOREIGN KEY (
	`ar_it_num`
)
REFERENCES `item` (
	`it_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_item_TO_comment_1` FOREIGN KEY (
	`co_it_num`
)
REFERENCES `item` (
	`it_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`co_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `item` ADD CONSTRAINT `FK_member_TO_item_1` FOREIGN KEY (
	`it_me_seller`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `item` ADD CONSTRAINT `FK_state_TO_item_1` FOREIGN KEY (
	`it_st_num`
)
REFERENCES `state` (
	`st_num`
);

ALTER TABLE `item` ADD CONSTRAINT `FK_genre_TO_item_1` FOREIGN KEY (
	`it_ge_name1`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `item` ADD CONSTRAINT `FK_genre_TO_item_2` FOREIGN KEY (
	`it_ge_name2`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `item` ADD CONSTRAINT `FK_genre_TO_item_3` FOREIGN KEY (
	`it_ge_name3`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `item` ADD CONSTRAINT `FK_type_TO_item_1` FOREIGN KEY (
	`it_ty_num`
)
REFERENCES `type` (
	`ty_num`
);

ALTER TABLE `order_direct` ADD CONSTRAINT `FK_item_TO_order_direct_1` FOREIGN KEY (
	`or_di_it_num`
)
REFERENCES `item` (
	`it_num`
);

ALTER TABLE `order_direct` ADD CONSTRAINT `FK_member_TO_order_direct_1` FOREIGN KEY (
	`or_buyer`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `order_direct` ADD CONSTRAINT `FK_area_TO_order_direct_1` FOREIGN KEY (
	`or_ar_num`
)
REFERENCES `area` (
	`ar_num`
);

ALTER TABLE `notice` ADD CONSTRAINT `FK_member_TO_notice_1` FOREIGN KEY (
	`no_me_sender`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `notice` ADD CONSTRAINT `FK_member_TO_notice_2` FOREIGN KEY (
	`no_me_receiver`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `wish` ADD CONSTRAINT `FK_member_TO_wish_1` FOREIGN KEY (
	`wi_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `wish` ADD CONSTRAINT `FK_item_TO_wish_1` FOREIGN KEY (
	`wi_it_num`
)
REFERENCES `item` (
	`it_num`
);


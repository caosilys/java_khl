/*
의류 쇼핑몰을 구축하려한다. 이때 필요한 테이블 구조를 잡아보세요
- 장바구니 기능x
 의류 구매가능, 배송정보는 회원주소로 사용, 결재정보관리x
 구매는 회원만 가능, 동일한 제품은 없음

table : 회원 
내용 : ID(기본키), PW, 이름, 주소
table : 상품
내용 : 상품코드(기본키), 상품명, 가격
table : 주문
내용 : 주문번호(기본키), 주문물품(외래키), 주문자ID(외래키), 수량 
*/

/*
-제품
	-분류방법 
		- 대분류로 상의 / 하의 구분후 중분류로 상의에 가디건,니트,민소매 등으로 분류
*/
create database shoppingmall;
use shoppingmall;

CREATE TABLE `goods` (
	`gd_num`	varchar(10)	NOT NULL,
	`gd_name`	varchar(50)	NULL,
	`gd_price`	int	NULL,
	`gd_detail`	longtext	NULL,
	`gd_ca_num`	int	NOT NULL
);

CREATE TABLE `option` (
	`op_num`	int	NOT NULL auto_increment , 
	`op_color`	varchar(10)	NULL,
	`op_size`	varchar(10)	NULL,
	`op_stock`	int	NULL,
	`op_gd_num`	varchar(10)	NOT NULL,
    primary key(`op_num`)
);

CREATE TABLE `category` (
	`ca_num`	int	NOT NULL auto_increment,
	`ca_main`	varchar(10)	NULL,
	`ca_sub`	varchar(10)	NULL,
    primary key(`ca_num`)
);

CREATE TABLE `member` (
	`me_id`	varchar(20)	NOT NULL,
	`me_pw`	varchar(255)	NULL,
	`me_name`	varchar(30)	NULL,
	`me_phone`	varchar(13)	NULL,
	`me_gender`	varchar(10)	NULL,
	`me_ad_num`	int	NOT NULL
);

CREATE TABLE `address` (
	`ad_num`	int	NOT NULL auto_increment ,
	`ad_nickname`	varchar(50)	NULL,
	`ad_address`	varchar(50)	NULL,
	`ad_post_num`	varchar(10)	NULL,
	`ad_detail`	varchar(50)	NULL,
    primary key(`ad_num`)
);

CREATE TABLE `order` (
	`or_num`	varchar(15)	NOT NULL,
   	`or_me_id`	varchar(20)	NOT NULL,
	`or_pw`	VARCHAR(255)	NOT NULL,
	`or_op_num`	int	NOT NULL,
	`or_date`	datetime	NULL,
	`or_amount`	int	NULL,
	`or_total_price`	int	NULL,
	`or_state`	varchar(10)	NULL
);

CREATE TABLE `review` (
	`re_num`	int	NOT NULL auto_increment,
	`re_title`	VARCHAR(255)	NULL,
	`re_contents`	longtext	NULL,
	`re_date`	datetime	NULL,
	`re_score`	int	NULL,
	`re_gd_num`	varchar(10)	NOT NULL,
	`re_me_id`	varchar(20)	NOT NULL,
    primary key(`re_num`)
);

ALTER TABLE `goods` ADD CONSTRAINT `PK_GOODS` PRIMARY KEY (
	`gd_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);


ALTER TABLE `order` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
	`or_num`
);

ALTER TABLE `goods` ADD CONSTRAINT `FK_category_TO_goods_1` FOREIGN KEY (
	`gd_ca_num`
)
REFERENCES `category` (
	`ca_num`
);

ALTER TABLE `option` ADD CONSTRAINT `FK_goods_TO_option_1` FOREIGN KEY (
	`op_gd_num`
)
REFERENCES `goods` (
	`gd_num`
);

ALTER TABLE `member` ADD CONSTRAINT `FK_address_TO_member_1` FOREIGN KEY (
	`me_ad_num`
)
REFERENCES `address` (
	`ad_num`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_member_TO_order_1` FOREIGN KEY (
	`or_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_option_TO_order_1` FOREIGN KEY (
	`or_op_num`
)
REFERENCES `option` (
	`op_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_goods_TO_review_1` FOREIGN KEY (
	`re_gd_num`
)
REFERENCES `goods` (
	`gd_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_member_TO_review_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);




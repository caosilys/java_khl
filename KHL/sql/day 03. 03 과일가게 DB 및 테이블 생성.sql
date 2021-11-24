-- 과일가게에서 과일 판매 내용을 DB로 관리하려 한다.
-- 이를 위해 ERD를 작성해보세요
-- 단 과일 가격은 고정

-- 과일가게 데이터베이스 생성 쿼리 작성

-- create database fruit_khl;
use fruit_khl;

CREATE TABLE `fruit` (
	`fr_name`	varchar(30)	NOT NULL,
	`fr_price`	int	not null default 0,
	`fr_amount`	int	not null default 0,
	`fr_unit`	varchar(10)	NULL
);

CREATE TABLE `buy` (
	`bu_num`	int	NOT NULL auto_increment,
	`bu_fr_name`	varchar(30)	NOT NULL,
	`bu_amount`	int not null default 0,
	`bu_date`	datetime not null default current_timestamp,
	`bu_unit`	varchar(10)	NULL,
	`bu_st_name`	varchar(20)	NOT NULL,
    primary key(`bu_num`)
);

CREATE TABLE `store` (
	`st_name`	varchar(20)	NOT NULL,
	`st_address`	varchar(50)	NULL
);

CREATE TABLE `sell` (
	`se_num`	int	NOT NULL auto_increment,
	`se_fr_name`	varchar(30)	NOT NULL,
	`se_amount`	int	not null default 0,
	`se_unit`	varchar(10)	NULL,
	`se_price`	int	not null default 0,
	`se_date`	datetime	not null default current_timestamp,
	`se_type`	varchar(4)	not null,
    primary key(`se_num`)
);

ALTER TABLE `fruit` ADD CONSTRAINT `PK_FRUIT` PRIMARY KEY (
	`fr_name`
);

ALTER TABLE `store` ADD CONSTRAINT `PK_STORE` PRIMARY KEY (
	`st_name`
);


ALTER TABLE `buy` ADD CONSTRAINT `FK_BUY_FRUIT` foreign key(
	`bu_fr_name`
 )  REFERENCES `fruit`(`fr_name`);
 
 ALTER TABLE `buy` ADD CONSTRAINT `FK_BUY_SROTE` foreign key(
	`bu_st_name`
 )  REFERENCES `store`(`st_name`);
 
 ALTER TABLE `sell` ADD CONSTRAINT `FK_SELL_FRUIT` foreign key(
	`se_fr_name`
 )  REFERENCES `fruit`(`fr_name`);

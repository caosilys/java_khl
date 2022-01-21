CREATE SCHEMA `comunity` ;
use `comunity`;

CREATE TABLE `member` (
	`me_id`	varchar(20)	NOT NULL,
	`me_pw`	varchar(255)	NULL,
	`me_name`	varchar(30)	NULL,
	`me_gender`	varchar(6)	NULL,
	`me_birth`	date	NULL,
	`me_address`	varchar(100)	NULL,
	`me_phone`	varchar(13)	NULL
);

CREATE TABLE `board` (
	`bd_num`	int	NOT NULL,
	`bd_title`	varchar(100)	NULL,
	`bd_content`	longtext	NULL,
	`bd_reg_date`	datetime	NULL,
	`bd_up_date`	datetime	NULL,
	`bd_type`	varchar(10)	NULL,
	`Field`	VARCHAR(255)	NULL,
	`bd_me_id`	varchar(20)	NOT NULL,
	`bd_ori_num`	int	NOT NULL,
	`bd_del`	varchar(2)	NULL,
	`bd_del_date`	datetime	NULL
);

CREATE TABLE `file` (
	`fi_num`	int	NOT NULL,
	`fi_ori_name`	varchar(255)	NULL,
	`fi_name`	varchar(255)	NULL,
	`fi_bd_num`	int	NOT NULL,
	`fI_del`	varchar(2)	NULL,
	`fi_del_date`	datetime	NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`bd_num`
);

ALTER TABLE `file` ADD CONSTRAINT `PK_FILE` PRIMARY KEY (
	`fi_num`
);

ALTER TABLE `comunity`.`board` 
CHANGE COLUMN `bd_num` `bd_num` INT NOT NULL AUTO_INCREMENT ;

ALTER TABLE `comunity`.`file` 
CHANGE COLUMN `fi_num` `fi_num` INT NOT NULL AUTO_INCREMENT ;

ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (
	`bd_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_board_TO_board_1` FOREIGN KEY (
	`bd_ori_num`
)
REFERENCES `board` (
	`bd_num`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (
	`fi_bd_num`
)
REFERENCES `board` (
	`bd_num`
);

select * from comunity.member;

insert into member
value ("abc123", "abc123", '테스트', '남', '19980510', '청주', '010-1234-5678');

select * from board where bd_num = "1" and bd_del="N";

update board set bd_del = 'N', bd_del_date = now() where bd_num = 1;

select * from board;

update board set bd_title = '변경' , bd_content = '변경', bd_up_date = now() where bd_num = 4;

-- 댓글 테이블 생성
CREATE TABLE `comunity`.`commant` (
  `co_num` INT NOT NULL AUTO_INCREMENT,
  `co_bd_num` INT NOT NULL,
  `co_me_id` VARCHAR(20) NOT NULL,
  `co_reg_date` DATETIME NOT NULL DEFAULT now(),
  `co_del` VARCHAR(2) NOT NULL DEFAULT 'N',
  `co_ori_num` INT NOT NULL,
  `co_content` LONGTEXT NOT NULL,
  PRIMARY KEY (`co_num`));
  
-- 댓글 테이블 외래키 지정
ALTER TABLE `comunity`.`commant` 
ADD INDEX `co_bd_num_idx` (`co_bd_num` ASC) VISIBLE,
ADD INDEX `co_me_id_idx` (`co_me_id` ASC) VISIBLE;
;
ALTER TABLE `comunity`.`commant` 
ADD CONSTRAINT `co_bd_num`
  FOREIGN KEY (`co_bd_num`)
  REFERENCES `comunity`.`board` (`bd_num`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `co_me_id`
  FOREIGN KEY (`co_me_id`)
  REFERENCES `comunity`.`member` (`me_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

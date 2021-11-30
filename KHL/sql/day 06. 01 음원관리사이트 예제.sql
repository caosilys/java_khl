create database melon;
use melon;

DROP TABLE IF EXISTS `soundtrack`;

CREATE TABLE `soundtrack` (
	`sd_num`	int	NOT NULL,
	`sd_title`	varchar(50)	NULL,
	`sd_like`	int	NULL,
	`sd_lyrics`	longtext	NULL
);

DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
	`ab_num`	int	NOT NULL,
	`ab_title`	varchar(50)	NULL,
	`ab_date`	date	NULL,
	`ab_publisher`	varchar(50)	NULL,
	`ab_agency`	varchar(50)	NULL,
	`ab_introduce`	longtext	NULL,
	`ab_genre`	varchar(50)	NULL,
	`ab_gr_num`	int	NOT NULL,
	`ab_count`	varchar(10)	NULL
);

DROP TABLE IF EXISTS `artist`;

CREATE TABLE `artist` (
	`at_num`	int	NOT NULL,
	`at_name`	varchar(50)	NULL,
	`at_birthday`	date	NULL,
	`at_agency`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
	`gr_num`	int	NOT NULL,
	`gr_name`	varchar(50)	NULL,
	`gr_type`	varchar(10)	NULL,
	`gr_agency`	varchar(50)	NULL,
	`gr_date`	int	NULL
);

DROP TABLE IF EXISTS `act`;

CREATE TABLE `act` (
	`ac_num`	int	NOT NULL,
	`ac_at_num`	int	NOT NULL,
	`ac_gr_num`	int	NOT NULL,
	`ac_role`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `sing`;

CREATE TABLE `sing` (
	`si_num`	int	NOT NULL,
	`si_sd_num`	int	NOT NULL,
	`si_gr_num`	int	NOT NULL,
	`Field`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `include`;

CREATE TABLE `include` (
	`in_num`	int	NOT NULL,
	`in_ab_num`	int	NOT NULL,
	`in_sd_num`	int	NOT NULL,
	`in_procdure`	varchar(10)	NULL,
	`in_title`	int	NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(50)	NOT NULL,
	`me_pw`	varchar(50)	NULL
);

DROP TABLE IF EXISTS `like`;

CREATE TABLE `like` (
	`li_sd_num`	int	NOT NULL,
	`li_me_id`	varchar(50)	NOT NULL,
	`li_state`	int	NULL
);

DROP TABLE IF EXISTS `playlist`;

CREATE TABLE `playlist` (
	`pl_num`	int	NOT NULL,
	`pl_sd_num`	int	NOT NULL,
	`pl_me_id`	varchar(50)	NOT NULL,
	`pl_name`	varchar(50)	NULL,
	`pl_procdure`	int	NULL
);

DROP TABLE IF EXISTS `buy`;

CREATE TABLE `buy` (
	`bu_num`	VARCHAR(255)	NOT NULL,
	`bu_me_id`	varchar(50)	NOT NULL,
	`bu_sd_num`	int	NOT NULL
);

ALTER TABLE `soundtrack` ADD CONSTRAINT `PK_SOUNDTRACK` PRIMARY KEY (
	`sd_num`
);

ALTER TABLE `album` ADD CONSTRAINT `PK_ALBUM` PRIMARY KEY (
	`ab_num`
);

ALTER TABLE `artist` ADD CONSTRAINT `PK_ARTIST` PRIMARY KEY (
	`at_num`
);

ALTER TABLE `group` ADD CONSTRAINT `PK_GROUP` PRIMARY KEY (
	`gr_num`
);

ALTER TABLE `act` ADD CONSTRAINT `PK_ACT` PRIMARY KEY (
	`ac_num`
);

ALTER TABLE `sing` ADD CONSTRAINT `PK_SING` PRIMARY KEY (
	`si_num`
);

ALTER TABLE `include` ADD CONSTRAINT `PK_INCLUDE` PRIMARY KEY (
	`in_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `playlist` ADD CONSTRAINT `PK_PLAYLIST` PRIMARY KEY (
	`pl_num`
);

ALTER TABLE `buy` ADD CONSTRAINT `PK_BUY` PRIMARY KEY (
	`bu_num`
);

ALTER TABLE `album` ADD CONSTRAINT `FK_group_TO_album_1` FOREIGN KEY (
	`ab_gr_num`
)
REFERENCES `group` (
	`gr_num`
);

ALTER TABLE `act` ADD CONSTRAINT `FK_artist_TO_act_1` FOREIGN KEY (
	`ac_at_num`
)
REFERENCES `artist` (
	`at_num`
);

ALTER TABLE `act` ADD CONSTRAINT `FK_group_TO_act_1` FOREIGN KEY (
	`ac_gr_num`
)
REFERENCES `group` (
	`gr_num`
);

ALTER TABLE `sing` ADD CONSTRAINT `FK_soundtrack_TO_sing_1` FOREIGN KEY (
	`si_sd_num`
)
REFERENCES `soundtrack` (
	`sd_num`
);

ALTER TABLE `sing` ADD CONSTRAINT `FK_group_TO_sing_1` FOREIGN KEY (
	`si_gr_num`
)
REFERENCES `group` (
	`gr_num`
);

ALTER TABLE `include` ADD CONSTRAINT `FK_album_TO_include_1` FOREIGN KEY (
	`in_ab_num`
)
REFERENCES `album` (
	`ab_num`
);

ALTER TABLE `include` ADD CONSTRAINT `FK_soundtrack_TO_include_1` FOREIGN KEY (
	`in_sd_num`
)
REFERENCES `soundtrack` (
	`sd_num`
);

ALTER TABLE `like` ADD CONSTRAINT `FK_soundtrack_TO_like_1` FOREIGN KEY (
	`li_sd_num`
)
REFERENCES `soundtrack` (
	`sd_num`
);

ALTER TABLE `like` ADD CONSTRAINT `FK_member_TO_like_1` FOREIGN KEY (
	`li_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `playlist` ADD CONSTRAINT `FK_soundtrack_TO_playlist_1` FOREIGN KEY (
	`pl_sd_num`
)
REFERENCES `soundtrack` (
	`sd_num`
);

ALTER TABLE `playlist` ADD CONSTRAINT `FK_member_TO_playlist_1` FOREIGN KEY (
	`pl_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_member_TO_buy_1` FOREIGN KEY (
	`bu_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_soundtrack_TO_buy_1` FOREIGN KEY (
	`bu_sd_num`
)
REFERENCES `soundtrack` (
	`sd_num`
);


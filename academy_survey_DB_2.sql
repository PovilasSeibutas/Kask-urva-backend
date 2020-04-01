-- TINYTEXT: 255; TEXT: 65,535; MEDIUMTEXT: 16,777,215; LONGTEXT: 4,294,967,29
CREATE SCHEMA `academy_survey` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `3R2xfxnk9u`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `question` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- table update in order to save option string
ALTER TABLE `3R2xfxnk9u`.`question`
DROP COLUMN `type`,
ADD COLUMN `option` TEXT NULL AFTER `question`;

-- create GDPR agreemnet table

CREATE TABLE `3R2xfxnk9u`.`gdpr` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `agreement` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

CREATE TABLE `3R2xfxnk9u`.`survey` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time_stamp` INT(15) NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- GDPR id added

ALTER TABLE `3R2xfxnk9u`.`survey`
ADD COLUMN `gdpr_id` INT NOT NULL AFTER `admin_id`;

ALTER TABLE `academy_survey`.`survey`
CHANGE COLUMN `gdpr_id` `gdpr_id` INT(11) NULL DEFAULT 0 ;

CREATE TABLE `3R2xfxnk9u`.`answer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `answer` TEXT NOT NULL,
  `question_id` INT NOT NULL,
  `survey_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `answer_survey_fk_idx` (`survey_id` ASC) VISIBLE,
  INDEX `answer_question_fk_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `answer_survey_fk`
    FOREIGN KEY (`survey_id`)
    REFERENCES `3R2xfxnk9u`.`survey` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `answer_question_fk`
    FOREIGN KEY (`question_id`)
    REFERENCES `3R2xfxnk9u`.`question` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- ADMINT testavimui:
CREATE TABLE `3R2xfxnk9u`.`admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `pswd` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- survey status keitimas admin_ID:

ALTER TABLE `3R2xfxnk9u`.`survey`
ADD COLUMN `admin_id` INT NOT NULL DEFAULT 0 AFTER `status`;

-- create comment table
CREATE TABLE `3R2xfxnk9u`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `survey_id` INT NOT NULL,
  `admin_id` INT NOT NULL,
  `comment` TEXT NOT NULL,
  `time_stamp` INT(15) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `comment_survey_id_fk_idx` (`survey_id` ASC) VISIBLE,
  INDEX `comment_admin_id_fk_idx` (`admin_id` ASC) VISIBLE,
  CONSTRAINT `comment_survey_id_fk`
    FOREIGN KEY (`survey_id`)
    REFERENCES `3R2xfxnk9u`.`survey` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `comment_admin_id_fk`
    FOREIGN KEY (`admin_id`)
    REFERENCES `3R2xfxnk9u`.`admin` (`id`)
    ON DELETE NO ACTION
    ON UPDATE RESTRICT);
    
    -- create message table
    
    CREATE TABLE `3R2xfxnk9u`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `message` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- status appended

ALTER TABLE `3R2xfxnk9u`.`message`
ADD COLUMN `status` INT NOT NULL DEFAULT 0 AFTER `message`;
    
    -- create message-outbox table

CREATE TABLE `3R2xfxnk9u`.`message_outbox` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `replay` TEXT NOT NULL,
  `message_id` INT NOT NULL,
  `admin_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `message_inbox_message_id_fk_idx` (`message_id` ASC) VISIBLE,
  INDEX `message_inbox_admin_id_fk_idx` (`admin_id` ASC) VISIBLE,
  CONSTRAINT `message_inbox_message_id_fk`
    FOREIGN KEY (`message_id`)
    REFERENCES `3R2xfxnk9u`.`message` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `message_inbox_admin_id_fk`
    FOREIGN KEY (`admin_id`)
    REFERENCES `3R2xfxnk9u`.`admin` (`id`)
    ON DELETE NO ACTION
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;
-- edit fk;
ALTER TABLE `3R2xfxnk9u`.`message_outbox`
DROP FOREIGN KEY `message_inbox_message_id_fk`;
ALTER TABLE `3R2xfxnk9u`.`message_outbox`
ADD CONSTRAINT `message_inbox_message_id_fk`
  FOREIGN KEY (`message_id`)
  REFERENCES `3R2xfxnk9u`.`message` (`id`)
  ON DELETE NO ACTION
  ON UPDATE RESTRICT;
  
  ALTER TABLE `3R2xfxnk9u`.`message_outbox`
DROP FOREIGN KEY `message_inbox_admin_id_fk`,
DROP FOREIGN KEY `message_inbox_message_id_fk`;
ALTER TABLE `3R2xfxnk9u`.`message_outbox`
CHANGE COLUMN `message_id` `message_id` INT(11) NULL ,
CHANGE COLUMN `admin_id` `admin_id` INT(11) NULL ;
ALTER TABLE `3R2xfxnk9u`.`message_outbox`
ADD CONSTRAINT `message_inbox_admin_id_fk`
  FOREIGN KEY (`admin_id`)
  REFERENCES `3R2xfxnk9u`.`admin` (`id`)
  ON DELETE SET NULL
  ON UPDATE RESTRICT,
ADD CONSTRAINT `message_inbox_message_id_fk`
  FOREIGN KEY (`message_id`)
  REFERENCES `3R2xfxnk9u`.`message` (`id`)
  ON DELETE SET NULL
  ON UPDATE RESTRICT;

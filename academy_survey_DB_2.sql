-- TINYTEXT: 255; TEXT: 65,535; MEDIUMTEXT: 16,777,215; LONGTEXT: 4,294,967,29
CREATE SCHEMA `academy_survey` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `academy_survey`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `question` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- table update in order to save JSON object
ALTER TABLE `academy_survey`.`question` 
DROP COLUMN `type`,
ADD COLUMN `option` JSON NULL AFTER `question`;

CREATE TABLE `academy_survey`.`survey` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time_stamp` INT(15) NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

CREATE TABLE `academy_survey`.`answer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `answer` TEXT NOT NULL,
  `question_id` INT NOT NULL,
  `survey_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `answer_survey_fk_idx` (`survey_id` ASC) VISIBLE,
  INDEX `answer_question_fk_idx` (`question_id` ASC) VISIBLE,
  CONSTRAINT `answer_survey_fk`
    FOREIGN KEY (`survey_id`)
    REFERENCES `academy_survey`.`survey` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `answer_question_fk`
    FOREIGN KEY (`question_id`)
    REFERENCES `academy_survey`.`question` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- ADMINT testavimui:
CREATE TABLE `academy_survey`.`admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `pswd` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- survey status keitimas admin_ID:

ALTER TABLE `academy_survey`.`survey` 
ADD COLUMN `admin_id` INT NOT NULL DEFAULT 0 AFTER `status`;

-- create comment table
CREATE TABLE `academy_survey`.`comment` (
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
    REFERENCES `academy_survey`.`survey` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `comment_admin_id_fk`
    FOREIGN KEY (`admin_id`)
    REFERENCES `academy_survey`.`admin` (`id`)
    ON DELETE NO ACTION
    ON UPDATE RESTRICT);
    
    -- create message table
    
    CREATE TABLE `academy_survey`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `message` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- status appended

ALTER TABLE `academy_survey`.`message` 
ADD COLUMN `status` INT NOT NULL DEFAULT 0 AFTER `message`;
    
    -- create message-outbox table

CREATE TABLE `academy_survey`.`message_outbox` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `replay` TEXT NOT NULL,
  `message_id` INT NOT NULL,
  `admin_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `message_inbox_message_id_fk_idx` (`message_id` ASC) VISIBLE,
  INDEX `message_inbox_admin_id_fk_idx` (`admin_id` ASC) VISIBLE,
  CONSTRAINT `message_inbox_message_id_fk`
    FOREIGN KEY (`message_id`)
    REFERENCES `academy_survey`.`message` (`id`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `message_inbox_admin_id_fk`
    FOREIGN KEY (`admin_id`)
    REFERENCES `academy_survey`.`admin` (`id`)
    ON DELETE NO ACTION
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;
-- edit fk;
ALTER TABLE `academy_survey`.`message_outbox` 
DROP FOREIGN KEY `message_inbox_message_id_fk`;
ALTER TABLE `academy_survey`.`message_outbox` 
ADD CONSTRAINT `message_inbox_message_id_fk`
  FOREIGN KEY (`message_id`)
  REFERENCES `academy_survey`.`message` (`id`)
  ON DELETE NO ACTION
  ON UPDATE RESTRICT;
  
  ALTER TABLE `academy_survey`.`message_outbox` 
DROP FOREIGN KEY `message_inbox_admin_id_fk`,
DROP FOREIGN KEY `message_inbox_message_id_fk`;
ALTER TABLE `academy_survey`.`message_outbox` 
CHANGE COLUMN `message_id` `message_id` INT(11) NULL ,
CHANGE COLUMN `admin_id` `admin_id` INT(11) NULL ;
ALTER TABLE `academy_survey`.`message_outbox` 
ADD CONSTRAINT `message_inbox_admin_id_fk`
  FOREIGN KEY (`admin_id`)
  REFERENCES `academy_survey`.`admin` (`id`)
  ON DELETE SET NULL
  ON UPDATE RESTRICT,
ADD CONSTRAINT `message_inbox_message_id_fk`
  FOREIGN KEY (`message_id`)
  REFERENCES `academy_survey`.`message` (`id`)
  ON DELETE SET NULL
  ON UPDATE RESTRICT;

INSERT INTO `academy_survey`.`survey` (`time_stamp`) VALUES ('1584057600');

INSERT INTO `academy_survey`.`survey` (`time_stamp`) VALUES ('1584121560');


INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Vardas', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Pavardė', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Mobiliojo telefono numeris', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('El. paštas', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Mokymo įstaiga, kurioje šiuo metu mokaisi', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('O ką veiki, kai nesimokai? Kokie tavo pomėgiai?', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Ar bus galimybė pasirašyti trišalę praktikos sutartį?', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Pakomentuok plačiau', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Numatytas praktikos laikas darbo dienomis 14-18 val. Ar galėsi akademijai', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Kodėl nori dalyvauti IT akademijoje? Kas tave „veža“ joje', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Kokios technologijos tau labiausiai patinka ir su kokiomis iš jų jau turi', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Jei teko dirbti prie konkretaus projekto, pasidalink jo nuoroda', '{\"key\": \"string\"}');
INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ('Iš kur sužinojai apie IT akademiją Swedbank?', '{\"key\": \"string\"}');


INSERT INTO `academy_survey`.`answer` (`answer`, `question_id`, `survey_id`) VALUES ('Jonas', '1', '1');

INSERT INTO `academy_survey`.`answer` (`answer`, `question_id`, `survey_id`) VALUES ('Jonaitis', '2', '1');
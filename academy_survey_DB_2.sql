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



INSERT INTO `academy_survey`.`survey` (`time_stamp`) VALUES ('1584057600');

INSERT INTO `academy_survey`.`survey` (`time_stamp`) VALUES ('1584121560');

INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('text', 'Vardas');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('text', 'Pavardė');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('text', 'Mobiliojo telefono numeris');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('email', 'El. paštas');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('text', 'Mokymo įstaiga, kurioje šiuo metu mokaisi');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('textarea', 'O ką veiki, kai nesimokai? Kokie tavo pomėgiai?');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('radio', 'Ar bus galimybė pasirašyti trišalę praktikos sutartį?');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('textarea', 'Pakomentuok plačiau');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('radio', 'Numatytas praktikos laikas darbo dienomis 14-18 val. Ar galėsi akademijai');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('textarea', 'Kodėl nori dalyvauti IT akademijoje? Kas tave „veža“ joje');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('textarea', 'Kokios technologijos tau labiausiai patinka ir su kokiomis iš jų jau turi');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('text', 'Jei teko dirbti prie konkretaus projekto, pasidalink jo nuoroda');
INSERT INTO `academy_survey`.`question` (`type`, `question`) VALUES ('text', 'Iš kur sužinojai apie IT akademiją Swedbank?');


INSERT INTO `academy_survey`.`answer` (`answer`, `question_id`, `survey_id`) VALUES ('Jonas', '1', '1');

INSERT INTO `academy_survey`.`answer` (`answer`, `question_id`, `survey_id`) VALUES ('Jonaitis', '2', '1');
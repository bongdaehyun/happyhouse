use happyhouse;

DROP TABLE IF EXISTS `aptreview`;
CREATE TABLE IF NOT EXISTS `happyhouse`.`aptreview` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `age` VARCHAR(45) NULL,
  `sex` VARCHAR(45) NULL,
  `married` VARCHAR(45) NULL,
  `residenceTime` VARCHAR(45) NULL,
  `residenceType` VARCHAR(45) NULL,
  `score` INT NULL,
  `desc` VARCHAR(1024) NULL,
  `trafficScore` INT NULL,
  `trafficDesc` VARCHAR(1024) NULL,
  `aroundScore` INT NULL,
  `aroundDesc` VARCHAR(1024) NULL,
  `careScore` INT NULL,
  `careDesc` VARCHAR(1024) NULL,
  `residentScore` INT NULL,
  `residentDesc` VARCHAR(1024) NULL,
  `aptName` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

DROP TABLE IF EXISTS `reviewWord`;
CREATE TABLE IF NOT EXISTS `happyhouse`.`reviewWord` (
  `id` INT NOT NULL,
  `count` INT NOT NULL,
  `word` VARCHAR(45) NOT NULL,
  INDEX `fk_reviewWord_aptreview1_idx` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_reviewWord_aptreview1`
    FOREIGN KEY (`id`)
    REFERENCES `happyhouse`.`aptreview` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `happyhouse`.`reviewtotal` (
  `count` INT NOT NULL,
  `word` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`word`))
ENGINE = InnoDB;
use happyhouse;

DROP TABLE IF EXISTS `qna`;
CREATE TABLE IF NOT EXISTS `happyhouse`.`qna` (
  `qnaid` INT NOT NULL AUTO_INCREMENT,
  `qnatitle` VARCHAR(60) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_as_cs' NULL DEFAULT NULL,
  `qnawriter` VARCHAR(60) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_as_cs' NULL DEFAULT NULL,
  `qnacontent` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_as_cs' NULL DEFAULT NULL,
  `date` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`qnaid`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_as_cs;
DROP TABLE IF EXISTS comments;
CREATE TABLE IF NOT EXISTS `happyhouse`.`comments` (
  `comment_no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `comment` VARCHAR(500) NULL,
  `comment_time` TIMESTAMP NULL,
  `qnaid` INT NOT NULL,
  PRIMARY KEY (`comment_no`),
  INDEX `fk_comments_qna1_idx` (`qnaid` ASC) ,
  CONSTRAINT `fk_comments_qna1`
    FOREIGN KEY (`qnaid`)
    REFERENCES `happyhouse`.`qna` (`qnaid`)
    ON DELETE cascade)
    ON UPDATE cascade)
ENGINE = InnoDB;

select * from comments
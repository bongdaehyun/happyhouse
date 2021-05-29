DROP TABLE IF EXISTS `happyhouse`.`areainfo`;
CREATE TABLE `happyhouse`.`areainfo` (
 `no` int NOT NULL AUTO_INCREMENT,
  `dongcode` VARCHAR(45) NOT NULL,
  `typename` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `dong` VARCHAR(45) NULL,
  `lat` VARCHAR(50) NULL,
  `lng` VARCHAR(50) NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_as_cs;
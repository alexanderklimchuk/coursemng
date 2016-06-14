-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`clientstatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`clientstatus` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `discountPercent` DECIMAL(10,0) NOT NULL DEFAULT '0',
  `discount_percent` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `isActve` BIT(1) NULL DEFAULT b'1',
  `is_actve` BIT(1) NULL DEFAULT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`parent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`parent` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(255) NOT NULL,
  `patronymic` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(120) NOT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `mphone` VARCHAR(45) NULL DEFAULT NULL,
  `client_status_id` INT(11) NULL DEFAULT '2',
  `User_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Parent_ClientStatus1_idx` (`client_status_id` ASC),
  INDEX `fk_Parent_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_Parent_ClientStatus1`
    FOREIGN KEY (`client_status_id`)
    REFERENCES `mydb`.`clientstatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Parent_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`child`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`child` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(120) NOT NULL,
  `patronomic` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(120) NOT NULL,
  `dob` DATE NOT NULL,
  `childrenGardenMember` TINYINT(1) NOT NULL DEFAULT '0',
  `canSpeak` TINYINT(1) NOT NULL DEFAULT '0',
  `hasSpeachIssues` BIT(1) NULL DEFAULT b'0',
  `Parent_id` INT(11) NOT NULL,
  `can_speak` BIT(1) NOT NULL,
  `children_garden_member` BIT(1) NOT NULL,
  `has_speach_issues` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Child_Parent1_idx` (`Parent_id` ASC),
  CONSTRAINT `fk_Child_Parent1`
    FOREIGN KEY (`Parent_id`)
    REFERENCES `mydb`.`parent` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`course` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`attendency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`attendency` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Course_id` INT(11) NOT NULL,
  `date` DATE NOT NULL,
  `Child_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Course_has_Attendency_Course1_idx` (`Course_id` ASC),
  INDEX `fk_Attendency_Child1_idx` (`Child_id` ASC),
  CONSTRAINT `fk_Attendency_Child1`
    FOREIGN KEY (`Child_id`)
    REFERENCES `mydb`.`child` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Course_has_Attendency_Course1`
    FOREIGN KEY (`Course_id`)
    REFERENCES `mydb`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`child_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`child_course` (
  `Child_id` INT(11) NOT NULL,
  `Course_id` INT(11) NOT NULL,
  PRIMARY KEY (`Child_id`, `Course_id`),
  INDEX `fk_Child_has_Course_Course1_idx` (`Course_id` ASC),
  INDEX `fk_Child_has_Course_Child1_idx` (`Child_id` ASC),
  CONSTRAINT `fk_Child_has_Course_Child1`
    FOREIGN KEY (`Child_id`)
    REFERENCES `mydb`.`child` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Child_has_Course_Course1`
    FOREIGN KEY (`Course_id`)
    REFERENCES `mydb`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`trainer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `patronomic` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `User_id` INT(11) NULL DEFAULT NULL,
  `dob` DATE NOT NULL,
  `education` VARCHAR(200) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Trainer_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_Trainer_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`course_has_trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`course_has_trainer` (
  `Course_id` INT(11) NOT NULL,
  `Trainer_id` INT(11) NOT NULL,
  PRIMARY KEY (`Course_id`, `Trainer_id`),
  INDEX `fk_Course_has_Trainer_Trainer1_idx` (`Trainer_id` ASC),
  INDEX `fk_Course_has_Trainer_Course1_idx` (`Course_id` ASC),
  CONSTRAINT `fk_Course_has_Trainer_Course1`
    FOREIGN KEY (`Course_id`)
    REFERENCES `mydb`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Course_has_Trainer_Trainer1`
    FOREIGN KEY (`Trainer_id`)
    REFERENCES `mydb`.`trainer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`discountcard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`discountcard` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NULL DEFAULT NULL,
  `balance` INT(11) NULL DEFAULT NULL,
  `Parent_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_DiscountCard_Parent1_idx` (`Parent_id` ASC),
  CONSTRAINT `fk_DiscountCard_Parent1`
    FOREIGN KEY (`Parent_id`)
    REFERENCES `mydb`.`parent` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`payment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `amount` DECIMAL(10,0) NOT NULL,
  `Course_id` INT(11) NOT NULL,
  `Child_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Payment_Course1_idx` (`Course_id` ASC),
  INDEX `fk_Payment_Child1_idx` (`Child_id` ASC),
  CONSTRAINT `fk_Payment_Child1`
    FOREIGN KEY (`Child_id`)
    REFERENCES `mydb`.`child` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Payment_Course1`
    FOREIGN KEY (`Course_id`)
    REFERENCES `mydb`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

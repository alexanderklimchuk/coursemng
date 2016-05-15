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
-- Table `mydb`.`ClientStatus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ClientStatus` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `discountPercent` DECIMAL NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `isActve` BIT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Parent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Parent` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(255) NOT NULL,
  `patronymic` VARCHAR(45) NULL,
  `lastname` VARCHAR(120) NOT NULL,
  `address` VARCHAR(255) NULL,
  `phone` VARCHAR(45) NULL,
  `mphone` VARCHAR(45) NULL,
  `client_status_id` INT NULL DEFAULT 2,
  `User_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Parent_ClientStatus1_idx` (`client_status_id` ASC),
  INDEX `fk_Parent_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_Parent_ClientStatus1`
    FOREIGN KEY (`client_status_id`)
    REFERENCES `mydb`.`ClientStatus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Parent_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Child`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Child` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(120) NOT NULL,
  `patronomic` VARCHAR(45) NULL,
  `lastname` VARCHAR(120) NOT NULL,
  `dob` DATE NOT NULL,
  `childrenGardenMember` TINYINT(1) NOT NULL DEFAULT 0,
  `canSpeak` TINYINT(1) NOT NULL DEFAULT 0,
  `hasSpeachIssues` BIT NULL DEFAULT 0,
  `Parent_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Child_Parent1_idx` (`Parent_id` ASC),
  CONSTRAINT `fk_Child_Parent1`
    FOREIGN KEY (`Parent_id`)
    REFERENCES `mydb`.`Parent` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DiscountCard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DiscountCard` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NULL,
  `balance` INT NULL,
  `Parent_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_DiscountCard_Parent1_idx` (`Parent_id` ASC),
  CONSTRAINT `fk_DiscountCard_Parent1`
    FOREIGN KEY (`Parent_id`)
    REFERENCES `mydb`.`Parent` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Payment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `amount` DECIMAL NOT NULL,
  `Course_id` INT NOT NULL,
  `Child_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Payment_Course1_idx` (`Course_id` ASC),
  INDEX `fk_Payment_Child1_idx` (`Child_id` ASC),
  CONSTRAINT `fk_Payment_Course1`
    FOREIGN KEY (`Course_id`)
    REFERENCES `mydb`.`Course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Payment_Child1`
    FOREIGN KEY (`Child_id`)
    REFERENCES `mydb`.`Child` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Trainer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `patronomic` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `User_id` INT NULL,
  `dob` DATE NOT NULL,
  `education` VARCHAR(200) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Trainer_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_Trainer_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Child_Course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Child_Course` (
  `Child_id` INT NOT NULL,
  `Course_id` INT NOT NULL,
  PRIMARY KEY (`Child_id`, `Course_id`),
  INDEX `fk_Child_has_Course_Course1_idx` (`Course_id` ASC),
  INDEX `fk_Child_has_Course_Child1_idx` (`Child_id` ASC),
  CONSTRAINT `fk_Child_has_Course_Child1`
    FOREIGN KEY (`Child_id`)
    REFERENCES `mydb`.`Child` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Child_has_Course_Course1`
    FOREIGN KEY (`Course_id`)
    REFERENCES `mydb`.`Course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Attendency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Attendency` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Course_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `Child_id` INT NOT NULL,
  INDEX `fk_Course_has_Attendency_Course1_idx` (`Course_id` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_Attendency_Child1_idx` (`Child_id` ASC),
  CONSTRAINT `fk_Course_has_Attendency_Course1`
    FOREIGN KEY (`Course_id`)
    REFERENCES `mydb`.`Course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Attendency_Child1`
    FOREIGN KEY (`Child_id`)
    REFERENCES `mydb`.`Child` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Course_has_Trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Course_has_Trainer` (
  `Course_id` INT NOT NULL,
  `Trainer_id` INT NOT NULL,
  PRIMARY KEY (`Course_id`, `Trainer_id`),
  INDEX `fk_Course_has_Trainer_Trainer1_idx` (`Trainer_id` ASC),
  INDEX `fk_Course_has_Trainer_Course1_idx` (`Course_id` ASC),
  CONSTRAINT `fk_Course_has_Trainer_Course1`
    FOREIGN KEY (`Course_id`)
    REFERENCES `mydb`.`Course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Course_has_Trainer_Trainer1`
    FOREIGN KEY (`Trainer_id`)
    REFERENCES `mydb`.`Trainer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

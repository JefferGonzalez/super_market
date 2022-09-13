-- MySQL Script generated by MySQL Workbench
-- lun 12 sep 2022 14:04:53
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema super_market
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema super_market
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `super_market` ;
USE `super_market` ;

-- -----------------------------------------------------
-- Table `super_market`.`brand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `super_market`.`brand` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `super_market`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `super_market`.`category` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `super_market`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `super_market`.`product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  `quantity` INT NOT NULL,
  `brand_id` INT UNSIGNED NOT NULL,
  `category_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_product_brand` (`brand_id` ASC),
  INDEX `fk_product_category` (`category_id` ASC),
  CONSTRAINT `fk_product_brand`
    FOREIGN KEY (`brand_id`)
    REFERENCES `super_market`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `super_market`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `super_market`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `super_market`.`rol` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `super_market`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `super_market`.`user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `identification` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `rol_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC),
  INDEX `fk_user_rol` (`rol_id` ASC),
  CONSTRAINT `fk_user_rol`
    FOREIGN KEY (`rol_id`)
    REFERENCES `super_market`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `super_market`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `super_market`.`status` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `super_market`.`sale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `super_market`.`sale` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `sale_record` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `status_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `sale_record_UNIQUE` (`sale_record` ASC),
  INDEX `fk_sale_product` (`product_id` ASC),
  INDEX `fk_sale_user` (`user_id` ASC),
  INDEX `fk_sale_status` (`status_id` ASC),
  CONSTRAINT `fk_sale_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `super_market`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `super_market`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_status`
    FOREIGN KEY (`status_id`)
    REFERENCES `super_market`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `super_market`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `super_market`.`purchase` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `purshace_record` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `value` DOUBLE NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `status_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_purchase_product` (`product_id` ASC),
  INDEX `fk_purchase_user` (`user_id` ASC),
  INDEX `fk_purchase_status` (`status_id` ASC),
  CONSTRAINT `fk_purchase_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `super_market`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `super_market`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_status`
    FOREIGN KEY (`status_id`)
    REFERENCES `super_market`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `rol` (`id`, `name`) VALUES (NULL, 'administrator'), (NULL, 'employee');
INSERT INTO `status` (`id`, `name`) VALUES (NULL, 'in process'), (NULL, 'finished'), (NULL, 'canceled');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema online_store
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema online_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `online_store` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`timestamps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`timestamps` (
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `online_store` ;

-- -----------------------------------------------------
-- Table `online_store`.`contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`contacts`
(
    `id`        INT(11)     NOT NULL AUTO_INCREMENT,
    `telephone` VARCHAR(45) NOT NULL,
    `city`      VARCHAR(50) NOT NULL,
    `street`    VARCHAR(50) NULL DEFAULT NULL,
    `home`      VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);



-- -----------------------------------------------------
-- Table `online_store`.`personal_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`personal_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `personal_info_id_uindex` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `online_store`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL DEFAULT 'CUSTOMER',
  `personal_info_id` INT(11) NOT NULL,
  `contact_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `users_contacts_id_fk` (`contact_id` ASC) VISIBLE,
  INDEX `users_personal_info_id_fk` (`personal_info_id` ASC) VISIBLE,
  CONSTRAINT `users_contacts_id_fk`
    FOREIGN KEY (`contact_id`)
    REFERENCES `online_store`.`contacts` (`id`),
  CONSTRAINT `users_personal_info_id_fk`
    FOREIGN KEY (`personal_info_id`)
    REFERENCES `online_store`.`personal_info` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `online_store`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`orders` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `orders_id_uindex` (`id` ASC) VISIBLE,
  INDEX `orders_users_id_fk` (`user_id` ASC) VISIBLE,
  CONSTRAINT `orders_users_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `online_store`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `online_store`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`products` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `price` DOUBLE NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `brand` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `products_id_uindex` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `online_store`.`orders_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store`.`orders_products` (
  `product_id` INT(11) NOT NULL,
  `order_id` INT(11) NOT NULL,
  INDEX `orders_products_orders_id_fk` (`order_id` ASC) VISIBLE,
  INDEX `orders_products_products_id_fk` (`product_id` ASC) VISIBLE,
  CONSTRAINT `orders_products_orders_id_fk`
    FOREIGN KEY (`order_id`)
    REFERENCES `online_store`.`orders` (`id`),
  CONSTRAINT `orders_products_products_id_fk`
    FOREIGN KEY (`product_id`)
    REFERENCES `online_store`.`products` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

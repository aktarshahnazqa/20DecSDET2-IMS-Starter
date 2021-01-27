drop schema ims;


CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE  `ims`.`items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `price` DOUBLE (4,2) NOT NULL,
    `genre` VARCHAR(50) NOT NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE `ims`.`orders` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `order_date` DATE NOT NULL,
     cid INT,
     PRIMARY KEY (`id`),
     FOREIGN KEY (cid) REFERENCES customers (id)
);


CREATE TABLE `ims`.`orderitems` (
    `id` INT NOT NULL AUTO_INCREMENT,
     oid INT,
     iid INT,
     PRIMARY KEY (`id`),
     FOREIGN KEY (oid) REFERENCES orders (id),
     FOREIGN KEY (iid) REFERENCES items (id)
);
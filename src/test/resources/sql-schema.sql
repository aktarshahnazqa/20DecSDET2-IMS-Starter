drop schema ims;
drop table orderitems;
drop table orders;
drop table items;
drop table customers;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE `items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `price` DOUBLE  NOT NULL,
    `genre` VARCHAR(50) NOT NULL,
     PRIMARY KEY (`id`)
);

CREATE TABLE orders` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `price` DATE NOT NULL,
     cid INT,
     PRIMARY KEY (`id`),
     FOREIGN KEY (cid) REFERENCES customers (id)
);


CREATE TABLE orderitems` (
    `id` INT NOT NULL AUTO_INCREMENT,
     oid INT,
     iid INT,
     PRIMARY KEY (`id`),
     FOREIGN KEY (oid) REFERENCES orders (id),
     FOREIGN KEY (iid) REFERENCES items (id)
);
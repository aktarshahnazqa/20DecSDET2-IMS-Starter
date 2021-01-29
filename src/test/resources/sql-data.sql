INSERT INTO `customers` (`first_name`, `surname`) VALUES ('shahnaz', 'aktar');
INSERT INTO `items` (`item_name`, `price`, `genre`) VALUES ('DeadPool', 6.99, 'Action');
INSERT INTO `orders`(`price`, `fk_id`) VALUES (11.99,'shahnaz', 'aktar' );
INSERT INTO `orderitems` (`fko_id`, `fki_id`) VALUES  (2,1);


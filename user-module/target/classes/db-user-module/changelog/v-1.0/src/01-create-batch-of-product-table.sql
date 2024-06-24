--
-- Структура таблицы `batch_of_product`
--
CREATE TABLE IF NOT EXISTS `batch_of_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID партии',
  `expiration_date_start` datetime NOT NULL COMMENT 'Дата начала срока годности товара',
  `expiration_date_end` datetime NOT NULL COMMENT 'Дата окончания срока годности товара',
  `product_id` bigint(20) NOT NULL COMMENT 'ID продукта из которого состоит партия',
  `count` int(15) NOT NULL COMMENT 'Количество товаров в партии',
  PRIMARY KEY (id),
  CONSTRAINT `batch_of_product_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COMMENT='Таблица партии товаров';
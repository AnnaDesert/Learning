--
-- Структура таблицы `product_catalog`
--

CREATE TABLE IF NOT EXISTS `product_catalog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Номер поставки',
  `id_shop` bigint(20) NOT NULL COMMENT 'ID торговой точки',
  `id_batch` bigint(20) NOT NULL COMMENT 'ID партии товара',
  `count` int(15) NOT NULL COMMENT 'Количество единиц товара',
  `price` float NOT NULL COMMENT 'Цена в конкретной торговой точке',
  `date` datetime NOT NULL COMMENT 'Дата поставки',
  PRIMARY KEY (id),
  CONSTRAINT `product_catalog_ibfk_1` FOREIGN KEY (`id_shop`) REFERENCES `shop` (`id`),
  CONSTRAINT `product_catalog_ibfk_2` FOREIGN KEY (`id_batch`) REFERENCES `batch_of_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица каталогов товаров';
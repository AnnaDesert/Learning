--
-- Структура таблицы `product_to_category`
--
CREATE TABLE IF NOT EXISTS `product_to_category` (
  `id_product` bigint(20) NOT NULL COMMENT 'ID тавара',
  `id_category` bigint(20) NOT NULL COMMENT 'ID категории тавара',
  CONSTRAINT `product_to_category_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `product_category` (`id`),
  CONSTRAINT `product_to_category_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица связи между таблицами products и products_categories';

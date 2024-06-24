--
-- Структура таблицы `product_category`
--
CREATE TABLE IF NOT EXISTS `product_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID категории товара',
  `name` varchar(255) NOT NULL COMMENT 'Название категории товара',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица категорий товаров';
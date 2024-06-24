--
-- Структура таблицы `product`
--
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID товара',
  `name` varchar(255) NOT NULL COMMENT 'Название товара',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица товаров';
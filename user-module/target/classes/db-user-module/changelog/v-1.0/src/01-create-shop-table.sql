--
-- Структура таблицы `shop`
--
CREATE TABLE IF NOT EXISTS `shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID торговой точки',
  `name` varchar(255) NOT NULL COMMENT 'Название торговой точки',
  `address` varchar(255) NOT NULL COMMENT 'Адрес торговой точки',
  `id_admin` bigint(20) NOT NULL COMMENT 'ID админа торговой точки',
  PRIMARY KEY (id),
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица торговых точек';

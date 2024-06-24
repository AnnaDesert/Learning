--
-- Структура таблицы `price_dynamics`
--
CREATE TABLE IF NOT EXISTS `price_dynamics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `id_shop` bigint(20) NOT NULL COMMENT 'ID торговой точки',
  `id_batch` bigint(20) NOT NULL COMMENT 'ID партии',
  `price` float NOT NULL COMMENT 'Цена на товар из партии',
  `date` datetime NOT NULL COMMENT 'Дата установления цены',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица для отслеживания динамики цен';
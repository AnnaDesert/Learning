--
-- Структура таблицы `product_catalog`
--

CREATE TABLE `product_catalog` (
  `id` bigint(20) NOT NULL COMMENT 'Номер поставки',
  `id_shop` bigint(20) NOT NULL COMMENT 'ID торговой точки',
  `id_batch` bigint(20) NOT NULL COMMENT 'ID партии товара',
  `count` int(15) NOT NULL COMMENT 'Количество единиц товара',
  `price` float NOT NULL COMMENT 'Цена в конкретной торговой точке'
  `date` datetime NOT NULL COMMENT 'Дата поставки'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица каталогов товаров';

--
-- Индексы таблицы `product_catalog`
--
ALTER TABLE `product_catalog`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_batch` (`id_batch`),
  ADD KEY `id_shop` (`id_shop`);

--
-- AUTO_INCREMENT для таблицы `product_catalog`
--
ALTER TABLE `product_catalog`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID каталога товара';

--
-- Триггеры `product_catalog`
--
CREATE TRIGGER `update_price_dynamics_after_insert` AFTER INSERT ON `product_catalog` FOR EACH ROW INSERT INTO price_dynamics(id_shop, id_batch, price, date)
VALUES(NEW.id_shop, NEW.id_batch, NEW.price, NOW());
CREATE TRIGGER `update_price_dynamics_after_update` AFTER UPDATE ON `product_catalog` FOR EACH ROW INSERT INTO price_dynamics(id_shop, id_batch, price, date)
VALUES(NEW.id_shop, NEW.id_batch, NEW.price, NOW());

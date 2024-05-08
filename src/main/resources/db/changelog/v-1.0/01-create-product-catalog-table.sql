--
-- Структура таблицы `product_catalog`
--

CREATE TABLE `product_catalog` (
  `id_shop` bigint(20) NOT NULL COMMENT 'ID торговой точки',
  `id_batch` bigint(20) NOT NULL COMMENT 'ID партии товара',
  `count` int(15) NOT NULL COMMENT 'Количество единиц товара',
  `price` float NOT NULL COMMENT 'Цена в конкретной торговой точке'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица каталогов товаров';

GO

--
-- Индексы таблицы `product_catalog`
--
ALTER TABLE `product_catalog`
  ADD KEY `id_shop` (`id_shop`) USING BTREE,
  ADD KEY `id_batch` (`id_batch`) USING BTREE;

GO

--
-- AUTO_INCREMENT для таблицы `product_category`
--
ALTER TABLE `product_category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID категории товара';

GO
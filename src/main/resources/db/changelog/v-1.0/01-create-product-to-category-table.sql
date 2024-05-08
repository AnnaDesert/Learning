--
-- Структура таблицы `product_to_category`
--

CREATE TABLE `product_to_category` (
  `id_product` bigint(20) NOT NULL COMMENT 'ID тавара',
  `id_category` bigint(20) NOT NULL COMMENT 'ID категории тавара'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица связи между таблицами products и products_categories';

GO

--
-- Индексы таблицы `product_to_category`
--
ALTER TABLE `product_to_category`
  ADD KEY `id_category` (`id_category`),
  ADD KEY `id_product` (`id_product`);

GO
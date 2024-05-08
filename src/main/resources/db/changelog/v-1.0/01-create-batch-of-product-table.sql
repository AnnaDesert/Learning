--
-- Структура таблицы `batch_of_product`
--

CREATE TABLE `batch_of_product` (
  `id` bigint(20) NOT NULL COMMENT 'ID партии',
  `expiration_date_start` datetime NOT NULL COMMENT 'Дата начала срока годности товара',
  `expiration_date_end` datetime NOT NULL COMMENT 'Дата окончания срока годности товара',
  `id_product` bigint(20) NOT NULL COMMENT 'ID продукта из которого состоит партия',
  `count` int(15) NOT NULL COMMENT 'Количество товаров в партии'
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COMMENT='Таблица партии товаров';

GO

--
-- Индексы таблицы `batch_of_product`
--
ALTER TABLE `batch_of_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_product` (`id_product`);

GO

--
-- AUTO_INCREMENT для таблицы `batch_of_product`
--
ALTER TABLE `batch_of_product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID партии';

GO
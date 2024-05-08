--
-- Структура таблицы `product_category`
--

CREATE TABLE `product_category` (
  `id` bigint(20) NOT NULL COMMENT 'ID категории товара',
  `name` varchar(255) NOT NULL COMMENT 'Название категории товара'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица категорий товаров';

GO

--
-- Индексы таблицы `product_category`
--
ALTER TABLE `product_category`
  ADD PRIMARY KEY (`id`);

GO

--
-- AUTO_INCREMENT для таблицы `product_category`
--
ALTER TABLE `product_category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID категории товара';

GO
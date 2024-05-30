--
-- Структура таблицы `product`
--
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL COMMENT 'ID товара',
  `name` varchar(255) NOT NULL COMMENT 'Название товара'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица товаров';

--
-- Индексы таблицы `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для таблицы `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID товара';
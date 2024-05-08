--
-- Структура таблицы `shop`
--

CREATE TABLE `shop` (
  `id` bigint(20) NOT NULL COMMENT 'ID торговой точки',
  `name` varchar(255) NOT NULL COMMENT 'Название торговой точки',
  `address` varchar(255) NOT NULL COMMENT 'Адрес торговой точки',
  `id_admin` bigint(20) NOT NULL COMMENT 'ID админа торговой точки'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица торговых точек';

GO

--
-- Индексы таблицы `shop`
--
ALTER TABLE `shop`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_admin` (`id_admin`);

GO

--
-- AUTO_INCREMENT для таблицы `shop`
--
ALTER TABLE `shop`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID торговой точки';

GO
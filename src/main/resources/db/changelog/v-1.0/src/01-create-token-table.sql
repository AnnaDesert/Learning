--
-- Структура таблицы `token`
--
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL COMMENT 'ID токена',
  `user_id` bigint(20) NOT NULL COMMENT 'ID пользователя',
  `token` varchar(255) NOT NULL COMMENT 'Токен',
  `token_type` enum('BEARER') NOT NULL DEFAULT 'BEARER' COMMENT 'Тип токена',
  `revoked` boolean NOT NULL COMMENT 'Флаг того, что токен аннулированный',
  `expired` boolean NOT NULL COMMENT 'Флаг того, что токен истекший'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица токенов';

--
-- Индексы таблицы `token`
--
ALTER TABLE `token`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для таблицы `token`
--
ALTER TABLE `token`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID токена';
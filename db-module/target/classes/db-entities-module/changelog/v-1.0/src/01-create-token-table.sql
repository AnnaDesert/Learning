--
-- Структура таблицы `token`
--
CREATE TABLE IF NOT EXISTS `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID токена',
  `user_id` bigint(20) NOT NULL COMMENT 'ID пользователя',
  `token` varchar(255) NOT NULL COMMENT 'Токен',
  `token_type` enum('BEARER') NOT NULL DEFAULT 'BEARER' COMMENT 'Тип токена',
  `revoked` boolean NOT NULL COMMENT 'Флаг того, что токен аннулированный',
  `expired` boolean NOT NULL COMMENT 'Флаг того, что токен истекший',
  PRIMARY KEY (id),
  CONSTRAINT `token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица токенов';
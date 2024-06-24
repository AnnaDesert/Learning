--
-- Структура таблицы `user`
--
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID пользователя',
  `name` varchar(255) NOT NULL COMMENT 'Имя пользователя',
  `password` varchar(255) NOT NULL COMMENT 'Пароль пользователя',
  `surname` varchar(255) NOT NULL COMMENT 'Фамилия пользователя',
  `phone_number` char(15) NOT NULL COMMENT 'Номер телефона пользователя',
  `email` varchar(255) NOT NULL COMMENT 'Email пользователя',
  `role` enum('SUPER_ADMIN','ADMIN','USER') NOT NULL DEFAULT 'USER' COMMENT 'Роль пользователя',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица пользователей';
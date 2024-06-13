INSERT INTO product (id, name)
VALUES (1, "Молоко"),
       (2, "Яйцо куриное"),
       (3, "Печенье");

INSERT INTO batch_of_product (id, expiration_date_start, expiration_date_end, id_product, count)
VALUES (1, "2024-05-16 07:07:24", "2024-05-16 07:07:24", 1, 2),
       (2, "2024-05-16 07:07:24", "2024-05-16 07:07:24", 2, 45),
       (3, "2024-05-16 07:07:24", "2024-05-16 07:07:24", 3, 56);

INSERT INTO user (id, name, surname, password, phone_number, email, role)
VALUES (1, "Игорь", "Произвольный", "1q2w3e4r5t6y", "7 980 454 34 34", "proizwol@mail.ru", "USER"),
       (2, "Кирил", "Случайный", "1q2w3er5t6y", "7 982 454 34 34", "sluch@mail.ru", "SUPER_ADMIN"),
       (3, "Антон", "Рандомный", "1q2we4r5t6y", "7 980 484 34 34", "rand@gmail.com", "ADMIN");

INSERT INTO shop (id, name, address, id_admin)
VALUES (1, "Рыба и мясо", "ул. Мясной переулок 4", 1),
       (2, "Молочный", "ул. Мясной переулок 12", 2),
       (3, "Мир колбас", "ул. Криптовая 34", 3);

INSERT INTO product_catalog (id, id_shop, id_batch, count, price)
VALUES (1, 1, 1, 2, 25.0),
       (2, 2, 2, 34, 45.50),
       (3, 3, 3, 52, 56.0);

INSERT INTO product_category (id, name)
VALUES (1, "Алкоголь"),
       (2, "Выпечка"),
       (3, "Птица");
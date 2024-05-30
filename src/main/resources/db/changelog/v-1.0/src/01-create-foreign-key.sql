--
-- Ограничения внешнего ключа таблицы `batch_of_product`
--
ALTER TABLE `batch_of_product`
  ADD CONSTRAINT `batch_of_product_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Ограничения внешнего ключа таблицы `product_catalog`
--
ALTER TABLE `product_catalog`
  ADD CONSTRAINT `product_catalog_ibfk_1` FOREIGN KEY (`id_shop`) REFERENCES `shop` (`id`),
  ADD CONSTRAINT `product_catalog_ibfk_2` FOREIGN KEY (`id_batch`) REFERENCES `batch_of_product` (`id`);

--
-- Ограничения внешнего ключа таблицы `product_to_category`
--
ALTER TABLE `product_to_category`
  ADD CONSTRAINT `product_to_category_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `product_category` (`id`),
  ADD CONSTRAINT `product_to_category_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Ограничения внешнего ключа таблицы `shop`
--
ALTER TABLE `shop`
  ADD CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `user` (`id`);
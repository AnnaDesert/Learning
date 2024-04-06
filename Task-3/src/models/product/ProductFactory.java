package models.product;

import enums.EProductType;

/**
 * Класс фабрика продуктов
 * @author Максим Ведеников
 */
public class ProductFactory {
	public Product createProduct(EProductType productType, long id, int price, int dueDate) {
		Product product = null;

		switch(productType) {
			case CAR -> product = new Car(id, price, dueDate);
			case PEN -> product = new Pen(id, price, dueDate);
			case TANK -> product = new Tank(id, price, dueDate);
			case GLASSES -> product = new Glasses(id, price, dueDate);
			case LAPTOP -> product = new Laptop(id, price, dueDate);
		}

		return product;
	}
}
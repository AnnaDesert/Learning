package models.product;

import enums.EProductType;

/**
 * Класс продукта типа CAR
 * @author Максим Ведеников
 */
public class Car extends Product {
	/** Конструкторы */
	public Car(long id, int price, int dueDate) {
		super(EProductType.CAR, id, price, dueDate);
	}
	public Car(long id, int price) {
		this(id, price, EProductType.CAR.getDefDueDate());
	}
	public Car(long id) {
		this(id, EProductType.CAR.getDefPrice());
	}
}
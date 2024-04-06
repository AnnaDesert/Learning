package models.product;

import enums.EProductType;

/**
 * Класс продукта типа LAPTOP
 * @author Максим Ведеников
 */
public class Laptop extends Product {
	/** Конструкторы */
	public Laptop(long id, int price, int dueDate) {
		super(EProductType.LAPTOP, id, price, dueDate);
	}
	public Laptop(long id, int price) {
		this(id, price, EProductType.LAPTOP.getDefDueDate());
	}
	public Laptop(long id) {
		this(id, EProductType.LAPTOP.getDefPrice());
	}
}
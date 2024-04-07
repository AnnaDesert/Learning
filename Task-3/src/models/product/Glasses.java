package models.product;

import enums.EProductType;

/**
 * Класс продукта типа GLASSES
 * @author Максим Ведеников
 */
public class Glasses extends Product {
	/** Конструкторы */
	public Glasses(long id, int price, int dueDate) {
		super(EProductType.GLASSES, id, price, dueDate);
	}
	public Glasses(long id, int price) {
		this(id, price, EProductType.GLASSES.getDefDueDate());
	}
	public Glasses(long id) {
		this(id, EProductType.GLASSES.getDefPrice());
	}
}
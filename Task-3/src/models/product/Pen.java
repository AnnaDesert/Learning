package models.product;

import enums.EProductType;

/**
 * Класс продукта типа PEN
 * @author Максим Ведеников
 */
public class Pen extends Product {
	/** Конструкторы */
	public Pen(long id, int price, int dueDate) {
		super(EProductType.PEN, id, price, dueDate);
	}
	public Pen(long id, int price) {
		this(id, price, EProductType.PEN.getDefDueDate());
	}
	public Pen(long id) {
		this(id, EProductType.PEN.getDefPrice());
	}
}
package models.product;

import enums.EProductType;

/**
 * Класс продукта типа TANK
 * @author Максим Ведеников
 */
public class Tank extends Product{
	/** Конструкторы */
	public Tank(long id, int price, int dueDate) {
		super(EProductType.TANK, id, price, dueDate);
	}
	public Tank(long id, int price) {
		this(id, price, EProductType.TANK.getDefDueDate());
	}
	public Tank(long id) {
		this(id, EProductType.TANK.getDefPrice());
	}
}
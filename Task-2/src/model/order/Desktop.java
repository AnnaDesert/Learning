package model.order;

import model.enums.TypeSoftware;
import model.order.Order;

/**
 * Класс заказа типа Desktop
 * @author Максим Ведеников
 */
public class Desktop extends Order {
	/** 
	 * Конструктор с 3-мя аргументами
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на выполнение заказа
	 */
	public Desktop(String name, int price, int dueDate) {
		super(name, TypeSoftware.Desktop, price, dueDate);
	}
	/** 
	 * Конструктор с 2-мя аргументами
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 */
	public Desktop(String name, int price) {
		this(name, price, TypeSoftware.Desktop.getDefDueDate());
	}
	/** 
	 * Конструктор с 1-ним аргументом
	 * @param  name -- имя заказа
	 */
	public Desktop(String name) {
		this(name, TypeSoftware.Desktop.getDefPrice());
	}
}
package order.mobile;

import typesoftware.TypeSoftware;
import order.Order;

/**
 * Класс заказа типа Mobile
 * @author Максим Ведеников
 */
public class Mobile extends Order {
	/** 
	 * Конструктор с 3-мя аргументами
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на выполнение заказа
	 */
	public Mobile(String name, int price, int dueDate) {
		super(name, TypeSoftware.Mobile, price, dueDate);
	}
	/** 
	 * Конструктор с 2-мя аргументами
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 */
	public Mobile(String name, int price) {
		this(name, price, TypeSoftware.Mobile.getDefDueDate());
	}
	/** 
	 * Конструктор с 1-ним аргументом
	 * @param  name -- имя заказа
	 */
	public Mobile(String name) {
		this(name, TypeSoftware.Mobile.getDefPrice());
	}
}
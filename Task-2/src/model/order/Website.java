package model.order;

import model.enums.TypeSoftware;
import model.order.Order;

/**
 * Класс заказа типа Website
 * @author Максим Ведеников
 */
public class Website extends Order {
	/** 
	 * Конструктор с 3-мя аргументами
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на выполнение заказа
	 */
	public Website(String name, int price, int dueDate) {
		super(name, TypeSoftware.Website, price, dueDate);
	}
	/** 
	 * Конструктор с 2-мя аргументами
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 */
	public Website(String name, int price) {
		this(name, price, TypeSoftware.Website.getDefDueDate());
	}
	/** 
	 * Конструктор с 1-ним аргументом
	 * @param  name -- имя заказа
	 */
	public Website(String name) {
		this(name, TypeSoftware.Website.getDefPrice());
	}
}
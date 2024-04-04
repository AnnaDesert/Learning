package model.order;

import model.enums.TypeSoftware;
import model.order.Order;

/**
 * Класс заказа типа Service
 * @author Максим Ведеников
 */
public class Service extends Order {
	/** 
	 * Конструктор с 3-мя аргументами
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на выполнение заказа
	 */
	public Service(String name, int price, int dueDate) {
		super(name, TypeSoftware.Service, price, dueDate);
	}
	/** 
	 * Конструктор с 2-мя аргументами
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 */
	public Service(String name, int price) {
		this(name, price, TypeSoftware.Service.getDefDueDate());
	}
	/** 
	 * Конструктор с 1-ним аргументом
	 * @param  name -- имя заказа
	 */
	public Service(String name) {
		this(name, TypeSoftware.Service.getDefPrice());
	}
}
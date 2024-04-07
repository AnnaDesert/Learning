package model.order;

import model.enums.TypeSoftware;
import interfaces.IOrder;

/**
 * Класс заказа типа Mobile
 * @author Максим Ведеников
 */
public class Mobile extends Order implements IOrder {
	/** 
	 * Конструкторы
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на выполнение заказа
	 */
	public Mobile(String name, int price, int dueDate) {
		super(name, TypeSoftware.Mobile, price, dueDate);
	}
	public Mobile(String name, int price) {
		this(name, price, TypeSoftware.Mobile.getDefDueDate());
	}
	public Mobile(String name) {
		this(name, TypeSoftware.Mobile.getDefPrice());
	}
}
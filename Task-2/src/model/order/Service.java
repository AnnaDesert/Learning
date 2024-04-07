package model.order;

import model.enums.TypeSoftware;
import interfaces.IOrder;

/**
 * Класс заказа типа Service
 * @author Максим Ведеников
 */
public class Service extends Order implements IOrder {
	/** 
	 * Конструкторы
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на выполнение заказа
	 */
	public Service(String name, int price, int dueDate) {
		super(name, TypeSoftware.Service, price, dueDate);
	}
	public Service(String name, int price) {
		this(name, price, TypeSoftware.Service.getDefDueDate());
	}
	public Service(String name) {
		this(name, TypeSoftware.Service.getDefPrice());
	}
}
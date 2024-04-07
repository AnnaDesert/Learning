package model.order;

import model.enums.TypeSoftware;
import interfaces.IOrder;

/**
 * Класс заказа типа Website
 * @author Максим Ведеников
 */
public class Website extends Order implements IOrder {
	/** 
	 * Конструкторы
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на выполнение заказа
	 */
	public Website(String name, int price, int dueDate) {
		super(name, TypeSoftware.Website, price, dueDate);
	}
	public Website(String name, int price) {
		this(name, price, TypeSoftware.Website.getDefDueDate());
	}
	public Website(String name) {
		this(name, TypeSoftware.Website.getDefPrice());
	}
}
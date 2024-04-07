package model.order;

import model.enums.TypeSoftware;
import interfaces.IOrder;

/**
 * Класс заказа типа Desktop
 * @author Максим Ведеников
 */
public class Desktop extends Order implements IOrder {
	/** 
	 * Конструкторы
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на выполнение заказа
	 */
	public Desktop(String name, int price, int dueDate) {
		super(name, TypeSoftware.Desktop, price, dueDate);
	}
	public Desktop(String name, int price) {
		this(name, price, TypeSoftware.Desktop.getDefDueDate());
	}
	public Desktop(String name) {
		this(name, TypeSoftware.Desktop.getDefPrice());
	}
}
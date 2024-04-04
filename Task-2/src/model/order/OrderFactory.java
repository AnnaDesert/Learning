package model.order;

import model.enums.TypeSoftware;
import model.order.Website;
import model.order.Desktop;
import model.order.Service;
import model.order.Mobile;
import interfaces.iorder.IOrder;
import interfaces.iorder.IOrderFactory;

/**
 * Класс фабрика заказов
 * @author Максим Ведеников
 */
public class OrderFactory implements IOrderFactory{
	/**
	 * создает заказ
	 * @param  typeSoftware -- тип заказа
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на завершение заказа
	 * @return возвращает заказ
	 */
	public IOrder createOrder(TypeSoftware typeSoftware, String name, int price, int dueDate) {
		IOrder order = null;

		switch(typeSoftware) {
			case Website:
				order = new Website(name, price, dueDate);
				break;
			case Desktop:
				order = new Desktop(name, price, dueDate);
				break;
			case Service:
				order = new Service(name, price, dueDate);
				break;
			case Mobile:
				order = new Mobile(name, price, dueDate);
				break;
		}

		return order;
	}
	/**
	 * создает заказ
	 * @param  typeSoftware -- тип заказа
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @return возвращает заказ
	 */
	public IOrder createOrder(TypeSoftware typeSoftware, String name, int price) {
		IOrder order = null;

		switch(typeSoftware) {
			case Website:
				order = new Website(name, price);
				break;
			case Desktop:
				order = new Desktop(name, price);
				break;
			case Service:
				order = new Service(name, price);
				break;
			case Mobile:
				order = new Mobile(name, price);
				break;
		}

		return order;
	}
	/**
	 * создает заказ
	 * @param  typeSoftware -- тип заказа
	 * @param  name -- имя заказа
	 * @return возвращает заказ
	 */
	public IOrder createOrder(TypeSoftware typeSoftware, String name) {
		IOrder order = null;

		switch(typeSoftware) {
			case Website:
				order = new Website(name);
				break;
			case Desktop:
				order = new Desktop(name);
				break;
			case Service:
				order = new Service(name);
				break;
			case Mobile:
				order = new Mobile(name);
				break;
		}

		return order;
	}
}
package order.orderfactory;

import typesoftware.TypeSoftware;
import order.Order;
import order.website.Website;
import order.desktop.Desktop;
import order.service.Service;
import order.mobile.Mobile;

/**
 * Класс фабрика заказов
 * @author Максим Ведеников
 */
public class OrderFactory {
	/**
	 * создает заказ
	 * @param  typeSoftware -- тип заказа
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на завершение заказа
	 * @return возвращает заказ
	 */
	public Order createOrder(TypeSoftware typeSoftware, String name, int price, int dueDate) {
		Order order = null;

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
	public Order createOrder(TypeSoftware typeSoftware, String name, int price) {
		Order order = null;

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
	public Order createOrder(TypeSoftware typeSoftware, String name) {
		Order order = null;

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
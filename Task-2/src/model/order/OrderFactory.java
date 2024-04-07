package model.order;

import model.enums.TypeSoftware;
import interfaces.IOrder;
import interfaces.AbstractFactory;

/**
 * Класс фабрика заказов
 * @author Максим Ведеников
 */
public class OrderFactory implements AbstractFactory {
	/**
	 * создает заказ
	 * @param  typeSoftware -- тип заказа
	 * @param  name -- имя заказа
	 * @param  price -- цена заказа
	 * @param  dueDate -- время на завершение заказа
	 * @return возвращает заказ
	 */
	public IOrder getOrder(TypeSoftware typeSoftware, String name, int price, int dueDate) {
		switch(typeSoftware) {
			case Website -> {return new Website(name, price, dueDate);}
			case Desktop -> {return new Desktop(name, price, dueDate);}
			case Service -> {return new Service(name, price, dueDate);}
			case Mobile -> {return new Mobile(name, price, dueDate);}
		}
		return null;
	} 
	public IOrder getOrder(TypeSoftware typeSoftware, String name, int price) {
		switch(typeSoftware) {
			case Website -> {return new Website(name, price);}
			case Desktop -> {return new Desktop(name, price);}
			case Service -> {return new Service(name, price);}
			case Mobile -> {return new Mobile(name, price);}
		}
		return null;
	} 
	public IOrder getOrder(TypeSoftware typeSoftware, String name) {
		switch(typeSoftware) {
			case Website -> {return new Website(name);}
			case Desktop -> {return new Desktop(name);}
			case Service -> {return new Service(name);}
			case Mobile -> {return new Mobile(name);}
		}
		return null;
	}
}
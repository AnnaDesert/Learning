package model;

import model.enums.TypeFactory;
import interfaces.AbstractFactory;
import model.employee.EmployeeFactory;
import model.order.OrderFactory;

/**
 * Класс создатель факторий
 * @author Максим Ведеников
 */
public class FactoryProducer {
	public static AbstractFactory getFactory(TypeFactory typeFactory) {
		switch(typeFactory) {
			case ORDER -> {return new OrderFactory();}
			case EMPLOYEE -> {return new EmployeeFactory();}
		}
		return null;
	} 
}
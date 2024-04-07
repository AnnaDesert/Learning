package interfaces;

import model.enums.TypeSoftware;
import model.enums.Rang;

/**
 * Интерфейс фабрика заказов
 * @author Максим Ведеников
 */
public interface AbstractFactory {
	default IOrder getOrder(TypeSoftware typeSoftware, String name, int price, int dueDate) {return null;} 
	default IOrder getOrder(TypeSoftware typeSoftware, String name, int price) {return null;} 
	default IOrder getOrder(TypeSoftware typeSoftware, String name) {return null;} 
		
	default IEmployee getEmployee(Rang rang, String name, int salary) {return null;} 
	default IEmployee getEmployee(Rang rang, String name) {return null;} 
}
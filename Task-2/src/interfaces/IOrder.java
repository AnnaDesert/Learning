package interfaces;

import model.enums.TypeSoftware;

/**
 * Интерфейс заказа
 * @author Максим Ведеников
 */
public interface IOrder {
	TypeSoftware getTSoft();
	int getPrice();
	String getNameOrder();
	int getDueDate();
}
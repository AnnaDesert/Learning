package interfaces.iorder;

import model.enums.TypeSoftware;

/**
 * Интерфейс фабрика заказов
 * @author Максим Ведеников
 */
public interface IOrderFactory {
	public IOrder createOrder(TypeSoftware typeSoftware, String name, int price, int dueDate);
	public IOrder createOrder(TypeSoftware typeSoftware, String name, int price);
	public IOrder createOrder(TypeSoftware typeSoftware, String name);
}
package interfaces.iorder;

import model.enums.TypeSoftware;

/**
 * Интерфейс заказа
 * @author Максим Ведеников
 */
public interface IOrder {
	/** get-методы */
	public TypeSoftware getTSoft();
	public int getPrice();
	public String getNameOrder();
	public int getDueDate();

	/** set-методы */
	public void setTSoft(TypeSoftware tSoft);
	public void setPrice(int price);
	public void setNameOrder(String nameOrder);
	public void setDueDate(int dueDate);
}
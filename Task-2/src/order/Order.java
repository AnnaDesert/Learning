package order;

import tSoftware.*;

// класс заказов
public class Order {
	// имя заказа
	private String nameOrder;
	// тип заказа
	private tSoftware tSoft;
	// цена заказа
	private int price;
	// срок выполнения заказа
	private int dueDate;

	public Order(String nO, tSoftware tS, int p, int dDate) {
		nameOrder = nO;
		tSoft = tS;
		price = p;
		dueDate = dDate;
	}

	public tSoftware getTSoft() {
		return tSoft;
	}
	public int getPrice() {
		return price;
	}
	public String getNameOrder() {
		return nameOrder;
	}
	public int getDueDate() {
		return dueDate;
	}

	public String toString() {
		return "Название: "+nameOrder+"\nТип: "+tSoft.getDesc()+"\nЦенна: "+price+
				"\nВремя на выплннение: "+dueDate;
	}
}
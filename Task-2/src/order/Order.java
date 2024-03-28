package order;

import tSoftware.*;

public class Order {
	private String nameOrder;
	private tSoftware tSoft;
	private int price;
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
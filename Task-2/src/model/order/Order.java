package model.order;

import model.enums.TypeSoftware;
import interfaces.iorder.IOrder;

/**
 * Класс заказа
 * @author Максим Ведеников
 */
public abstract class Order implements IOrder {
	/** Имя заказа */
	private String nameOrder;
	/** Тип заказа */
	private TypeSoftware tSoft;
	/** Цена заказа */
	private int price;
	/** Время на выполнение заказа */
	private int dueDate;

	/** 
	 * Конструктор с 4-мя аргументами
	 * @param  nO -- имя заказа
	 * @param  tS -- тип заказа
	 * @param  p -- цена заказа
	 * @param  dDate -- время на выполнение заказа
	 */
	public Order(String nO, TypeSoftware tS, int p, int dDate) {
		nameOrder = nO;
		tSoft = tS;
		price = p;
		dueDate = dDate;
	}
	/** Конструктор без аргументов */
	public Order() {};

	/** get-методы */
	public TypeSoftware getTSoft() {return tSoft;}
	public int getPrice() {return price;}
	public String getNameOrder() {return nameOrder;}
	public int getDueDate() {return dueDate;}

	/** set-методы */
	public void setTSoft(TypeSoftware tSoft) {this.tSoft = tSoft;}
	public void setPrice(int price) {this.price = price;}
	public void setNameOrder(String nameOrder) {this.nameOrder = nameOrder;}
	public void setDueDate(int dueDate) {this.dueDate = dueDate;}

	/** Вывод */
	public String toString() {
		return "Название: "+nameOrder+"\nТип: "+tSoft.getDesc()+"\nЦенна: "+price+
				"\nВремя на выплннение: "+dueDate;
	}
}
package model.enums;

/**
 * Перечисление видов факторий
 * @author Максим Ведеников
 */
public enum TypeFactory { 
	ORDER("Заказ"), 
	EMPLOYEE("Сотрудник");

	/** Русское описание */
	private String ruDesc;
	
	/**
	 * Конструктор
	 * @param d -- русское описание
	 */
	TypeFactory(String d) {
		ruDesc = d;
	}

	/** get-методы */
	public String getDesc() {return ruDesc;}
}
package model.enums;

/**
 * Перечисление типов ПО 
 * @author Максим Ведеников
 */
public enum TypeSoftware { 
	Website("Веб-сайт", 15000, 56), 
	Desktop("Настольное приложение", 50000, 120), 
	Service("Серсив", 30000, 56),
	Mobile("Мобильное-приложнение", 45000, 120);

	/** Русское описание */
	private String ruDesc;
	/** Стандартная цена */
	private int defPrice;
	/** Стандартное время */
	private int defDueDate;

	/**
	 * Конструктор
	 * @param d -- русское описание
	 * @param price -- цена
	 * @param dueDate -- время
	 */
	TypeSoftware(String d, int price, int dueDate) {
		ruDesc = d;
		defPrice = price;
		defDueDate = dueDate;
	}

	/** get-методы */
	public String getDesc() {return ruDesc;}
	public int getDefPrice() {return defPrice;}
	public int getDefDueDate() {return defDueDate;}
}
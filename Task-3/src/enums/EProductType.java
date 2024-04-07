package enums;

/**
 * Перечисление типов продукции 
 * @author Максим Ведеников
 */
public enum EProductType { 
	CAR("Автомобиль", 1200000, 300), 
	TANK("Танк", 10000000, 600), 
	LAPTOP("Ноутбук", 50000, 200),
	GLASSES("Очки", 500, 86),
	PEN("Автоматическая шариковая ручка", 150, 30);

	/** Русское описание */
	private String ruDesc;
	/** Стандартная цена */
	private int defPrice;
	/** Стандартное время производства */
	private int defDueDate;

	/**
	 * Конструктор
	 * @param d -- русское описание
	 * @param price -- цена
	 * @param dueDate -- время
	 */
	EProductType(String d, int price, int dueDate) {
		ruDesc = d;
		defPrice = price;
		defDueDate = dueDate;
	}

	/** get-методы */
	public String getDesc() {return ruDesc;}
	public int getDefPrice() {return defPrice;}
	public int getDefDueDate() {return defDueDate;}
}
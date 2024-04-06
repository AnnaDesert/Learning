package enums;

/**
 * Перечисление типов частей автоматической шариковой ручки
 * @author Максим Ведеников
 */
public enum EPenPart { 
	BODY("Корпус"), 
	SPRING("Пружина"), 
	ROD("Стержень");

	/** Русское описание */
	private String ruDesc;

	/**
	 * Конструктор
	 * @param d -- русское описание
	 */
	EPenPart(String d) {
		ruDesc = d;
	}

	/** get-методы */
	public String getDesc() {return ruDesc;}
}
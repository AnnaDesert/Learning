package enums;

/**
 * Перечисление типов частей ноутбука
 * @author Максим Ведеников
 */
public enum ELaptopPart { 
	BODY("Корпус"), 
	MOTHERBOARD("Материнская плата"), 
	MONITOR("Монитор");

	/** Русское описание */
	private String ruDesc;

	/**
	 * Конструктор
	 * @param d -- русское описание
	 */
	ELaptopPart(String d) {
		ruDesc = d;
	}

	/** get-методы */
	public String getDesc() {return ruDesc;}
}
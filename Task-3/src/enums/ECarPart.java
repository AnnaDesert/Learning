package enums;

/**
 * Перечисление типов частей машины 
 * @author Максим Ведеников
 */
public enum ECarPart { 
	BODY("Кузов"), 
	CHASSIS("Шасси"), 
	ENGINE("Двигатель");

	/** Русское описание */
	private String ruDesc;

	/**
	 * Конструктор
	 * @param d -- русское описание
	 */
	ECarPart(String d) {
		ruDesc = d;
	}

	/** get-методы */
	public String getDesc() {return ruDesc;}
}
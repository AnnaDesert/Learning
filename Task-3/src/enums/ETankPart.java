package enums;

/**
 * Перечисление типов частей танка 
 * @author Максим Ведеников
 */
public enum ETankPart { 
	BODY("Корпус"), 
	TOWER("Башня"), 
	ENGINE("Двигатель");

	/** Русское описание */
	private String ruDesc;

	/**
	 * Конструктор
	 * @param d -- русское описание
	 */
	ETankPart(String d) {
		ruDesc = d;
	}

	/** get-методы */
	public String getDesc() {return ruDesc;}
}
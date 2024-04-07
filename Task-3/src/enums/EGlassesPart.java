package enums;

/**
 * Перечисление типов частей очков
 * @author Максим Ведеников
 */
public enum EGlassesPart { 
	BODY("Корпус"), 
	LENSES("Линза"), 
	SHACKLES("Дужка");

	/** Русское описание */
	private String ruDesc;

	/**
	 * Конструктор
	 * @param d -- русское описание
	 */
	EGlassesPart(String d) {
		ruDesc = d;
	}

	/** get-методы */
	public String getDesc() {return ruDesc;}
}
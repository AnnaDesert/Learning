package rang;

/**
 * Перечисление должностей сотрудников
 * @author Максим Ведеников
 */
public enum Rang { 
	Head("Руководитель", 200000), 
	Senior("Старший разработчик", 180000), 
	Middle("Разработчик", 150000),
	Junior("Младший разработчик", 120000),
	Analyst("Аналитик", 90000); 

	/** Русское описание */
	private String ruDesc;
	/** Стандартная ЗП */
	private int defSalary;
	
	/**
	 * Конструктор
	 * @param d -- русское описание
	 * @param salary -- ЗП
	 */
	Rang(String d, int salary) {
		ruDesc = d;
		defSalary = salary;
	}

	/** get-методы */
	public String getDesc() {return ruDesc;}
	public int getDefSalary() {return defSalary;}
}
package rang;

// перечесление званий
public enum Rang { 
	Head("Руководитель"), 
	Senior("Старший разработчик"), 
	Middle("Разработчик"),
	Junior("Младший разработчик"),
	Analyst("Аналитик"); 

	// описание
	String ruDesc;
	Rang(String d) {
		ruDesc = d;
	}
	public String getDesc() {return ruDesc;}
}
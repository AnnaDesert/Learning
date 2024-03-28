package rang;

public enum Rang { 
	Head("Руководитель"), 
	Senior("Старший разработчик"), 
	Middle("Разработчик"),
	Junior("Младший разработчик"),
	Analyst("Аналитик"); 

	String ruDesc;
	Rang(String d) {
		ruDesc = d;
	}
	public String getDesc() {return ruDesc;}
}
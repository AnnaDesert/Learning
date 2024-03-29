package tSoftware;

// перечесление типов заказаов
public enum tSoftware { 
	Website("Веб-сайт"), 
	Desktop("Настольное приложение"), 
	Service("Серсив"),
	Mobile("Мобильное-приложнение");

	// описание
	String ruDesc;
	tSoftware(String d) {
		ruDesc = d;
	}
	public String getDesc() {return ruDesc;}
}
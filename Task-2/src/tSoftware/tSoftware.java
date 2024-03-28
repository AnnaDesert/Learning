package tSoftware;

public enum tSoftware { 
	Website("Веб-сайт"), 
	Desktop("Настольное приложение"), 
	Service("Серсив"),
	Mobile("Мобильное-приложнение");

	String ruDesc;
	tSoftware(String d) {
		ruDesc = d;
	}
	public String getDesc() {return ruDesc;}
}
package employee;

import rang.*;

// класс работник
public class Employee {
	// имя
	private String name;
	// должность
	private Rang r;
	// ЗП
	private int salary;

	public Employee(String n, Rang r, int s) {
		name = n;
		this.r = r;
		salary = s;
	}

	public Rang getRang() {
		return r;
	}
	public int getSalary() {
		return salary;
	}
	public String getName() {
		return name;
	}

	public String toString() {
		return "Имя: "+name+"\nДлжность: "+r.getDesc()+"\nЗП: "+salary;
	}
}
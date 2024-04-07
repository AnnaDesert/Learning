package model.employee;

import model.enums.Rang;

/**
 * Класс сотрудник
 * @author Максим Ведеников
 */
public abstract class Employee {
	/** Имя сотрудника */
	private String name;
	/** Должность сотрудника */
	private Rang r;
	/** ЗП сотрудника */
	private int salary;

	/** 
	 * Конструкторы
	 * @param  n -- имя сотрудника
	 * @param  r -- должность сотрудника
	 * @param  s -- ЗП сотрудника
	 */
	public Employee(String n, Rang r, int s) {
		name = n;
		this.r = r;
		salary = s;
	}
	public Employee() {};

	/** get-методы */
	public Rang getRang() {return r;}
	public int getSalary() {return salary;}
	public String getName() {return name;}

	/** set-методы */
	public void setRang(Rang r) {this.r = r;}
	public void setSalary(int salary) {this.salary = salary;}
	public void setName(String name) {this.name = name;}
	
	/** Вывод */
	public String toString() {return "Имя: "+name+"\nДлжность: "+r.getDesc()+"\nЗП: "+salary;}
}
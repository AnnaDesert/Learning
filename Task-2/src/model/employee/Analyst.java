package model.employee;

import model.enums.Rang;
import model.employee.Employee;

/**
 * Класс сотрудник должности Analyst
 * @author Максим Ведеников
 */
public class Analyst extends Employee {
	/** 
	 * Конструктор с 2-мя аргументами
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 */
	public Analyst(String name, int salary) {
		super(name, Rang.Analyst, salary);
	}
	/** 
	 * Конструктор с 1-ним аргументом
	 * @param  name -- имя сотрудника
	 */
	public Analyst(String name) {
		this(name, Rang.Analyst.getDefSalary());
	}
}
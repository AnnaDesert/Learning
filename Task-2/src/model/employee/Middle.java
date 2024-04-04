package model.employee;

import model.enums.Rang;
import model.employee.Employee;

/**
 * Класс сотрудник должности Middle
 * @author Максим Ведеников
 */
public class Middle extends Employee {
	/** 
	 * Конструктор с 2-мя аргументами
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 */
	public Middle(String name, int salary) {
		super(name, Rang.Middle, salary);
	}
	/** 
	 * Конструктор с 1-ним аргументом
	 * @param  name -- имя сотрудника
	 */
	public Middle(String name) {
		this(name, Rang.Middle.getDefSalary());
	}
}
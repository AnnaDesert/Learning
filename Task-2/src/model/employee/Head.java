package model.employee;

import model.enums.Rang;
import model.employee.Employee;

/**
 * Класс сотрудник должности Head
 * @author Максим Ведеников
 */
public class Head extends Employee {
	/** 
	 * Конструктор с 2-мя аргументами
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 */
	public Head(String name, int salary) {
		super(name, Rang.Head, salary);
	}
	/** 
	 * Конструктор с 1-ним аргументом
	 * @param  name -- имя сотрудника
	 */
	public Head(String name) {
		this(name, Rang.Head.getDefSalary());
	}
}
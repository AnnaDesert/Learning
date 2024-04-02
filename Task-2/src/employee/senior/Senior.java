package employee.senior;

import rang.Rang;
import employee.Employee;

/**
 * Класс сотрудник должности Senior
 * @author Максим Ведеников
 */
public class Senior extends Employee {
	/** 
	 * Конструктор с 2-мя аргументами
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 */
	public Senior(String name, int salary) {
		super(name, Rang.Senior, salary);
	}
	/** 
	 * Конструктор с 1-ним аргументом
	 * @param  name -- имя сотрудника
	 */
	public Senior(String name) {
		this(name, Rang.Senior.getDefSalary());
	}
}
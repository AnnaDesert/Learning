package employee.junior;

import rang.Rang;
import employee.Employee;

/**
 * Класс сотрудник должности Junior
 * @author Максим Ведеников
 */
public class Junior extends Employee {
	/** 
	 * Конструктор с 2-мя аргументами
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 */
	public Junior(String name, int salary) {
		super(name, Rang.Junior, salary);
	}
	/** 
	 * Конструктор с 1-ним аргументом
	 * @param  name -- имя сотрудника
	 */
	public Junior(String name) {
		this(name, Rang.Junior.getDefSalary());
	}
}
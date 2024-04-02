package employee.employeefactory;

import rang.Rang;
import employee.Employee;
import employee.analyst.Analyst;
import employee.head.Head;
import employee.middle.Middle;
import employee.junior.Junior;
import employee.senior.Senior;

/**
 * Класс фабрика сотрудников
 * @author Максим Ведеников
 */
public class EmployeeFactory {
	/**
	 * создает сотрудника
	 * @param  rang -- должность сотрудника
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 * @return возвращает сотрудника
	 */
	public Employee createEmployee(Rang rang, String name, int salary) {
		Employee employee = null;

		switch(rang) {
			case Head:
				employee = new Head(name, salary);
				break;
			case Senior:
				employee = new Senior(name, salary);
				break;
			case Middle:
				employee = new Middle(name, salary);
				break;
			case Junior:
				employee = new Junior(name, salary);
				break;
			case Analyst:
				employee = new Analyst(name, salary);
				break;
		}

		return employee;
	}
	/**
	 * создает сотрудника
	 * @param  rang -- должность сотрудника
	 * @param  name -- имя сотрудника
	 * @return возвращает сотрудника
	 */
	public Employee createEmployee(Rang rang, String name) {
		Employee employee = null;

		switch(rang) {
			case Head:
				employee = new Head(name);
				break;
			case Senior:
				employee = new Senior(name);
				break;
			case Middle:
				employee = new Middle(name);
				break;
			case Junior:
				employee = new Junior(name);
				break;
			case Analyst:
				employee = new Analyst(name);
				break;
		}

		return employee;
	}
}
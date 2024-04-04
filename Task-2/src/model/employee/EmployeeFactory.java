package model.employee;

import model.enums.Rang;
import model.employee.Head;
import model.employee.Senior;
import model.employee.Middle;
import model.employee.Junior;
import model.employee.Analyst;
import interfaces.iemployee.IEmployeeFactory;
import interfaces.iemployee.IEmployee;

/**
 * Класс фабрика сотрудников
 * @author Максим Ведеников
 */
public class EmployeeFactory implements IEmployeeFactory {
	/**
	 * создает сотрудника
	 * @param  rang -- должность сотрудника
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 * @return возвращает сотрудника
	 */
	public IEmployee createEmployee(Rang rang, String name, int salary) {
		IEmployee employee = null;

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
	public IEmployee createEmployee(Rang rang, String name) {
		IEmployee employee = null;

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
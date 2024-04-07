package model.employee;

import model.enums.Rang;
import interfaces.IEmployee;
import interfaces.AbstractFactory;

/**
 * Класс фабрика сотрудников
 * @author Максим Ведеников
 */
public class EmployeeFactory implements AbstractFactory {
	/**
	 * создает сотрудника
	 * @param  rang -- должность сотрудника
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 * @return возвращает сотрудника
	 */
	public IEmployee getEmployee(Rang rang, String name, int salary) {
		switch(rang) {
			case Head -> {return new Head(name, salary);}
			case Senior -> {return new Senior(name, salary);}
			case Middle -> {return new Middle(name, salary);}
			case Junior -> {return new Junior(name, salary);}
			case Analyst -> {return new Analyst(name, salary);}
		}
		return null;
	}
	public IEmployee getEmployee(Rang rang, String name) {
		switch(rang) {
			case Head -> {return new Head(name);}
			case Senior -> {return new Senior(name);}
			case Middle -> {return new Middle(name);}
			case Junior -> {return new Junior(name);}
			case Analyst -> {return new Analyst(name);}
		}
		return null;
	}
}
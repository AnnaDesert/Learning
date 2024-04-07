package model.employee;

import model.enums.Rang;
import interfaces.IEmployee;

/**
 * Класс сотрудник должности Analyst
 * @author Максим Ведеников
 */
public class Analyst extends Employee implements IEmployee {
	/** 
	 * Конструкторы
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 */
	public Analyst(String name, int salary) {
		super(name, Rang.Analyst, salary);
	}
	public Analyst(String name) {
		this(name, Rang.Analyst.getDefSalary());
	}
}
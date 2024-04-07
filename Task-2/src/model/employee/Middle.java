package model.employee;

import model.enums.Rang;
import interfaces.IEmployee;

/**
 * Класс сотрудник должности Middle
 * @author Максим Ведеников
 */
public class Middle extends Employee implements IEmployee {
	/** 
	 * Конструкторы
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 */
	public Middle(String name, int salary) {
		super(name, Rang.Middle, salary);
	}
	public Middle(String name) {
		this(name, Rang.Middle.getDefSalary());
	}
}
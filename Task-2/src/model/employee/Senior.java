package model.employee;

import model.enums.Rang;
import interfaces.IEmployee;

/**
 * Класс сотрудник должности Senior
 * @author Максим Ведеников
 */
public class Senior extends Employee implements IEmployee {
	/** 
	 * Конструкторы
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 */
	public Senior(String name, int salary) {
		super(name, Rang.Senior, salary);
	}
	public Senior(String name) {
		this(name, Rang.Senior.getDefSalary());
	}
}
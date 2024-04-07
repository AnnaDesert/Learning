package model.employee;

import model.enums.Rang;
import interfaces.IEmployee;

/**
 * Класс сотрудник должности Junior
 * @author Максим Ведеников
 */
public class Junior extends Employee implements IEmployee {
	/** 
	 * Конструкторы
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 */
	public Junior(String name, int salary) {
		super(name, Rang.Junior, salary);
	}
	public Junior(String name) {
		this(name, Rang.Junior.getDefSalary());
	}
}
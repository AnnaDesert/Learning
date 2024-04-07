package model.employee;

import model.enums.Rang;
import interfaces.IEmployee;

/**
 * Класс сотрудник должности Head
 * @author Максим Ведеников
 */
public class Head extends Employee implements IEmployee {
	/** 
	 * Конструкторы
	 * @param  name -- имя сотрудника
	 * @param  salary -- ЗП сотрудника
	 */
	public Head(String name, int salary) {
		super(name, Rang.Head, salary);
	}
	public Head(String name) {
		this(name, Rang.Head.getDefSalary());
	}
}
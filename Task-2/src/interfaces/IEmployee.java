package interfaces;

import model.enums.Rang;

/**
 * Интерфейс сотрудника
 * @author Максим Ведеников
 */
public interface IEmployee {
	Rang getRang();
	int getSalary();
	String getName();
}
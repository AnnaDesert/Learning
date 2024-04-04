package interfaces.iemployee;

import model.enums.Rang;

/**
 * Интерфейс фабрики сотрудников
 * @author Максим Ведеников
 */
public interface IEmployeeFactory {
	public IEmployee createEmployee(Rang rang, String name, int salary);
	public IEmployee createEmployee(Rang rang, String name);
}
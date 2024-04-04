package interfaces.iemployee;

import model.enums.Rang;

/**
 * Интерфейс сотрудника
 * @author Максим Ведеников
 */
public interface IEmployee {
	/** get-методы */
	public Rang getRang();
	public int getSalary();
	public String getName();

	/** set-методы */
	public void setRang(Rang r);
	public void setSalary(int salary);
	public void setName(String name);
}
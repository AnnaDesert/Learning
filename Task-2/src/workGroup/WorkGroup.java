package workgroup;

import java.util.ArrayList;
import java.util.List;

import employee.Employee;
import order.Order;

/**
 * Класс рабочая группа
 * @author Максим Ведеников
 */
public class WorkGroup {
	/** Имя группы */
	private String groupName;
	/** Список сотрудников группы */
	private List<Employee> empList = new ArrayList<>();
	/** Текущий заказ */
	private Order order = null;

	/** 
	 * Конструктор с 3-мя аргументами
	 * @param  empL -- список сотрудников
	 * @param  gName -- название рабочей группы
	 * @param  order -- заказ
	 */
	public WorkGroup(List<Employee> empL, String gName, Order order) {
		this(empL, gName);
		this.order = order;
	}
	/** 
	 * Конструктор с 2-мя аргументами
	 * @param  empL -- список сотрудников
	 * @param  gName -- название рабочей группы
	 */
	public WorkGroup(List<Employee> empL, String gName) {
		groupName = gName;
		for(Employee emp: empL) {
			empList.add(emp);
		}
	}
	/** Конструктор без аргументов */
	public WorkGroup() {};

	/** set-методы */
	public void setOrder(Order order) {this.order = order;}
	public void setGroupName(String groupName) {this.groupName = groupName;}
	public void setEmpList(List<Employee> empList) {this.empList = empList;}

	/** get-методы */
	public Order getOrder() {return order;}
	public String getGroupName() {return groupName;}
	public List<Employee> getEmpList() {return empList;}

	/** 
	 * Добовляет сотрудника в группу
	 * @param emp -- содрудник
	 */
	public void addEmployee(Employee emp) {empList.add(emp);}
	/** Удаляет у группы заказ */
	public void remOrder() {order = null;}
	/** Прверяет есть ли у группы заказ  */
	public boolean isBusyness() {return order == null;}

	/** Вывод */
	public String toString() {
		String str = "В группе \""+groupName+"\" состоят:\n";
		for(Employee emp: empList) {
			str += emp.getName()+"\n";
		}
		if(isBusyness()) {
			str += "На данный момент группа незанята";
		} else {
			str += "На данный момент группа занята проектом '"+order.getNameOrder()+"'";
		}

		return str;
	}
}
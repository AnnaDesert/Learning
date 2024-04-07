package workgroup;

import java.util.ArrayList;
import java.util.List;

import interfaces.IEmployee;
import interfaces.IOrder;

/**
 * Класс рабочая группа
 * @author Максим Ведеников
 */
public class WorkGroup {
	/** Имя группы */
	private String groupName;
	/** Список сотрудников группы */
	private List<IEmployee> empList = new ArrayList<>();
	/** Текущий заказ */
	private IOrder order = null;

	/** 
	 * Конструкторы
	 * @param  empL -- список сотрудников
	 * @param  gName -- название рабочей группы
	 * @param  order -- заказ
	 */
	public WorkGroup(List<IEmployee> empL, String gName, IOrder order) {
		this(empL, gName);
		this.order = order;
	}
	public WorkGroup(List<IEmployee> empL, String gName) {
		groupName = gName;
		for(IEmployee emp: empL) {
			empList.add(emp);
		}
	}
	public WorkGroup() {};

	/** set-методы */
	public void setOrder(IOrder order) {this.order = order;}
	public void setGroupName(String groupName) {this.groupName = groupName;}
	public void setEmpList(List<IEmployee> empList) {this.empList = empList;}

	/** get-методы */
	public IOrder getOrder() {return order;}
	public String getGroupName() {return groupName;}
	public List<IEmployee> getEmpList() {return empList;}

	/** 
	 * Добовляет сотрудника в группу
	 * @param emp -- содрудник
	 */
	public void addEmployee(IEmployee emp) {empList.add(emp);}
	/** Удаляет у группы заказ */
	public void remOrder() {order = null;}
	/** Прверяет есть ли у группы заказ  */
	public boolean isBusyness() {return order == null;}

	/** Вывод */
	public String toString() {
		String str = "В группе \""+groupName+"\" состоят:\n";
		for(IEmployee emp: empList) {
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
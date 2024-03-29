package workGroup;

import java.util.*;
import employee.*;
import order.*;

// класс рабочей группы
public class WorkGroup {
	// имя группы
	private String groupName;
	// список сотрудников группы
	private ArrayList<Employee> empList = new ArrayList<Employee>();
	// текущий заказ
	private Order groupOrder = null;
	// занята ли группа
	private boolean busyness = false;

	public WorkGroup(ArrayList<Employee> empL, String gName) {
		groupName = gName;
		for(Employee emp: empL) {
			empList.add(emp);
		}
	}

	public void addEmployee(Employee emp) {
		empList.add(emp);
	}
	public void setOrder(Order ord) {
		groupOrder = ord;
		busyness = true;
	}
	public void remOrder(Order ord) {
		groupOrder = null;
		busyness = false;
	}

	public ArrayList<Employee> getEmpList() {
		return empList;
	}
	public String getGroupName() {
		return groupName;
	}
	public Order getOrder() {
		return groupOrder;
	}

	public boolean isBusyness() {
		return busyness;
	}

	public String toString() {
		String str = "В группе \""+groupName+"\" состоят:\n";
		for(Employee emp: empList) {
			str += emp.getName()+"\n";
		}
		if(busyness) {
			str += "На данный момент группа занята";
		} else {
			str += "На данный момент группа незанята";
		}

		return str;
	}
}
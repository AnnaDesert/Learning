import java.util.*;
import employee.*;
import order.*;
import workGroup.*;
import rang.*;
import tSoftware.*;

class Task2 {
	// метод считает суммарную ЗП в группе
	static int totalSalaryEmployeesInGroup(WorkGroup wg) {
		int total = 0;
		for(Employee emp: wg.getEmpList()) {
				total += emp.getSalary();
		}
		return total;
	}
	// метод считает суммарную ЗП в фирме
	static int totalSalaryEmployees(ArrayList<WorkGroup> wgList) {
		int total = 0;
		for(WorkGroup wg: wgList) {
			total += totalSalaryEmployeesInGroup(wg);
		}
		return total;
	}
	
	public static void main(String[] args) {
		// набор сотрудников №1
		Employee emp11 = new Employee("Emp11", Rang.Head, 200000);
		Employee emp12 = new Employee("Emp12", Rang.Senior, 180000);
		Employee emp13 = new Employee("Emp13", Rang.Middle, 150000);
		Employee emp14 = new Employee("Emp14", Rang.Junior, 120000);
		Employee emp15 = new Employee("Emp15", Rang.Junior, 120000);
		Employee emp16 = new Employee("Emp16", Rang.Analyst, 90000);
		Employee emp17 = new Employee("Emp17", Rang.Analyst, 90000);

		// набор сотрудников №2
		Employee emp21 = new Employee("Emp21", Rang.Head, 200000);
		Employee emp22 = new Employee("Emp22", Rang.Senior, 180000);
		Employee emp23 = new Employee("Emp23", Rang.Middle, 150000);
		Employee emp24 = new Employee("Emp24", Rang.Junior, 120000);
		Employee emp25 = new Employee("Emp25", Rang.Junior, 120000);
		Employee emp26 = new Employee("Emp26", Rang.Analyst, 90000);
		Employee emp27 = new Employee("Emp27", Rang.Analyst, 90000);
		
		// набор сотрудников №3
		Employee emp31 = new Employee("Emp31", Rang.Head, 200000);
		Employee emp32 = new Employee("Emp32", Rang.Senior, 180000);
		Employee emp33 = new Employee("Emp33", Rang.Middle, 150000);
		Employee emp34 = new Employee("Emp34", Rang.Junior, 120000);
		Employee emp35 = new Employee("Emp35", Rang.Junior, 120000);
		Employee emp36 = new Employee("Emp36", Rang.Analyst, 90000);
		Employee emp37 = new Employee("Emp37", Rang.Analyst, 90000);

		// формируем заказы
		Order ord1 = new Order("Ord1", tSoftware.Mobile, 100000, 30);
		Order ord2 = new Order("Ord2", tSoftware.Desktop, 120000, 50);

		ArrayList<Employee> empList1 = new ArrayList<Employee>();
		empList1.add(emp11);
		empList1.add(emp12);
		empList1.add(emp13);
		empList1.add(emp14);
		empList1.add(emp15);
		empList1.add(emp16);
		empList1.add(emp17);

		ArrayList<Employee> empList2 = new ArrayList<Employee>();
		empList2.add(emp21);
		empList2.add(emp22);
		empList2.add(emp23);
		empList2.add(emp24);
		empList2.add(emp25);
		empList2.add(emp26);
		empList2.add(emp27);

		ArrayList<Employee> empList3 = new ArrayList<Employee>();
		empList3.add(emp31);
		empList3.add(emp32);
		empList3.add(emp33);
		empList3.add(emp34);
		empList3.add(emp35);
		empList3.add(emp36);
		empList3.add(emp37);

		// формируем группы
		WorkGroup wg1 = new WorkGroup(empList1, "wg1");
		WorkGroup wg2 = new WorkGroup(empList1, "wg2");
		WorkGroup wg3 = new WorkGroup(empList1, "wg3");

		// даем заказы
		wg1.setOrder(ord1);
		wg2.setOrder(ord2);

		ArrayList<WorkGroup> wgList = new ArrayList<WorkGroup>();
		wgList.add(wg1);
		wgList.add(wg2);
		wgList.add(wg3);

		System.out.println("Общая ЗП струдников: "+totalSalaryEmployees(wgList));
	}
}
import java.util.ArrayList;
import java.util.List;

import employee.Employee;
import order.Order;
import workgroup.WorkGroup;
import rang.Rang;
import typesoftware.TypeSoftware;
import employee.employeefactory.EmployeeFactory;
import order.orderfactory.OrderFactory;

/**
 * Класс для задания №2
 * Фирма по производству ПО
 * @author Максим Ведеников
 */
class Task2 {
	public static void main(String[] args) {
		/** Набор сотрудников №1 */
		EmployeeFactory employeeFactory = new EmployeeFactory();
		Employee hEmp11 = employeeFactory.createEmployee(Rang.Head,    "hEmp11");
		Employee sEmp12 = employeeFactory.createEmployee(Rang.Senior,  "sEmp12");
		Employee mEmp13 = employeeFactory.createEmployee(Rang.Middle,  "mEmp13");
		Employee jEmp14 = employeeFactory.createEmployee(Rang.Junior,  "jEmp14");
		Employee jEmp15 = employeeFactory.createEmployee(Rang.Junior,  "jEmp15");
		Employee aEmp16 = employeeFactory.createEmployee(Rang.Analyst, "aEmp16", 200000);
		Employee aEmp17 = employeeFactory.createEmployee(Rang.Analyst, "aEmp17");

		/** Набор сотрудников №2 */
		Employee hEmp21 = employeeFactory.createEmployee(Rang.Head,    "hEmp21");
		Employee sEmp22 = employeeFactory.createEmployee(Rang.Senior,  "sEmp22");
		Employee mEmp23 = employeeFactory.createEmployee(Rang.Middle,  "mEmp23");
		Employee jEmp24 = employeeFactory.createEmployee(Rang.Junior,  "jEmp24");
		Employee jEmp25 = employeeFactory.createEmployee(Rang.Junior,  "jEmp25");
		Employee aEmp26 = employeeFactory.createEmployee(Rang.Analyst, "aEmp26");
		Employee aEmp27 = employeeFactory.createEmployee(Rang.Analyst, "aEmp27");

		/** Набор сотрудников №3 */
		Employee hEmp31 = employeeFactory.createEmployee(Rang.Head,    "hEmp31");
		Employee sEmp32 = employeeFactory.createEmployee(Rang.Senior,  "sEmp32");
		Employee mEmp33 = employeeFactory.createEmployee(Rang.Middle,  "mEmp33");
		Employee jEmp34 = employeeFactory.createEmployee(Rang.Junior,  "jEmp34");
		Employee jEmp35 = employeeFactory.createEmployee(Rang.Junior,  "jEmp35");
		Employee aEmp36 = employeeFactory.createEmployee(Rang.Analyst, "aEmp36");
		Employee aEmp37 = employeeFactory.createEmployee(Rang.Analyst, "aEmp37");

		/** Формируем заказы */
		OrderFactory orderFactory = new OrderFactory();
		Order mOrd1 = orderFactory.createOrder(TypeSoftware.Mobile,  "mOrd1");
		Order sOrd2 = orderFactory.createOrder(TypeSoftware.Service, "sOrd2");
		Order dOrd3 = orderFactory.createOrder(TypeSoftware.Desktop, "dOrd3", 120000, 180);
		Order wOrd4 = orderFactory.createOrder(TypeSoftware.Website, "wOrd4", 50000);

		List<Employee> empList1 = new ArrayList<>();
		empList1.add(hEmp11);
		empList1.add(sEmp12);
		empList1.add(mEmp13);
		empList1.add(jEmp14);
		empList1.add(jEmp15);
		empList1.add(aEmp16);
		empList1.add(aEmp17);

		List<Employee> empList2 = new ArrayList<>();
		empList2.add(hEmp21);
		empList2.add(sEmp22);
		empList2.add(mEmp23);
		empList2.add(jEmp24);
		empList2.add(jEmp25);
		empList2.add(aEmp26);
		empList2.add(aEmp27);

		List<Employee> empList3 = new ArrayList<>();
		empList3.add(hEmp31);
		empList3.add(sEmp32);
		empList3.add(mEmp33);
		empList3.add(jEmp34);
		empList3.add(jEmp35);
		empList3.add(aEmp36);
		empList3.add(aEmp37);

		/** Формируем группы */
		WorkGroup wg1 = new WorkGroup(empList1, "wg1");
		WorkGroup wg2 = new WorkGroup(empList1, "wg2", mOrd1);
		WorkGroup wg3 = new WorkGroup(empList1, "wg3");

		/** Даем заказ */
		wg3.setOrder(dOrd3);

		List<WorkGroup> wgList = new ArrayList<>();
		wgList.add(wg1);
		wgList.add(wg2);
		wgList.add(wg3);

		System.out.println("Общая ЗП струдников: "+totalSalaryEmployees(wgList));
	}
	
	/** 
	 * Метод считает суммарноую ЗП в группе
	 * @param  wg -- рабочая группа
	 * @return -- возвращает суммарную ЗП в рабочей группе wg
	 */
	static int totalSalaryEmployeesInGroup(WorkGroup wg) {
		int total = 0;
		for(Employee emp: wg.getEmpList()) {
				total += emp.getSalary();
		}
		return total;
	}

	/** 
	 * Метод считает суммарноую ЗП в фирме
	 * @param  wgList -- список, содержащий рабочие группы всей фирмы
	 * @return -- возвращает суммарную ЗП в фирме
	 */
	static int totalSalaryEmployees(List<WorkGroup> wgList) {
		int total = 0;
		for(WorkGroup wg: wgList) {
			total += totalSalaryEmployeesInGroup(wg);
		}
		return total;
	}
}
import java.util.ArrayList;
import java.util.List;

import interfaces.iemployee.IEmployee;
import interfaces.iorder.IOrder;
import workgroup.WorkGroup;
import model.enums.Rang;
import model.enums.TypeSoftware;
import interfaces.iemployee.IEmployeeFactory;
import interfaces.iorder.IOrderFactory;
import model.employee.EmployeeFactory;
import model.order.OrderFactory;

/**
 * Класс для задания №2
 * Фирма по производству ПО
 * @author Максим Ведеников
 */
class Task2 {
	public static void main(String[] args) {
		/** Набор сотрудников №1 */
		IEmployeeFactory employeeFactory = new EmployeeFactory();
		IEmployee hEmp11 = employeeFactory.createEmployee(Rang.Head,    "hEmp11");
		IEmployee sEmp12 = employeeFactory.createEmployee(Rang.Senior,  "sEmp12");
		IEmployee mEmp13 = employeeFactory.createEmployee(Rang.Middle,  "mEmp13");
		IEmployee jEmp14 = employeeFactory.createEmployee(Rang.Junior,  "jEmp14");
		IEmployee jEmp15 = employeeFactory.createEmployee(Rang.Junior,  "jEmp15");
		IEmployee aEmp16 = employeeFactory.createEmployee(Rang.Analyst, "aEmp16", 200000);
		IEmployee aEmp17 = employeeFactory.createEmployee(Rang.Analyst, "aEmp17");

		/** Набор сотрудников №2 */
		IEmployee hEmp21 = employeeFactory.createEmployee(Rang.Head,    "hEmp21");
		IEmployee sEmp22 = employeeFactory.createEmployee(Rang.Senior,  "sEmp22");
		IEmployee mEmp23 = employeeFactory.createEmployee(Rang.Middle,  "mEmp23");
		IEmployee jEmp24 = employeeFactory.createEmployee(Rang.Junior,  "jEmp24");
		IEmployee jEmp25 = employeeFactory.createEmployee(Rang.Junior,  "jEmp25");
		IEmployee aEmp26 = employeeFactory.createEmployee(Rang.Analyst, "aEmp26");
		IEmployee aEmp27 = employeeFactory.createEmployee(Rang.Analyst, "aEmp27");

		/** Набор сотрудников №3 */
		IEmployee hEmp31 = employeeFactory.createEmployee(Rang.Head,    "hEmp31");
		IEmployee sEmp32 = employeeFactory.createEmployee(Rang.Senior,  "sEmp32");
		IEmployee mEmp33 = employeeFactory.createEmployee(Rang.Middle,  "mEmp33");
		IEmployee jEmp34 = employeeFactory.createEmployee(Rang.Junior,  "jEmp34");
		IEmployee jEmp35 = employeeFactory.createEmployee(Rang.Junior,  "jEmp35");
		IEmployee aEmp36 = employeeFactory.createEmployee(Rang.Analyst, "aEmp36");
		IEmployee aEmp37 = employeeFactory.createEmployee(Rang.Analyst, "aEmp37");

		/** Формируем заказы */
		IOrderFactory orderFactory = new OrderFactory();
		IOrder mOrd1 = orderFactory.createOrder(TypeSoftware.Mobile,  "mOrd1");
		IOrder sOrd2 = orderFactory.createOrder(TypeSoftware.Service, "sOrd2");
		IOrder dOrd3 = orderFactory.createOrder(TypeSoftware.Desktop, "dOrd3", 120000, 180);
		IOrder wOrd4 = orderFactory.createOrder(TypeSoftware.Website, "wOrd4", 50000);

		List<IEmployee> empList1 = new ArrayList<>();
		empList1.add(hEmp11);
		empList1.add(sEmp12);
		empList1.add(mEmp13);
		empList1.add(jEmp14);
		empList1.add(jEmp15);
		empList1.add(aEmp16);
		empList1.add(aEmp17);

		List<IEmployee> empList2 = new ArrayList<>();
		empList2.add(hEmp21);
		empList2.add(sEmp22);
		empList2.add(mEmp23);
		empList2.add(jEmp24);
		empList2.add(jEmp25);
		empList2.add(aEmp26);
		empList2.add(aEmp27);

		List<IEmployee> empList3 = new ArrayList<>();
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
		for(IEmployee emp: wg.getEmpList()) {
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
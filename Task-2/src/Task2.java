import java.util.ArrayList;
import java.util.List;

import interfaces.IEmployee;
import interfaces.IOrder;
import interfaces.AbstractFactory;
import workgroup.WorkGroup;
import model.FactoryProducer;
import model.enums.Rang;
import model.enums.TypeSoftware;
import model.enums.TypeFactory;

/**
 * Класс для задания №2
 * Фирма по производству ПО
 * @author Максим Ведеников
 */
class Task2 {
	public static void main(String[] args) {
		AbstractFactory employeeFactory = FactoryProducer.getFactory(TypeFactory.EMPLOYEE);
		AbstractFactory orderFactory = FactoryProducer.getFactory(TypeFactory.ORDER);

		/** Набор сотрудников №1 */
		IEmployee hEmp11 = employeeFactory.getEmployee(Rang.Head,    "hEmp11");
		IEmployee sEmp12 = employeeFactory.getEmployee(Rang.Senior,  "sEmp12");
		IEmployee mEmp13 = employeeFactory.getEmployee(Rang.Middle,  "mEmp13");
		IEmployee jEmp14 = employeeFactory.getEmployee(Rang.Junior,  "jEmp14");
		IEmployee jEmp15 = employeeFactory.getEmployee(Rang.Junior,  "jEmp15");
		IEmployee aEmp16 = employeeFactory.getEmployee(Rang.Analyst, "aEmp16", 200000);
		IEmployee aEmp17 = employeeFactory.getEmployee(Rang.Analyst, "aEmp17");

		/** Набор сотрудников №2 */
		IEmployee hEmp21 = employeeFactory.getEmployee(Rang.Head,    "hEmp21");
		IEmployee sEmp22 = employeeFactory.getEmployee(Rang.Senior,  "sEmp22");
		IEmployee mEmp23 = employeeFactory.getEmployee(Rang.Middle,  "mEmp23");
		IEmployee jEmp24 = employeeFactory.getEmployee(Rang.Junior,  "jEmp24");
		IEmployee jEmp25 = employeeFactory.getEmployee(Rang.Junior,  "jEmp25");
		IEmployee aEmp26 = employeeFactory.getEmployee(Rang.Analyst, "aEmp26");
		IEmployee aEmp27 = employeeFactory.getEmployee(Rang.Analyst, "aEmp27");

		/** Набор сотрудников №3 */
		IEmployee hEmp31 = employeeFactory.getEmployee(Rang.Head,    "hEmp31");
		IEmployee sEmp32 = employeeFactory.getEmployee(Rang.Senior,  "sEmp32");
		IEmployee mEmp33 = employeeFactory.getEmployee(Rang.Middle,  "mEmp33");
		IEmployee jEmp34 = employeeFactory.getEmployee(Rang.Junior,  "jEmp34");
		IEmployee jEmp35 = employeeFactory.getEmployee(Rang.Junior,  "jEmp35");
		IEmployee aEmp36 = employeeFactory.getEmployee(Rang.Analyst, "aEmp36");
		IEmployee aEmp37 = employeeFactory.getEmployee(Rang.Analyst, "aEmp37");

		/** Формируем заказы */
		IOrder mOrd1 = orderFactory.getOrder(TypeSoftware.Mobile,  "mOrd1");
		IOrder sOrd2 = orderFactory.getOrder(TypeSoftware.Service, "sOrd2");
		IOrder dOrd3 = orderFactory.getOrder(TypeSoftware.Desktop, "dOrd3", 120000, 180);
		IOrder wOrd4 = orderFactory.getOrder(TypeSoftware.Website, "wOrd4", 50000);

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
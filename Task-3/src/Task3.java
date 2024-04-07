import models.product.Product;
import interfaces.IProductPart;
import interfaces.IAssemblyLine;
import enums.ECarPart;

import assemblyline.AssemblyLine;
import models.product.ProductFactory;
import enums.EProductType;

/**
 * Класс задания №3
 * @author Максим Ведеников
 */
public class Task3 {
	public static void main(String[] args) {

		/** Создаем линию производства и факторию продуктов */
		AssemblyLine assemblyLine = new AssemblyLine();
		ProductFactory productFactory = new ProductFactory();

		/** Создаем и собираем продукт типа CAR */
		Product productCar = productFactory.createProduct(EProductType.CAR, 1, 100000, 120);
		assemblyLine.assembleProduct(productCar);

		/** Создаем и собираем продукт типа TANK */
		Product productTank = productFactory.createProduct(EProductType.TANK, 2, 100000, 120);
		assemblyLine.assembleProduct(productTank);

		/** Создаем и собираем продукт типа GLASSES */
		Product productGlasses = productFactory.createProduct(EProductType.GLASSES, 3, 100000, 120);
		assemblyLine.assembleProduct(productGlasses);

		/** Создаем и собираем продукт типа PEN */
		Product productPen = productFactory.createProduct(EProductType.PEN, 4, 100000, 120);
		assemblyLine.assembleProduct(productPen);

		/** Создаем и собираем продукт типа LAPTOP */
		Product productLaptop = productFactory.createProduct(EProductType.LAPTOP, 5, 100000, 120);
		assemblyLine.assembleProduct(productLaptop);

		/** Вывод */
		System.out.println(productCar+"\n");
		System.out.println(productTank+"\n");
		System.out.println(productGlasses+"\n");
		System.out.println(productPen+"\n");
		System.out.println(productLaptop+"\n");
	}
}
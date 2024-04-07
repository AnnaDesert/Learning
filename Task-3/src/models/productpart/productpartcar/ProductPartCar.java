package models.productpart.productpartcar;

import interfaces.IProductPart;
import enums.ECarPart;

/**
 * Класс частей продукта типа CAR
 * @author Максим Ведеников
 */
public class ProductPartCar implements IProductPart {
	private ECarPart carPart;
	public ProductPartCar(ECarPart carPart) {
		this.carPart = carPart;
	}

	public IProductPart buildProductPart() {
		return this;
	}

	public String toString() {
		return carPart.getDesc();
	}
}
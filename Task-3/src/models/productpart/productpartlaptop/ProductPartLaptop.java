package models.productpart.productpartlaptop;

import interfaces.IProductPart;
import enums.ELaptopPart;

/**
 * Класс частей продукта типа LAPTOP
 * @author Максим Ведеников
 */
public class ProductPartLaptop implements IProductPart {
	private ELaptopPart laptopPart;
	public ProductPartLaptop(ELaptopPart laptopPart) {
		this.laptopPart = laptopPart;
	}

	public IProductPart buildProductPart() {
		return this;
	}

	public String toString() {
		return laptopPart.getDesc();
	}
}
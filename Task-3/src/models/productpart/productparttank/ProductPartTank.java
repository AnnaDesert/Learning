package models.productpart.productparttank;

import interfaces.IProductPart;
import enums.ETankPart;

/**
 * Класс частей продукта типа TANK
 * @author Максим Ведеников
 */
public class ProductPartTank implements IProductPart {
	private ETankPart tankPart;
	public ProductPartTank(ETankPart tankPart) {
		this.tankPart = tankPart;
	}

	public IProductPart buildProductPart() {
		return this;
	}

	public String toString() {
		return tankPart.getDesc();
	}
}
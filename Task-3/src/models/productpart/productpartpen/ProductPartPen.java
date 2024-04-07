package models.productpart.productpartpen;

import interfaces.IProductPart;
import enums.EPenPart;

/**
 * Класс частей продукта типа PEN
 * @author Максим Ведеников
 */
public class ProductPartPen implements IProductPart {
	private EPenPart penPart;
	public ProductPartPen(EPenPart penPart) {
		this.penPart = penPart;
	}

	public IProductPart buildProductPart() {
		return this;
	}

	public String toString() {
		return penPart.getDesc();
	}
}
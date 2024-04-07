package models.productpart.productpartglasses;

import interfaces.IProductPart;
import enums.EGlassesPart;

/**
 * Класс частей продукта типа GLASSES
 * @author Максим Ведеников
 */
public class ProductPartGlasses implements IProductPart {
	private EGlassesPart glassesPart;
	public ProductPartGlasses(EGlassesPart glassesPart) {
		this.glassesPart = glassesPart;
	}

	public IProductPart buildProductPart() {
		return this;
	}

	public String toString() {
		return glassesPart.getDesc();
	}
}
package interfaces;

import enums.EProductType;

/**
 * Интерфейс продукта
 * @author Максим Ведеников
 */
public interface IProduct {
	public void installFirstPart(IProductPart productPart);
	public void installSecondPart(IProductPart productPart);
	public void installThridPart(IProductPart productPart);

	public EProductType getProductType();
}
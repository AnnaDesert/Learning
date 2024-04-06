package models.productpart.productparttank;

import enums.ETankPart;

/**
 * Класс части типа BODY, продукта типа TANK
 * @author Максим Ведеников
 */
public class TankBody extends ProductPartTank {
	public TankBody() {
		super(ETankPart.BODY);
	}
}
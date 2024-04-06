package assemblyline;

import models.product.Product;
import interfaces.IProductPart;
import interfaces.IAssemblyLine;
import interfaces.IProduct;

import models.productpart.productpartcar.CarBody;
import models.productpart.productpartcar.CarChassis;
import models.productpart.productpartcar.CarEngiene;

import models.productpart.productpartpen.PenBody;
import models.productpart.productpartpen.PenRod;
import models.productpart.productpartpen.PenSpring;

import models.productpart.productpartglasses.GlassesBody;
import models.productpart.productpartglasses.GlassesLenses;
import models.productpart.productpartglasses.GlassesShackles;

import models.productpart.productpartlaptop.LaptopBody;
import models.productpart.productpartlaptop.LaptopMonitor;
import models.productpart.productpartlaptop.LaptopMotherboard;

import models.productpart.productparttank.TankBody;
import models.productpart.productparttank.TankTower;
import models.productpart.productparttank.TankEngiene;

/**
 * Класс линии производства
 * @author Максим Ведеников
 */
public class AssemblyLine implements IAssemblyLine {
	public IProduct assembleProduct(IProduct product) {
		switch(product.getProductType()) {
			case CAR -> {
				product.installFirstPart(new CarBody().buildProductPart());
				product.installSecondPart(new CarChassis().buildProductPart());
				product.installThridPart(new CarEngiene().buildProductPart());
			}
			case PEN -> {
				product.installFirstPart(new PenBody().buildProductPart());
				product.installSecondPart(new PenRod().buildProductPart());
				product.installThridPart(new PenSpring().buildProductPart());
			}
			case TANK -> {
				product.installFirstPart(new TankBody().buildProductPart());
				product.installSecondPart(new TankTower().buildProductPart());
				product.installThridPart(new TankEngiene().buildProductPart());
			}
			case GLASSES -> {
				product.installFirstPart(new GlassesBody().buildProductPart());
				product.installSecondPart(new GlassesLenses().buildProductPart());
				product.installThridPart(new GlassesShackles().buildProductPart());
			}
			case LAPTOP -> {
				product.installFirstPart(new LaptopBody().buildProductPart());
				product.installSecondPart(new LaptopMonitor().buildProductPart());
				product.installThridPart(new LaptopMotherboard().buildProductPart());
			}
		}

		return product;
	}
}
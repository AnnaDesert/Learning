package models.product;

import java.util.List;
import java.util.ArrayList;

import interfaces.IProduct;
import interfaces.IProductPart;
import interfaces.IAssemblyLine;
import enums.EProductType;

/**
 * Класс продукта
 * @author Максим Ведеников
 */
public class Product implements IProduct {
	/** поле id продука */
	private long id;
	/** поле цены продука */
	private int price;
	/** поле время на производства продука */
	private int dueDate;
	/** поле типа продука */
	private EProductType productType;
	/** список частей продука */
	private List<IProductPart> listProductPart = new ArrayList<>();

	/**
	 * Конструктор с 4-мя агрументами
	 * @param  productType -- тип продукта
	 * @param  id -- id продукта
	 * @param  price -- цена продукта
	 * @param  dueDate --  время на производство продукта
	 */
	public Product(EProductType productType, long id, int price, int dueDate) {
		this.productType = productType;
		this.id = id;
		this.price = price;
		this.dueDate = dueDate;
	}

	//** Переопределяем методы интерфеса IProduct */
	public void installFirstPart(IProductPart productPart) {
		listProductPart.add(productPart);
	}
	public void installSecondPart(IProductPart productPart) {
		listProductPart.add(productPart);
	}
	public void installThridPart(IProductPart productPart) {
		listProductPart.add(productPart);
	}

	/** get-медоты */
	public long getId() {return id;}
	public int getPrice() {return price;}
	public int getDueDate() {return dueDate;}
	public EProductType getProductType() {return productType;}
	public List<IProductPart> getListProductPart() {return listProductPart;}

	/** set-медоты */
	public void setId() {this.id = id;}
	public void setPrice() {this.price = price;}
	public void setDueDate() {this.dueDate = dueDate;}
	public void setProductType() {this.productType = productType;}
	public void setListProductPart() {this.listProductPart = listProductPart;}

	/** Вывод */
	public String toString() {
		String str = " ";
		for(IProductPart productPart : listProductPart) {
			str += productPart+" ";
		}
		return "id = "+id+"\nprice = "+price+"\ndueDate = "+dueDate+"\nproductType = "+productType.getDesc()+
		"\nlistProductPart: ["+str+"]";
	}
}
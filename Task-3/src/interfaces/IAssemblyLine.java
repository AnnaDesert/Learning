package interfaces;

/**
 * Интерфейс сборочный конвейер
 * @author Максим Ведеников
 */
public interface IAssemblyLine {
	public IProduct assembleProduct(IProduct product);
}
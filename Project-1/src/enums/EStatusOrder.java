package enums;

/**
 * Перечисление статусов заказа
 * @author Максим Ведеников
 */
public enum EStatusOrder {
    ATWORK("В работе"),
    ONHOLD("В ожидании"),
    COMPLETED("Завершен"),
    CANCELLED("Отменен");

    /** Русское описание */
    private String ruDesc;

    EStatusOrder(String desc) {ruDesc = desc;}
    public String getDesc() {return ruDesc;}
}
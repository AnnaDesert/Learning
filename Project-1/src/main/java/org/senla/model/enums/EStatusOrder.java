package org.senla.model.enums;

/**
 * Перечисление статусов заказа
 * @author Максим Ведеников
 */
public enum EStatusOrder {
    IN_PROCESS("В работе"),
    WAITING("В ожидании"),
    SUCCESS("Завершен"),
    CANCELLED("Отменен");

    /** Русское описание */
    private String ruDesc;

    EStatusOrder(String desc) {ruDesc = desc;}
    public String getDesc() {return ruDesc;}
}
package ru.mirea.inbo_05_19.Kuznetsov;

public interface OrdersManager {
    int itemsQuantity(String itemName);

    int itemsQuantity(Item itemName);

    Order[] getOrders();

    int ordersCostSummary();

    int ordersQuantity();

    void remove(Order order);
}
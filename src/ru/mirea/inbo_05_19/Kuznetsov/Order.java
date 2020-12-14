package ru.mirea.inbo_05_19.Kuznetsov;

public interface Order {
    boolean add(Item menuItem);

    String[] itemNames();

    int itemsQuantity();

    int itemsQuantity(String itemName);

    int itemsQuantity(Item itemName);

    Item[] getItems();

    boolean remove(String itemName);

    boolean remove(Item itemName);

    int removeAll(String itemName);

    int removeAll(Item itemName);

    Item[] sortedItemsByCostDesc();

    int costTotal();

    Customer getCustomer();

    void setCustomer(Customer customer);
}
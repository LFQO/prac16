package ru.mirea.inbo_05_19.Kuznetsov;

import java.util.*;

public class RestaurantOrder implements Order {
    int size = 0;
    Item[] items = new Item[0];
    Customer customer;

    private boolean checkName(String[] Items, String item) {
        for (String Item : Items) {
            if (Item.equals(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkName(Item[] Items, Item item) {
        for (Item Item : Items) {
            if (Item.getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Item Item) {
        Item[] newArray = Arrays.copyOf(items, items.length + 1);
        newArray[items.length] = Item;
        items = newArray;
        size++;
        return true;
    }

    @Override
    public String[] itemNames() {
        String[] itemNames = new String[0];
        for (Item item : items) {
            if (!checkName(itemNames, item.getName())) {
                String[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = item.getName();
                itemNames = newArray;
            }
        }
        return itemNames;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int itemsQuantity(Item itemName) {
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(itemName.getName())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Item[] getItems() {
        Item[] itemNames = new Item[0];
        for (Item item : items) {
            if (!checkName(itemNames, item)) {
                Item[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = item;
                itemNames = newArray;
            }
        }
        return itemNames;
    }

    @Override
    public boolean remove(String itemName) {
        if (itemsQuantity(itemName) == 0) {
            return false;
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(itemName)) {
                if (items.length - 1 - i >= 0) {
                    System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
                }
                items = Arrays.copyOf(items, items.length - 1);
                break;
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(Item itemName) {
        if (itemsQuantity(itemName) == 0) {
            return false;
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(itemName.getName())) {
                if (items.length - 1 - i >= 0) {
                    System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
                }
                items = Arrays.copyOf(items, items.length - 1);
                break;
            }
        }
        size--;
        return true;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        while (itemsQuantity(itemName) != 0) {
            for (int i = 0; i < items.length; i++) {
                if (items[i].getName().equals(itemName)) {
                    if (items.length - 1 - i >= 0) {
                        System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
                    }
                    items = Arrays.copyOf(items, items.length - 1);
                    size--;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    @Override
    public int removeAll(Item itemName) {
        int count = 0;
        while (itemsQuantity(itemName) != 0) {
            for (int i = 0; i < items.length; i++) {
                if (items[i].getName().equals(itemName.getName())) {
                    if (items.length - 1 - i >= 0) {
                        System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
                    }
                    items = Arrays.copyOf(items, items.length - 1);
                    count++;
                    size--;
                    break;
                }
            }
        }
        return count;
    }

    @Override
    public Item[] sortedItemsByCostDesc() {
        Item[] Items = getItems();
        for (int i = 0; i < Items.length; i++) {
            for (int j = i; j < Items.length; j++) {
                if (Items[i].getCost() < Items[j].getCost()) {
                    Item tmp;
                    tmp = Items[i];
                    Items[i] = Items[j];
                    Items[j] = tmp;
                }
            }
        }
        return Items;
    }

    @Override
    public int costTotal() {
        Item[] Items = getItems();
        int cost = 0;
        for (Item Item : Items) {
            cost += Item.getCost() * itemsQuantity(Item);
        }
        return cost;
    }


    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
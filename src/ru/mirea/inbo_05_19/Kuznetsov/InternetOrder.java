package ru.mirea.inbo_05_19.Kuznetsov;

import java.util.*;

public class InternetOrder implements Order {
    private int size;
    private ListNode head;
    private ListNode tail;
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

    InternetOrder() {
        size = 0;
        this.head = new ListNode(null, null, null);
        this.tail = new ListNode(null, null, null);
        this.head.setNext(this.tail);
        this.head.setPrev(this.tail);
        this.tail.setNext(head);
        this.tail.setPrev(head);
    }

    InternetOrder(Order order) {
        this();
        Item[] Items = order.getItems();
        for (Item item : Items) {
            for (int i = 0; i < order.itemsQuantity(item); i++) {
                this.add(item);
            }
        }
    }

    @Override
    public boolean add(Item Item) {
        if (head.getValue() == null) {
            head.setValue(Item);
            size++;
            return true;
        }
        if (tail.getValue() == null) {
            tail.setValue(Item);
            size++;
            return true;
        }
        ListNode cur = tail;
        while (cur.getNext() != head) {
            cur = cur.getNext();
        }
        cur.setNext(new ListNode(head, cur, Item));
        head.setPrev(cur.getNext());
        size++;
        return true;
    }

    @Override
    public String[] itemNames() {
        String[] itemNames = new String[1];
        if (head.getValue() == null) {
            return new String[0];
        }
        itemNames[0] = head.getValue().getName();
        if (tail.getValue() == null) {
            return itemNames;
        }
        ListNode cur = head.getNext();
        while (cur != head) {
            if (!checkName(itemNames, cur.getValue().getName())) {
                String[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = cur.getValue().getName();
                itemNames = newArray;
            }
            cur = cur.getNext();
        }
        return itemNames;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int quantity = 0;
        ListNode cur = head;
        if (cur.getValue().getName().equals(itemName)) {
            quantity++;
        }
        if (cur.getNext().getValue() != null) {
            cur = cur.getNext();
        } else {
            return quantity;
        }
        if (head.getValue() == null) {
            return 0;
        }
        while (cur != head) {
            if (cur.getValue().getName().equals(itemName)) {
                quantity++;
            }
            cur = cur.getNext();
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(Item itemName) {
        int quantity = 0;
        ListNode cur = head;
        if (cur.getValue().getName().equals(itemName.getName())) {
            quantity++;
        }
        if (cur.getNext().getValue() != null) {
            cur = cur.getNext();
        } else {
            return quantity;
        }
        if (head.getValue() == null) {
            return 0;
        }
        while (cur != head) {
            if (cur.getValue().getName().equals(itemName.getName())) {
                quantity++;
            }
            cur = cur.getNext();
        }
        return quantity;
    }

    @Override
    public Item[] getItems() {
        Item[] itemNames = new Item[1];
        if (head.getValue() == null) {
            return new Item[0];
        }
        itemNames[0] = head.getValue();
        if (tail.getValue() == null) {
            return itemNames;
        }
        ListNode cur = head.getNext();
        while (cur != head) {
            if (!checkName(itemNames, cur.getValue())) {
                Item[] newArray = Arrays.copyOf(itemNames, itemNames.length + 1);
                newArray[itemNames.length] = cur.getValue();
                itemNames = newArray;
            }
            cur = cur.getNext();
        }
        return itemNames;
    }

    @Override
    public boolean remove(String itemName) {
        if (itemsQuantity(itemName) == 0) {
            return false;
        }
        ListNode cur = head;
        while (!cur.getValue().getName().equals(itemName)) {
            cur = cur.getNext();
        }
        if (size > 2) {
            cur.prev.setNext(cur.getNext());
            cur.next.setPrev(cur.getPrev());
            if (cur == head) {
                head = head.getNext();
            }
            tail = head.getNext();
        }
        if (size == 2) {
            head = cur.getNext();
            tail = new ListNode(head, head, null);
            head.setNext(tail);
            head.setPrev(tail);
        }
        if (size == 1) {
            size = 0;
            this.head = new ListNode(null, null, null);
            this.tail = new ListNode(null, null, null);
            this.head.setNext(this.tail);
            this.head.setPrev(this.tail);
            this.tail.setNext(head);
            this.tail.setPrev(head);
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(Item itemName) {
        if (itemsQuantity(itemName) == 0) {
            return false;
        }
        ListNode cur = head;
        while (cur.getValue() != itemName) {
            cur = cur.getNext();
        }
        if (size > 2) {
            cur.prev.setNext(cur.getNext());
            cur.next.setPrev(cur.getPrev());
            if (cur == head) {
                head = head.getNext();
            }
            tail = head.getNext();
        }
        if (size == 2) {
            head = cur.getNext();
            tail = new ListNode(head, head, null);
            head.setNext(tail);
            head.setPrev(tail);
        }
        if (size == 1) {
            size = 0;
            this.head = new ListNode(null, null, null);
            this.tail = new ListNode(null, null, null);
            this.head.setNext(this.tail);
            this.head.setPrev(this.tail);
            this.tail.setNext(head);
            this.tail.setPrev(head);
        }
        size--;
        return true;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        while (itemsQuantity(itemName) != 0) {
            ListNode cur = head;
            while (!cur.getValue().getName().equals(itemName)) {
                cur = cur.getNext();
            }
            if (size > 2) {
                cur.prev.setNext(cur.getNext());
                cur.next.setPrev(cur.getPrev());
                if (cur == head) {
                    head = head.getNext();
                }
                tail = head.getNext();
            }
            if (size == 2) {
                head = cur.getNext();
                tail = new ListNode(head, head, null);
                head.setNext(tail);
                head.setPrev(tail);
            }
            if (size == 1) {
                size = 0;
                this.head = new ListNode(null, null, null);
                this.tail = new ListNode(null, null, null);
                this.head.setNext(this.tail);
                this.head.setPrev(this.tail);
                this.tail.setNext(head);
                this.tail.setPrev(head);
            }
            size--;
            count++;
        }
        return count;
    }

    @Override
    public int removeAll(Item itemName) {
        int count = 0;
        while (itemsQuantity(itemName) != 0) {
            ListNode cur = head;
            while (cur.getValue() != itemName) {
                cur = cur.getNext();
            }
            if (size > 2) {
                cur.prev.setNext(cur.getNext());
                cur.next.setPrev(cur.getPrev());
                if (cur == head) {
                    head = head.getNext();
                }
                tail = head.getNext();
            }
            if (size == 2) {
                head = cur.getNext();
                tail = new ListNode(head, head, null);
                head.setNext(tail);
                head.setPrev(tail);
            }
            if (size == 1) {
                size = 0;
                this.head = new ListNode(null, null, null);
                this.tail = new ListNode(null, null, null);
                this.head.setNext(this.tail);
                this.head.setPrev(this.tail);
                this.tail.setNext(head);
                this.tail.setPrev(head);
            }
            size--;
            count++;
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
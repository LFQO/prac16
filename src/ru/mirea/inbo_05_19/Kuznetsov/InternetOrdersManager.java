package ru.mirea.inbo_05_19.Kuznetsov;

public class InternetOrdersManager implements OrdersManager {
    QueueNode head;
    QueueNode tail;
    int size;

    InternetOrdersManager() {
        this.head = new QueueNode(null, null, null);
        this.tail = head;
        head.setNext(tail);
        head.setPrev(tail);
        size = 0;
    }

    public boolean add(Order order) {
        QueueNode cur = new QueueNode(tail, head, order);
        tail.next = cur;
        cur.next.setPrev(cur);
        head = cur;
        size++;
        return true;
    }

    public Order remove() {
        QueueNode cur = tail;
        tail.getPrev().setNext(head);
        head.setPrev(tail.getPrev());
        tail = tail.getPrev();
        size--;
        return cur.getValue();
    }

    public Order order() {
        return tail.getValue();
    }

    @Override
    public int itemsQuantity(String itemName) {
        int cost = 0;
        Order[] orders = getOrders();
        for (Order order : orders) {
            cost += order.itemsQuantity(itemName);
        }
        return cost;
    }

    @Override
    public int itemsQuantity(Item itemName) {
        int cost = 0;
        Order[] orders = getOrders();
        for (Order order : orders) {
            cost += order.itemsQuantity(itemName);
        }
        return cost;
    }

    @Override
    public Order[] getOrders() {
        if (head.getValue() == null) {
            return new Order[0];
        }
        Order[] orders = new Order[size];
        QueueNode cur = head;
        for (int i = 0; i < size; i++) {
            orders[i] = cur.getValue();
            cur = cur.getNext();
        }
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int cost = 0;
        Order[] orders = getOrders();
        for (Order order : orders) {
            cost += order.costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }

    @Override
    public void remove(Order order) {
        QueueNode node = head;
        do {
            boolean f;
            f = true;
            Item[] Items = order.getItems();
            Item[] Items1 = node.getValue().getItems();
            if (Items.length != Items1.length) {
                f = false;
            }
            for (int j = 0; j < Items.length; j++) {
                if (!(Items[j].getName().equals(Items1[j].getName())) || order.itemsQuantity(Items[j]) != node.getValue().itemsQuantity(Items1[j])) {
                    f = false;
                    break;
                }
            }
            if (f) {
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
                if (node == head) {
                    head = node.getNext();
                }
                if (node == tail) {
                    tail = node.getPrev();
                }
            }
            return;
        } while (node != tail);
    }
}
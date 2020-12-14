package ru.mirea.inbo_05_19.Kuznetsov;

public class ListNode {
    public ListNode next;
    public ListNode prev;
    public Item value;

    public ListNode(ListNode next, ListNode prev, Item value) {
        this.next = next;
        this.prev = prev;
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public Item getValue() {
        return value;
    }

    public void setValue(Item value) {
        this.value = value;
    }
}
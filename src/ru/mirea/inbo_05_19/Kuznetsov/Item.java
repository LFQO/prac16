package ru.mirea.inbo_05_19.Kuznetsov;

public abstract class Item {
    private int cost;
    private String name;
    public String description;

    abstract int getCost();

    abstract String getName();

    abstract String getDescription();
}
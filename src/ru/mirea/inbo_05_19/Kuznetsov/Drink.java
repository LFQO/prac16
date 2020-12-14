package ru.mirea.inbo_05_19.Kuznetsov;

public final class Drink extends Item implements Alcoholics {
    DrinkTypeEnum type;
    int cost;
    String name;

    Drink(DrinkTypeEnum type) {
        this.type = type;
        cost = type.getCost();
        name = type.getName();
    }

    @Override
    public String getName() {
        return type.getName();
    }

    @Override
    public int getCost() {
        return type.getCost();
    }

    public Enum getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean isAlcoholDrink() {
        return type.isAlcoholics();
    }

    @Override
    public double getAlcoholVol() {
        return type.getVol();
    }
}
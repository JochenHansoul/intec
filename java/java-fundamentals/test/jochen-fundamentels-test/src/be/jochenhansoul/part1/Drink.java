package be.jochenhansoul.part1;

import be.jochenhansoul.part3.Drinkable;

public abstract class Drink implements Drinkable, Comparable<Drink> {
    private String name;
    private Integer price;

    public Drink(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public String drink() {
        return "drinking " + this.name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Drink drink = (Drink) object;
        return this.name.equals(drink.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", price: " + this.price;
    }

    @Override
    public int compareTo(Drink other) {
        return this.name.compareTo(other.name);
    }
}

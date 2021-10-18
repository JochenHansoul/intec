package be.jochenhansoul.part3;

public interface Drinkable {
    String drink();
    String getName();
    Integer getPrice();

    public default Integer getTemperature() {
        return 10;
    }
}

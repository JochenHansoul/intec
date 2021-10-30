package be.jochenhansoul.service;

public abstract class Oven {
    private int temperature;

    public Oven(int temperature) {
        this.temperature = temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public abstract void bake(String food, int amount);
}

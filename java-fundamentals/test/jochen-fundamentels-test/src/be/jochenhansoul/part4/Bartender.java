package be.jochenhansoul.part4;

import be.jochenhansoul.part3.Drinkable;

public interface Bartender {
    void showMenu();
    void addDrinkable(Drinkable drink);
    Integer calculateTotal();
    void printTicket();
}

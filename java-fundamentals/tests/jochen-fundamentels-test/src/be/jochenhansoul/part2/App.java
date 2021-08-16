package be.jochenhansoul.part2;

public class App {
    public static void main(String[] args) {
        Milk milk = new Milk();
        SoyMilk soyMilk = new SoyMilk();
        Expresso expresso = new Expresso();
        Latte latte = new Latte(milk);

        System.out.println("toString():");
        System.out.println(milk);
        System.out.println(soyMilk);
        System.out.println(expresso);
        System.out.println(latte);

        System.out.println("\nDrinking:");
        System.out.println(milk.drink());
        System.out.println(soyMilk.drink());
        System.out.println(expresso.drink());
        System.out.println(latte.drink());
    }
}

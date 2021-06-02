package be.jochenhansoul.opdracht1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many numbers do you want to enter?");
        int amountOfNumbers = input.nextInt();
        input.nextLine();

        List<Integer> integers = new ArrayList<>();
        for(int i = 0; i < amountOfNumbers; i++) {
            System.out.println("enter number");
            integers.add(input.nextInt());
            input.nextLine();
        }
        int sum = integers.stream()
            //.reduce(0, (a, b) -> a + b);
            .reduce(0, Integer::sum);

        // print numbers
        System.out.println(integers);

        // print sum
        System.out.println(sum);
        // print average
        System.out.println(sum / integers.size());
        input.close();
    }
}

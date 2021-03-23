package be.inferwhale;

import java.sql.SQLOutput;
import java.util.Formatter;
import java.util.Scanner;

public class Opdracht4 {
    /*
    (4) Schrijf een calculator voor de basis bewerkingen (+, -, * en /)
    Het programma start met te vragen welke bewerking de gebruiker wilt uitvoeren.
    Vervolgens vraagt het programma om 2 getallen in te geven. Je mag ervan uit gaan dat we gebruik maken van gehele getallen (dus geen komma-getallen)

    Het programma maakt daarna de geselecteerde berekening en drukt het resultaat af.

    !!! Zorg ervoor dat als de gebruiker om een deling vraagt dat het resultaat tot 2 cijfers na de komma afgedrukt wordt.  Gebruik hiervoor een Formatter object. (hint: je mag alle manieren gebruiken die we in de les gezien hebben)
    !!! Schrijf voor elke bewerking een aparte methode
     */

    public static void main(String[] args) {
        String operation = requestOperationInput();
        int number1 = requestNumber();
        int number2 = requestNumber();

        String output = createOutput(operation, number1, number2);
        System.out.println(output);
    }

    public static String createOutput(String operation, int n1, int n2) {
        float result = 0;

        if (operation.equals("+")) result = n1 + n2;
        if (operation.equals("-")) result = n1 - n2;
        if (operation.equals("*")) result = n1 * n2;
        if (operation.equals("/")) result = (float) n1 / n2;

        Formatter formatter = new Formatter();
        return formatter.format("%d %s %d = %.2f", n1, operation, n2, result).toString();
    }

    public static String requestOperationInput() {
        System.out.println("What operation would you like to do? (+, -, *, /");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static int requestNumber() {
        System.out.println("Please enter a number: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}

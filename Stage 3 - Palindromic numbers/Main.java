package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Number number = new Number();
        boolean isRunning = true;
        System.out.print("""
                Welcome to Amazing Numbers!
                                
                Supported requests:
                - enter a natural number to know its properties;
                - enter 0 to exit.
                """);
        while (true) {
            System.out.print("\nEnter a request: ");
            long num = scanner.nextLong();
            if (num < 0) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
                continue;
            }
            if (num == 0) break;
            number.printProperties(num);
        }
        System.out.println("\nGoodbye!");
    }
}

package numbers;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a natural number");
        int n = scanner.nextInt();

        if (n < 1)
        {
            System.out.println("This number is not natural");
            return;
        }

        boolean even = n % 2 == 0;
        boolean odd = !even;
        boolean buzz = n % 7 == 0 || n % 10 == 7;
        boolean duck = isDuck(n);

        System.out.printf("Properties of %d%n", n);
        System.out.printf("\teven : %b%n", even);
        System.out.printf("\todd  : %b%n", odd);
        System.out.printf("\tbuzz : %b%n", buzz);
        System.out.printf("\tduck : %b%n", duck);
    }
    public static boolean isDuck(int n)
    {
        while (n != 0)
        {
            if (n % 10 == 0)
                return true;
            n /= 10;
        }
        return false;
    }
}

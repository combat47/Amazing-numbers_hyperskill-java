package numbers;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome to Amazing Numbers!");
    System.out.println();
    String requests = """
        Supported requests:
        - enter a natural number to know its properties;
        - enter two natural numbers to obtain the properties of the list:
              * the first parameter represents a starting number;
              * the second parameter shows how many consecutive numbers are to be printed;
        - separate the parameters with one space;
        - enter 0 to exit.
        """;
        System.out.println(requests);

    while (true) {
        System.out.print("Enter a request: ");
        String input = sc.nextLine();
        System.out.println();
        if (input.isEmpty()) {
            System.out.println(requests);
            continue;
        }
        if (input.equals("0")) {
            System.out.println("Goodbye!");
            break;
        }

        String[] inputs = input.split(" ");
        int size = inputs.length;
        long[] numbers = new long[size];
        try {
            for (int i = 0; i < size; i++) {
                numbers[i] = Long.parseLong(inputs[i]);
            }
            if (size == 1) {
                long n = numbers[0];
                if (n < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    System.out.println();
                    continue;
                }
                System.out.printf("Properties of %d\neven: %b\nodd: %b\nbuzz: %b\nduck: %b\npalindromic: %b\ngapful: %b\n",
                        n, parityCheck(n), !parityCheck(n), buzzCheck(n), duckCheck(n), palindromicCheck(n), gapfulCheck(n));
                System.out.println();
            } else {
                long firstNumber = numbers[0];
                long secondNumber = numbers[1];
                if (secondNumber < 0) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }
                for (long i = firstNumber,j = 0; j < secondNumber; i++, j++) {
                    String props = String.format("%d is",i);
                    props += (parityCheck(i)) ? " even" : " odd";
                    props += (buzzCheck(i)) ? ", buzz" : "";
                    props += (duckCheck(i)) ? ", duck" : "";
                    props += (gapfulCheck(i)) ? ", gapful" : "";
                    props += (palindromicCheck(i)) ? ", palindromic" : "";
                    System.out.println(props);
                    System.out.println();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("The first parameter should be a natural number or zero.");
            System.out.println();
            continue;
        }

    }
    }

    public static boolean palindromicCheck(long n) {
        long copy = n;
        long nPrime = 0;
        while (n != 0) {
            nPrime = nPrime * 10 + n % 10;
            n /= 10;
        }
        return copy == nPrime;
    }

    public static boolean parityCheck(long n) {
        return n % 2 == 0;
    }

    public static boolean buzzCheck(long n) {
        return n % 10 == 7 || n % 7 == 0;
    }

    public static boolean duckCheck(long n) {
        while (n != 0) {
            if (n % 10 == 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

    public static boolean gapfulCheck(long n) {
        int lastDigit = (int) (n % 10);
        int firstDigit = 0;
        int countDigits = 0;
        long copyOfN = n;
        while (copyOfN != 0) {
            if (copyOfN < 10) {
                firstDigit = (int) copyOfN;
            }
            copyOfN /= 10;
            countDigits++;
        }
        int divisor = Integer.parseInt(Integer.toString(firstDigit) + lastDigit);
        return countDigits > 2 && n % divisor == 0;
    }
}

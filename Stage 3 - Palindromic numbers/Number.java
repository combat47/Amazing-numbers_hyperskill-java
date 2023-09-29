package numbers;

public class Number {

    public void printProperties(long num) {
        System.out.printf("""
                                
                Properties of %d
                        even: %b
                         odd: %b
                        buzz: %b
                        duck: %b
                 palindromic: %b
                 """, num, checkEven(num), !checkEven(num), checkBuzz(num), checkDuck(num), checkPalindromic(num));
    }

    private boolean checkEven(long num) {
        return num % 2 == 0;
    }

    private boolean checkBuzz(long num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    private boolean checkDuck(long num) {
        return String.valueOf(num).contains("0");
    }

    private boolean checkPalindromic(long num) {
        return String.valueOf(num).contentEquals(new StringBuilder(String.valueOf(num)).reverse());
    }
}

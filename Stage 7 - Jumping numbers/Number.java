package numbers;

import java.util.HashSet;
import java.util.Set;

import static numbers.Number.Properties.*;

public class Number {
    private final Set<Properties> properties; // this collection is filled with the properties of the current number, which are defined in the enum Properties.
    final long VALUE;

    Number(long i) {
        this.VALUE = i;
        this.properties = new HashSet<>();
    }

    Number setProperties() {
        isBuzz();
        isDuck();
        isPalindromic();
        isGapful();
        isSpy();
        isSquare();
        isSunny();
        isEven();
        isJumping();
        return this;
    }

    Set<Properties> getProperties() {
        return properties;
    }

    private void isEven() {
        if (VALUE % 2 == 0) {
            properties.add(EVEN);
        } else {
            properties.add(ODD);
        }
    }

    private void isBuzz() {
        if (endsWith7(VALUE) || isDividableBy7(VALUE)) {
            properties.add(BUZZ);
        }
    }

    private void isDuck() {
        long value = VALUE;
        do {
            if (value % 10 == 0) {
                properties.add(DUCK);
                return;
            }
            value /= 10;
        }
        while (value / 10 != 0);
    }

    private void isGapful() {
        String number = String.valueOf(VALUE);
        String digits;
        if (number.length() > 2) {
            digits = number.charAt(0) + number.substring(number.length() - 1);
            if (Long.parseLong(number) % Integer.parseInt(digits) == 0) {
                properties.add(GAPFUL);
            }
        }
    }

    private void isPalindromic() {
        String original = String.valueOf(VALUE);
        StringBuilder reversed = new StringBuilder(original).reverse();
        if (original.equals(reversed.toString())) {
            properties.add(PALINDROMIC);
        }
    }

    private void isSpy () {
        char[] number = String.valueOf(VALUE).toCharArray();
        int sum = 0;
        int product = 1;

        for (char c : number) {
            sum += Character.getNumericValue(c);
        }

        for (char c : number) {
            product *= Character.getNumericValue(c);
        }

        if (sum == product) {
            properties.add(SPY);
        }
    }

    private void isSquare() {
        if (Math.sqrt(VALUE) % 1 == 0) {
            properties.add(SQUARE);
        }
    }

    private void isSunny() {
        if (isSquare(VALUE + 1)) {
            properties.add(SUNNY);
        }
    }

    boolean isSquare(long i) {
        return Math.sqrt(i) % 1 == 0;
    }
    private void isJumping() {
        char[] number = String.valueOf(VALUE).toCharArray();
        int totalDiff = 0;
        for (int i = 1; i < number.length; i++) {
            totalDiff += Math.abs((number[i - 1] - 48) -  (number[i] - 48));
            if (totalDiff != i) {
                return;
            }
        }
        properties.add(JUMPING);
    }

    private boolean endsWith7(long i) {
        return i % 10 == 7;
    }

    private boolean isDividableBy7(long i) {
        return i % 7 == 0;
    }

    enum Properties {
        EVEN ("even", "ODD"),
        ODD("odd", "EVEN"),
        BUZZ("buzz", ""),
        DUCK("duck", "SPY"),
        PALINDROMIC("palindromic", ""),
        GAPFUL("gapful", ""),
        SPY("spy", "DUCK"),
        SQUARE("square", "SUNNY"),
        SUNNY("sunny", "SQUARE"),
        JUMPING("jumping","");


        final String name;
        final String mutualExclusive;

        Properties(String name, String mutualExclusive) {
            this.name = name;
            this.mutualExclusive = mutualExclusive;
        }

        static boolean exists(String property) {
            for (Properties value : Properties.values()) {
                if (value.name.equalsIgnoreCase(property)) {
                    return true;
                }
            }
            return false;
        }
    }
}

package com.lsr.problems;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * A utility class to find the square root of a number with a specified precision.
 */
public class PreciseSquareRoot {

    /**
     * Calculates the square root of a non-negative number with a precision of 4 decimal places.
     * This method uses a two-phase binary search approach for efficiency.
     *
     * @param number The number for which to find the square root. Must be non-negative.
     * @return The square root of the number, rounded to 4 decimal places.
     * @throws IllegalArgumentException if the number is negative.
     */
    public static double sqrt(double number) {
        // --- Phase 1: Handle edge cases and find the integer part using binary search ---

        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate the square root of a negative number.");
        }
        if (number == 0 || number == 1) {
            return number;
        }

        // Define the search range for the integer part
        double start = 0;
        double end = number;
        double integerPart = 0.0;
		System.out.println("number "+number);
        // Perform binary search to find the closest integer square root
        while (start <= end) {
            double mid = start + (end - start) / 2;
            double square = mid * mid;
            System.out.println("------ ");

            System.out.println("start "+start +" end "+end);
    		System.out.println("square "+square +" mid "+mid);

            if (square == number) {
                // Perfect square found, return immediately
            	
                return roundToFourDecimalPlaces(mid);
            } else if (square < number) {
                // Mid could be part of the answer, so store it and search the right half
                integerPart = mid;
                start = mid + 1;
                System.out.println("start (mid +1 ) - -"+start );

            } else {
                // Mid is too large, search the left half
                end = mid - 1;
                System.out.println("end (mid -1) - -"+end );

            }
        }

        // --- Phase 2: Find the decimal part by iterative refinement ---

        double precision = 0.0001;
        double result = integerPart;

        // Iterate a few times to get the desired precision.
        // For 4 decimal places, 5 iterations are typically sufficient.
        for (int i = 0; i < 5; i++) {
            while (result * result < number) {
                result += precision;
            }
            // Step back one increment, as the last increment overshot the value.
            result -= precision;
            // Decrease the precision for the next decimal place.
            precision /= 10;
        }

        return roundToFourDecimalPlaces(result);
    }

    /**
     * A helper method to round a double to 4 decimal places.
     *
     * @param value The double to round.
     * @return The rounded double.
     */
    private static double roundToFourDecimalPlaces(double value) {
        // Using DecimalFormat for precise rounding, which is a good practice.
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println("roundToFourDecimalPlaces "+value );
        return Double.parseDouble(df.format(value));
    }

    public static void main(String[] args) {
        // Test cases to demonstrate the function
        double num1 = 16.0;
        double num2 = 10.0;
        double num3 = 2.0;
        double num4 = 0.25;
        double num5 = 100.0;
        double num6 = 12345.6789;

        System.out.println("Square root of " + num1 + " is: " + sqrt(num1)); // Expected: 4.0
        System.out.println("Square root of " + num2 + " is: " + sqrt(num2)); // Expected: 3.1623
        System.out.println("Square root of " + num3 + " is: " + sqrt(num3)); // Expected: 1.4142
        System.out.println("Square root of " + num4 + " is: " + sqrt(num4)); // Expected: 0.5
        System.out.println("Square root of " + num5 + " is: " + sqrt(num5)); // Expected: 10.0
        System.out.println("Square root of " + num6 + " is: " + sqrt(num6)); // Expected: 111.1111
    }
}


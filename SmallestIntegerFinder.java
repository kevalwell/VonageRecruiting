/*************************************************************************
 * Name: Sean Yun
 * 
 * Compilation: javac SmallestIntegerFinder.java
 * Execution: java SmallestIntegerFinder
 * Dependencies: java.util.Scanner
 *
 * Description: First asks for number of integers in array. Then asks to
 * to provide each integer in the array. Prints the smallest value.
 **************************************************************************/

import java.util.Scanner;

public class SmallestIntegerFinder {
    
    public static int findSmallestInt(int[] args) {
        int min = args[0];
        int arrayLength = args.length;
        
        for (int i = 1; i < arrayLength; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        
        return min;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n; // Number of array elements
        
        System.out.printf("Enter number of integers: ");
        for (;;) {
            String input = in.next();
            try {
                n = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ne){
                System.out.printf("%s is not an integer. "
                        + "Please enter an integer: ", input);
            }
        }
        
        int[] intArray = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter integer #%d: ", i+1);
            for (;;) {
                String input = in.next();
                try {
                    intArray[i] = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException ne){
                    System.out.printf("%s is not an integer. "
                            + "Please enter an integer: ", input);
                }
            }
        }
        
        int smallestInt = findSmallestInt(intArray);
        
        System.out.printf("The smallest integer is %d.\n", smallestInt);
    }
}
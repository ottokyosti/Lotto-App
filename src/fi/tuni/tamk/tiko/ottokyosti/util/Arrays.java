package fi.tuni.tamk.tiko.ottokyosti.util;
/**
 * The class Arrays contains methods for handling
 * different given arrays
 * 
 * @author Otto Kyösti
 */
public class Arrays {
    /**
     * The toIntArray method takes the String array given to it
     * and converts it into Int array step by step.
     * @param array the String array which will be converted to int array
     * @return a converted array containing integers
     */
    public static int [] toIntArray(String [] array) {
        int [] IntArray = new int[array.length];
        for (int i = 0; i < IntArray.length; i++) {
            IntArray[i] = Integer.parseInt(array[i]);
        }
        return IntArray;
    }
    /**
     * The contains method goes through given int array
     * and checks if the given value is found in the array
     * @param value given value to be compared to the array's numbers
     * @param array given array to be checked
     * @return either true or false depending if give value is found in the array
     */
    public static boolean contains(int value, int [] array) {
        boolean checkContains = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                checkContains = true;
            }
        }
        return checkContains;
    }
    /**
     * The containsSameValues method goes through two given
     * int arrays and checks whether there are equal values
     * present
     * @param array1 the first array for the comparison
     * @param array2 the second array for the comparison
     * @return a value indicating how many values were equal
     */
    public static int containsSameValues(int [] array1, int [] array2) {
        int counter = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
    /**
     * The populate method gets an empty array as a parameter and populates
     * it with numbers in ascending order
     * @param numbers the integer array that will be populated
     * @return an integer array with numbers in ascending order
     */
    public static int[] populate(int [] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }
    /**
     * The removeIndex method gets an array and am integer value as parameters
     * and creates a new array without the number from the original array
     * using the given value
     * @param numbers the original array from which the number will be removed
     * @param index the position from where the number will be removed from the array
     * @return an array that is shorter by one in length compared to the original array and without the index value
     */
    public static int[] removeIndex(int [] numbers, int index) {
        int [] newNumbers = new int[numbers.length - 1];
        for (int i = 0; i < newNumbers.length; i++) {
            if (i < index) {
                newNumbers[i] = numbers[i];
            } else {
                newNumbers[i] = numbers[i + 1];
            }
        }
        return newNumbers;
    }
    /**
     * The bestOfAdd method gets it's parameters as String array to be added in, the index where
     * the number will be added and the value which to add. I chose the array to be in String
     * form, because an empty String array is populated with null-values. Because the parameter 
     * 'years' could be 0, there would not be a suitable if statement. We don't have to modify
     * the String array after this.
     * @param bestOf the String array that will be modified
     * @param howManyCorrect the value that points the index from the array
     * @param years the value that will be added to the index place in the array
     * @return the String array with a value in it's specified index
     */
    public static String[] bestOfAdd(String [] bestOf, int howManyCorrect, int years) {
        if (bestOf[howManyCorrect - 1] == null) {
            bestOf[howManyCorrect - 1] = String.valueOf(years);
        }
        return bestOf;
    }
    /**
     * The sort method gets an array as it's parameter and sorts it using selection sort
     * @param array an array which you want to sort
     * @return an array that is sorted from smallest to largest number
     */
    public static int [] sort(int [] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[index]) {
                    index = j;
                }
            }
            int smallestNumber = array[i];
            array[i] = array[index];
            array[index] = smallestNumber;
        }
        return array;
    }
    /**
     * The printArray method gets an array as it's parameter and prints it
     * @param array the array from where you want to print the numbers
     * @param turnDecider the value that determines which prefix ('User lotto' or 'Random lotto') is used in printing
     */
    public static void printArray(int [] array, int turnDecider) {
        if (turnDecider == 0) {
            System.out.print("User lotto:   ");
        } else {
            System.out.print("Random lotto: ");
        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 10) {
                System.out.print(0);
            }
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
package fi.tuni.tamk.tiko.ottokyosti.util;

import java.io.Console;
/**
 * The MyConsole class handles all the methods that include user input
 * 
 * @author Otto Kyösti
 */
public class MyConsole {
    /**
     * The readInt method reads the user input using Console and loops until
     * the value within method parameters is given.
     * @param min determines the lowest value user can input
     * @param max determines the highest value user can input
     * @param errorMessageNonNumeric error message that displays if the given input is not an integer
     * @param errorMessageNonMinAndMax error message that displays if the given input is outside the min and max parameters
     * @return the given input if it is within parameters
     */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Console c = System.console();
        boolean trying = true;
        int input = 0;
        while (trying) { 
            try {
                input = Integer.parseInt(c.readLine());
                if (input < min || input > max) {
                    System.out.println(errorMessageNonMinAndMax);
                } else {
                    trying = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
            }
        }
        return input;
    }
    /**
     * The readAnswer method gets called to the main method whenever the application needs
     * to ask a simple String value from the user.
     * @return a String variable given by the user
     */
    public static String readAnswer() {
        Console c = System.console();
        String answer = c.readLine();
        return answer;
    }
}
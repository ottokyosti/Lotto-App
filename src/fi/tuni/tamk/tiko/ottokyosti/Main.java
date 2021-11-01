package fi.tuni.tamk.tiko.ottokyosti;

import fi.tuni.tamk.tiko.ottokyosti.util.Math;
import fi.tuni.tamk.tiko.ottokyosti.util.Arrays;
import fi.tuni.tamk.tiko.ottokyosti.util.MyConsole;
/**
 * The class Main contains the lottery application's methods. The Main claass
 * also declares static and final static variables before any methods to be
 * used in them.
 * 
 * @author Otto Kyösti
 */
public class Main {
    static final int min = 1;
    static final int max = 40;
    static final int LottoLength = 7;
    static int years = 0;
    static int weeks = 1;
    static int howManyCorrect = 0;
    static String answer = "";
    static String ErrorMessageNonNumeric = "Not a number! Please give a unique number between [" + min + ", " + max + "]";
    static String ErrorMessageNonMinMax = "Outside the range! Please give a unique number between [" + min + ", " + max + "]";
    /**
     * The main method which handles user input queries (asking for the UI, asking for the numbers) and 
     * is the main method where the lottery application will loop
     * @param args the array to which you can input values using the command line. Will be used as
     * an array for the lottery if the user decides so
     */
    public static void main(String [] args) {
        boolean running = true;
        System.out.println("Do you want to see the lottory information? (y/n)");
        while (!(answer.equals("y")) && !(answer.equals("n"))) {
            answer = MyConsole.readAnswer();
        }
        int [] UserArray = new int[LottoLength];
        if (args.length == 7) {
            UserArray = Arrays.toIntArray(args);
        } else {
            for (int i = 0; i < LottoLength; i++) {
                System.out.println("Please give a unique number between [" + min + ", " + max +"]");
                int input = MyConsole.readInt(min, max, ErrorMessageNonNumeric, ErrorMessageNonMinMax);
                if (!(Arrays.contains(input, UserArray))) {
                    UserArray[i] = input;
                } else {
                    System.out.println("You already guessed this number. Guess again!");
                    i--;
                }
            }
        }
        while (running) {
            years = 0;
            weeks = 1;
            if (gameInProgress(UserArray, answer)) {
                System.out.println("It took more than a lifetime (120y)! Press 'enter' to try again!");
                MyConsole.readAnswer();
            } else {
                System.out.println("You won the lottery in your lifetime!");
                running = false;
            }
        }
    }
    /**
     * The gameInProgress is the method where the actual lottery application takes place. It uses
     * calculateLotto method to get random lottery line, it keeps track of the years using weeks
     * as a counter, it also checks for how many correct numbers are between the two arrays and
     * it saves the specific years in an array to create a "bestOf" list
     * @param UserArray the array created in the main method and where the user's inputs are stored
     * @param answer the String variable which holds the answer to whether user wants to see the UI
     * @return boolean value, which depends if the lottery is completed within lifetime (120y) or not
     */
    public static boolean gameInProgress(int [] UserArray, String answer) {
        howManyCorrect = 0;
        String [] bestOf = new String[LottoLength];
        System.out.println("Calculating...");
        while (howManyCorrect < LottoLength) {
            int turnDecider = 0;
            int [] LottoArray = calculateLotto(LottoLength);
            LottoArray = Arrays.sort(LottoArray);
            UserArray = Arrays.sort(UserArray);
            if (answer.equals("y")) {
                Arrays.printArray(UserArray, turnDecider);
                turnDecider++;
                Arrays.printArray(LottoArray, turnDecider); 
            }
            howManyCorrect = Arrays.containsSameValues(UserArray, LottoArray);
            weeks++;
            if (weeks == 52) {
                years++;
                weeks = 0;
            }
            if (howManyCorrect > 0) {
                bestOf = Arrays.bestOfAdd(bestOf, howManyCorrect, years);
            }
        }
        for (int i = 0; i < bestOf.length; i++) {
            System.out.println("Got " + (i + 1) + " right! It took " + bestOf[i] + " years!");
        }
        if (years > 120) {
            return true;
        } else {
            return false;
        }  
    }
    /**
     * The calculateLotto method assigns a random value for each of the numbers in the lottery
     * using the given parameters.
     * @param LottoLength the value which determines how many numbers does the lottery array
     * contain
     * @return the lottery array where all numbers are random
     */
    private static int[] calculateLotto(int LottoLength) {
        int [] LottoArray = new int[LottoLength];
        int [] numbers = new int[max];
        numbers = Arrays.populate(numbers);
        for (int i = 0; i < LottoLength; i++) {
            int index = Math.getRandom(0, numbers.length - 1);
            int randomNumber = numbers[index];
            LottoArray[i] = randomNumber;
            numbers = Arrays.removeIndex(numbers, index);
        }
        return LottoArray;
    }
}
package fi.tuni.tamk.tiko.ottokyosti.util;
/**
 * The class Math contains methods for performing basic calculations
 * to be used in other methods.
 * 
 * @author Otto Kyösti
 */
public class Math {
    /**
     * This method gives a random number ranging from given minimun value
     * to given maximum value.
     * @param min the minimum value which determines the lowest random number
     * @param max the maximum value which determines the highest random number
     * @return random number ranging from given two values.
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));   
    }
}
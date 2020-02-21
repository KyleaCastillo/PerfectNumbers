/**********************************************
 * created by Intellij idea.
 * User: Kyle Castillo
 * Date: 2/20/2020
 * Time: 11:15 AM
 * Contact: kylea.castillo@calbaptist.edu
 ***********************************************/

public class PerfectNumbers {

    /**********************************************************
     * Main method to return whether a number is perfect or not.
     * A note regarding the algorithm, because there are no
     * odd perfect numbers up to 10^1500 there is no need
     * to check any value that is odd.
     *
     * The current method is based on the equation to find
     * the perfect numbers based on the equation proved
     * by Euclid. The equation 2^(p-1) * (2^(p) - 1) calculates
     * what perfect numbers are. A perfect number is perfect where
     * the second half of the equation yields a prime number.
     *
     * From there its a simple calculation to find the perfect
     * number. 0 indicates that the number is not perfect and
     * if it is perfect then the number is returned.
     **********************************************************/

    private static int perfectCalc(int num) {
        int euclidA = (int) Math.pow(2, num - 1);
        int euclidB = (int) Math.pow(2, num) -1;
        if(!isPrime(euclidB)) return 0;                     //Returns zero if the number inside is not prime.
        return euclidA * euclidB;
    }


    /***********************************************
     * Simple method to check whether a number
     * is prime or not, its important in order
     * to calculate a proper perfect number based on
     * Euclid's equation.
     **********************************************/
    private static boolean isPrime(int num){
        if(num % 2 == 0) return false;
        for(int i = 2; i < Math.sqrt(num); i++){
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }


        public static void main (String[] args){
            int i = 2;                                                      //2 has to be the start in order to avoid fractions.
            int bound = 1;
            while(bound >= 0){
                int perfectNum = perfectCalc(i);
                if(perfectNum > 0 && perfectNum < Integer.MAX_VALUE){
                    System.out.println(perfectNum + " is a perfect num.");
                }
                i++;
                bound = perfectNum;
            }
            System.out.println("Maximum value reached for 64-bit processors.");
        }
    }

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public Main(){}

    public static ArrayList<Integer> getPrimeNumbers(int limit){
        /*
        Uses the Sieve of Eratosthenes Algorithm to find all prime numbers between 2 and a given limit
        :param limit: integer provided by user
        :return ArrayList with solution
         */

        ArrayList<Integer> primeNums = new ArrayList<>(limit + 1);
        boolean[] sieveComposite = new boolean[limit +1];
        int initPrime = 2; // Starting Prime Number

        while (initPrime * initPrime <= limit){ // Ensures initPrime^2 does not exceed limit
            int multiple = initPrime * initPrime; // Marks off Multiples

            while (multiple <= limit){
                sieveComposite[multiple] = true; // Sets true to all composite numbers
                multiple += initPrime;
            }

            for (int i = initPrime + 1; i <= limit; i++){
                if (!sieveComposite[i]){
                    initPrime = i; // Increments to next prime by looking for next non-composite
                    break;
                }
            }
        }

        for (int i = 2; i <= limit; i++){
            if (!sieveComposite[i]){ // Adds all non-composite numbers to output array
                primeNums.add(i);
            }
        }
        return primeNums;

    }

    public static void main(String[] args) {
        System.out.println("*******Welcome to the Sieve of Erathosthenes*******");
        System.out.println("Please enter your limit: ");

        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        scanner.close();

        ArrayList<Integer> primeList = getPrimeNumbers(limit);
        System.out.println(primeList);
    }
}

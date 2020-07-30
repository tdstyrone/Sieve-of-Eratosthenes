package com.tdstyrone;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> getPrimeNumbers(int limit){
        ArrayList<Integer> primeNums = new ArrayList<>(limit + 1);
        boolean[] sieveComposite = new boolean[limit +1];
        int initPrime = 2;

        while (initPrime * initPrime <= limit){
            int multiple = initPrime * initPrime;

            while (multiple <= limit){
                sieveComposite[multiple] = true;
                multiple += initPrime;
            }

            for (int i = initPrime + 1; i <= limit; i++){
                if (!sieveComposite[i]){
                    initPrime = i;
                    break;
                }
            }
        }

        for (int i = 2; i <= limit; i++){
            if (!sieveComposite[i]){
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

        ArrayList<Integer> primeList = getPrimeNumbers(limit);
        System.out.println(primeList);
    }
}

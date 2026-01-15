package Assignments;

import java.util.ArrayList;

public class StockPrices {

    public static void main(String[] args) {
        int[] stockGeneralPrices = {12, 45, 45, 6890, 334};
        ArrayList <Integer> stockList = new ArrayList<>();
        for (int price : stockGeneralPrices) {
            stockList.add(price);
        }
        
        // calling methods: 
        double average = calculateAveragePrice(stockGeneralPrices);
        System.out.println("We have an average price of: " + average);

        int maximum = findMaximumPrice(stockGeneralPrices);
        System.out.println("The maximun amount found in the array is: " + maximum);

        int occurance = 12;
        int count = countOccurrences(stockGeneralPrices, occurance);
        System.out.println("Repeated occurance " + occurance + ": " + count);

        ArrayList<Integer> acumulado = computeCumulativeSum(stockList);
        System.out.println("Our stock cumulative is: " + acumulado);
    }

    // Calculate the average of stock prices
    static double calculateAveragePrice(int[] stockPrices){
        int sum = 0; // initiatize incremental
        for(int price: stockPrices){
            sum += price;
        }
        return (double) sum / stockPrices.length;

    }

    //Find the maximum stock price
    public static int findMaximumPrice(int[] stockPrices){
        int maxPrice = stockPrices[0];
        for (int price: stockPrices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    // Determine the occurances count of a specific price
    static int countOccurrences( int[] stockPrices, int occurance){
        int count = 0; // initialize counter
        for (int price : stockPrices) {
            if (price == occurance) { //if count is iqual to occurance
                count ++; // increment counter
            }
        }
        return count;
    }

    // Compute the cumulative sum of stock price:

    static ArrayList<Integer> computeCumulativeSum(ArrayList<Integer> stockPrices){
        ArrayList<Integer> cumulativeSum = new ArrayList<>(); // initialized array list
        int sum = 0;
        for (int price : stockPrices) { //for each price in stockPrices
            sum += price; // increment the sum of stock price 
            cumulativeSum.add(sum); // add the cumulativeSum value to the Array. 
        }
        return cumulativeSum;
    }
}





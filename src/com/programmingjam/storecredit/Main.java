package com.programmingjam.storecredit;

import java.util.*;
/**
 * Created by User on 4/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
       //System.out.println("n="+n);

        for(int j = 0;j < n; j++){
            int c = in.nextInt();
            int i = in.nextInt();
            in.nextLine();
            String items = in.nextLine();
            String [] pricesString = items.split("\\s+");
            int [] prices = convertToIntPrices(pricesString);
            handleArr(prices,c,j+1);
        }
    }

    private static void handleArr(int [] prices,int sum,int caseNum){
        for(int i = prices.length-1; i>= 0; i--){
            if(prices[i]<sum){
                for(int j = i-1;j >= 0;j--){
                    if(prices[i]+prices[j]==sum) {
                        System.out.println("Case #" + caseNum + ": " + (j + 1) + " " + (i + 1));
                        return;
                    }
                }
            }
        }
    }

    /*private static void printIntArr(int [] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }*/

    private static int [] convertToIntPrices(String [] prices){
        int len=prices.length;
        int [] pricesNum = new int [len];
        for(int i = 0; i<len;i++){
            pricesNum[i] = Integer.parseInt(prices[i]);
        }
        return pricesNum;
    }
}

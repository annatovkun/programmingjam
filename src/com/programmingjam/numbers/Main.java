package com.programmingjam.numbers;

import java.util.Scanner;

/**
 * Created by User on 4/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            int d = in.nextInt();
            double calc = Math.pow((3 + Math.sqrt(5)), d);
            //int resultNum = ((int) calc)%1000;
            String res= String.valueOf(calc);
            int endInd = res.indexOf('.');
            res =res.substring(0,endInd);
            StringBuilder sb = new StringBuilder();
            if(res.length()>=3){
                sb.append(res.substring(res.length()-3));
            }
            else {
                if (res.length() == 2)
                    sb.append("0");
                if (res.length() == 1)
                    sb.append("00");
                sb.append(res);
            }
            System.out.println("Case #"+i+": "+sb.toString());

        }
    }
}

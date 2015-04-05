package com.programmingjam.t9spelling;

import java.util.*;

/**
 * Created by User on 4/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0 ; i< n; i++){
            String msg = in.nextLine();
            StringBuilder sb = new StringBuilder();
            String prev = null;
            for(int j=0; j<msg.length();j++){
                char c = msg.charAt(j);
                String str = getNumeric(c);
                if(prev!=null && str.charAt(0) == prev.charAt(0)){
                    sb.append(" ");
                }
                sb.append(str);
                prev = str;

            }
            System.out.println("Case #"+(i+1)+": "+sb.toString());
        }
    }
    private static String getNumeric(char c){
        switch(c){
            case 'a':
                return "2";
            case 'b':
                return "22";
            case 'c':
                return "222";
            case 'd':
                return "3";
            case 'e':
                return "33";
            case 'f':
                return "333";
            case 'g':
                return "4";
            case 'h':
                return "44";
            case 'i':
                return "444";
            case 'j':
                return "5";
            case 'k':
                return "55";
            case 'l':
                return "555";
            case 'm':
                return "6";
            case 'n':
                return "66";
            case 'o':
                return "666";
            case 'p':
                return "7";
            case 'q':
                return "77";
            case 'r':
                return "777";
            case 's':
                return "7777";
            case 't':
                return "8";
            case 'u':
                return "88";
            case 'v':
                return "888";
            case 'w':
                return "9";
            case 'x':
                return "99";
            case 'y':
                return "999";
            case 'z':
                return "9999";
            case ' ':
                return "0";
            default:
                return "";



        }
    }

}

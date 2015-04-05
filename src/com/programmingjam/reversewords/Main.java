package com.programmingjam.reversewords;
 import java.util.*;
/**
 * Created by User on 4/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0 ; i < n ; i++){
            String l = in.nextLine();
            String [] words = l.split("\\s");
            int len = words.length;
            StringBuilder sb = new StringBuilder();
            for(int j = len-1; j>=0;j--){
                sb.append(words[j]);
                if(j>0){
                    sb.append(" ");
                }
            }
            System.out.println("Case #"+(i+1)+": "+sb.toString());
        }
    }
}

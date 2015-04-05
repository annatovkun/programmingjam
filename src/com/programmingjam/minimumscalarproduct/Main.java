package com.programmingjam.minimumscalarproduct;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
/**
 * Created by User on 4/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int len = in.nextInt();
            in.nextLine();
            String [] v1 = in.nextLine().split("\\s");
            String [] v2 = in.nextLine().split("\\s");
            calculateMinPermute(v1,v2,len,i);
        }
    }

    private static void calculateMinPermute(String [] v1, String [] v2, int len,int caseNum) {
        int [] a1 = new int[len];
        int [] a2 = new int[len];
        for(int i = 0; i < len; i++){
            a1[i] = Integer.parseInt(v1[i]);
            a2[i] = Integer.parseInt(v2[i]);
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += (a1[i]*a2[len - i -1]);
        }
        System.out.println("Case #"+(caseNum+1)+": "+sum);


    }
}

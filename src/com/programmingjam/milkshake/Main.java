package com.programmingjam.milkshake;

import java.util.*;
/**
 * Created by User on 4/5/2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int c = in.nextInt();
        for(int i = 0; i<c ;i++){
            handleCase(in,i+1);
        }
    }
    private static void handleCase(Scanner in,int caseNum){
        int nFlavors = in.nextInt();
        int nCustomers = in.nextInt();
        in.nextLine();
        String [] customers = new String[nCustomers];
        int [] melted = new int[nFlavors];
        int flavCount = 0;
        for (int j = 0; j< nFlavors; j++){
            melted[j] = -1;
        }

        for(int j=0;j<nCustomers;j++){
            customers[j] = in.nextLine();
            String [] cusFav = customers[j].split("\\s+");
            int nFlav = Integer.parseInt(cusFav[0]);

            int meltedInd=0;
            boolean notMeltedFound = false;

            for(int k=1; k< nFlav*2;k=k+2){
                int flav = Integer.parseInt(cusFav[k]);
                int melt = Integer.parseInt(cusFav[k+1]);
                if(melted[flav-1]>=0){
                    if(melted[flav-1]!=melt){
                        if(flavCount<=j){
                            System.out.println("Case #"+caseNum+": IMPOSIBBLE");
                            return;
                        }
                    }
                }
                if(melt==1){
                    meltedInd = flav;
                }
                else{
                    melted[flav-1]=0;
                    flavCount++;
                    notMeltedFound = true;
                }
            }
            if(!notMeltedFound){
                melted[meltedInd-1]=1;
                flavCount++;
            }

        }
        System.out.print("Case #"+caseNum+": ");
        for(int j = 0; j < nFlavors ; j++){
            if(melted[j] <= 0 ){
                System.out.print("0");
            }
            else{
                System.out.print("1");
            }
            if(j< nFlavors-1){
                System.out.print(" ");
            }
            else{
                System.out.println();
            }
        }
    }
}

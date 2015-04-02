package com.company;

import java.io.*;

/**
 * Created by atovkun on 4/2/2015.
 */
public class SevenSegmentDisplayFileParser {

    private static String STATE_ZERO = "1111110";
    private static String STATE_ONE = "0110000";
    private static String STATE_TWO = "1101101";
    private static String STATE_THREE = "1111001";
    private static String STATE_FOUR = "0110011";
    private static String STATE_FIVE = "1011011";
    private static String STATE_SIX = "1011111";
    private static String STATE_SEVEN = "1110000";
    private static String STATE_EIGHT = "1111111";
    private static String STATE_NINE = "1111011";
    private static int STATE_LENGTH = 7;

    public static void parseFile(String fileName) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        FileWriter fw = new FileWriter("SevenSegmentDisplay.out");
        if(br!=null){
            int numOfCases = Integer.parseInt(br.readLine());
            for(int i=1;i<=numOfCases;i++){
                String caseStr = br.readLine();
                String caseOutput = parseCase(i,caseStr);
                fw.write(caseOutput);
            }
            fw.close();
        }
    }
    private static String parseCase(int caseNum,String caseString){
        String [] parsedStates = caseString.split("\\s+");
        int numOfStates = Integer.parseInt(parsedStates[0]);
        return null;
    }

    /**
     * Ecaluates if the given state can be the given number
     * @param state
     * @param number
     * @return
     */
    private static boolean eval(String state, int number){

        String numState = getStateForm(number);
        int stateVal=0,stateNumVal=0;
        if(numState.equals(state))
            return true;

        if(numState.length()!=state.length())
            return false;

        for(int i=0; i<STATE_LENGTH;i++){
           stateVal= state.charAt(i) - '0' ;
           stateNumVal = numState.charAt(i) -'0';
            if(stateNumVal==0 &&stateVal==1)
                return false;
        }
        return true;
    }

    private static String getStateForm(int digit){
        switch(digit)
        {
            case 0:
                System.out.println("getStateForm ["+digit+"] ["+STATE_ZERO+"]");
                return STATE_ZERO;
            case 1:
                System.out.println("getStateForm ["+digit+"] ["+STATE_ONE+"]");
                return STATE_ONE;
            case 2:
                System.out.println("getStateForm ["+digit+"] ["+STATE_TWO+"]");
                return STATE_TWO;
            case 3:
               System.out.println("getStateForm ["+digit+"] ["+STATE_THREE+"]");
               return STATE_THREE;
            case 4:
                System.out.println("getStateForm ["+digit+"] ["+STATE_FOUR+"]");
                return STATE_FOUR;
            case 5:
                System.out.println("getStateForm ["+digit+"] ["+STATE_FIVE+"]");
                return STATE_FIVE;
            case 6:
                System.out.println("getStateForm ["+digit+"] ["+STATE_SIX+"]");
                return STATE_SIX;
            case 7:
                System.out.println("getStateForm ["+digit+"] ["+STATE_SEVEN+"]");
                return STATE_SEVEN;
            case 8:
                System.out.println("getStateForm ["+digit+"] ["+STATE_EIGHT+"]");
                return STATE_EIGHT;
            case 9:
                System.out.println("getStateForm ["+digit+"] ["+STATE_NINE+"]");
                return STATE_NINE;

        }
    }
}

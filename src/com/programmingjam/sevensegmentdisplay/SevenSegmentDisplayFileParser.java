package com.programmingjam.sevensegmentdisplay;

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

    private String [] mStatesArray;
    private BufferedReader mBr;
    private FileWriter mFw;

    public void parseFile(String fileName) throws FileNotFoundException, IOException{
        mBr = new BufferedReader(new FileReader(fileName));
        mFw = new FileWriter("SevenSegmentDisplay.out");
        if(mBr!=null){
            int numOfCases = Integer.parseInt(mBr.readLine());
            System.out.println("numOfCases #"+numOfCases);
            for(int i=1;i<=numOfCases;i++){
                String caseStr = mBr.readLine();
                System.out.println("##################################");
                System.out.println("Parsing case number #"+i);
                parseCase(i,caseStr);
            }
            mFw.close();
            mBr.close();
        }
    }
    private void parseCase(int caseNum,String caseString){
        try {
            mStatesArray = caseString.split("\\s+");
            int numOfStates = Integer.parseInt(mStatesArray[0]);
            System.out.println("numOfStates #"+numOfStates);
            System.out.println("mStatesArray.length #" + mStatesArray.length);
            for (int i = 9; i >= 0; i--) {
                System.out.println("Evaluting recursively for  #"+i);
                int [] missingLines = new int[7];
                int [] notMissingLines = new int[7];
                if (evalRecursively(1, mStatesArray, i, numOfStates,missingLines,notMissingLines)) {
                    checkReslt(caseNum, i, numOfStates, missingLines,notMissingLines);
                    return;
                }
            }
            writeError(caseNum);
        }

        catch (IOException e){
            try {
                if (mBr != null)
                    mBr.close();
                if (mFw != null)
                    mFw.close();
            } catch (IOException e2) {
                // This is unrecoverable. Just report it and move on
                e2.printStackTrace();
            }
        }
   }

    private void checkReslt(int caseNum,int firstNum, int statesNum,int [] missingLines,int[]notMissingLines) throws IOException{
        int nextState = firstNum - (statesNum)%10;
        nextState = (nextState<0)?10+nextState:nextState;
        System.out.println("Missing:");
        printMissing(missingLines);
        System.out.println("Not Missing:");
        printMissing(notMissingLines);
        String result =getResult(nextState, missingLines);
            mFw.write("Case #" + caseNum + ": " + result + "\n");
            System.out.println("Case #" + caseNum + ": " + result);
    }

    private static String getResult(int result, int [] missingLines){
        StringBuffer bf = new StringBuffer();
        String resultStr = getStateForm(result);
        for(int i =0;i<STATE_LENGTH;i++){
            if(missingLines[i]==0 &&resultStr.charAt(i)=='1'){
                bf.append('1');
            }
            else {
                bf.append('0');
            }
        }
        return bf.toString();
    }

    private void writeError(int caseNum) throws IOException{
        mFw.write(String.format("Case #%d:  ERROR!\n", caseNum));
        System.out.println("Case #"+caseNum+":  ERROR!");
    }

    private static boolean evalRecursively(int currStatrIndex,String [] statesArr, int currEvalNum, int casesNum,
                                           int [] missingLines,int [] notMissingLines){
        if(casesNum < currStatrIndex)
            return true;
        if(eval(statesArr[currStatrIndex],currEvalNum,missingLines,notMissingLines)){
            currEvalNum=(currEvalNum==0)?9:currEvalNum-1;
            currStatrIndex = currStatrIndex+1;
            return evalRecursively(currStatrIndex, statesArr, currEvalNum, casesNum,missingLines,notMissingLines);
        }
        return false;
    }
    /**
     * Ecaluates if the given state can be the given number
     * @param state
     * @param number
     * @return
     */
    private static boolean eval(String state, int number,int [] missingLines, int [] notMissingLines){

        String numState = getStateForm(number);
        int stateVal=0,stateNumVal=0;
        System.out.println("Eval for state [" + state + "] with [" + number + "] [" + numState + "] and missing");
        printMissing(missingLines);
        System.out.println();
        System.out.println("notMissingLines");
        boolean result = true;
        printMissing(notMissingLines);
        System.out.println();
        if(numState.length()!=state.length())
            return false;

        for(int i=0; i<STATE_LENGTH;i++){
           stateVal= state.charAt(i) - '0' ;
           stateNumVal = numState.charAt(i) -'0';

            if(stateNumVal==1&&stateVal==0){
                if(notMissingLines[i]==1) {
                    return false;
                }
                missingLines[i]=1;
            }
            if(stateNumVal==1&&stateVal==1){
                notMissingLines[i]=1;
            }
            if((stateNumVal==0 &&stateVal==1)||(stateVal==1 &&missingLines[i]==1)|| (notMissingLines[i]==1&&missingLines[i]==1)){
                return false;
            }
        }
        return result;
    }

    private static void printMissing(int [] missing)
    {
        for(int i=0;i<missing.length;i++){
            System.out.print(missing[i]);
        }
        System.out.println();
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
             default:
                return "ERROR";

        }
    }
}

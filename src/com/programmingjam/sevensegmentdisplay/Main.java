package com.programmingjam.sevensegmentdisplay;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SevenSegmentDisplayFileParser p = new SevenSegmentDisplayFileParser();
        try {
            p.parseFile(args[0]);
        }
        catch (FileNotFoundException e){
            System.out.println("File not foud ["+args[0]+"]");
        }
        catch (IOException e) {
            // This is unrecoverable. Just report it and move on
            e.printStackTrace();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

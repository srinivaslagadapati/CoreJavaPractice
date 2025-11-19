package com.lsr.problems;

/*

Write a static class method in Java:

static void parseAndPrintCommands(String input)

That takes a string of user input and parses and prints out the commands in order.

For example, the user input string of:

"deleteLine insertSpace 10 deleteLine 5 deleteCharacter 15 insertSpace"

Should print out:

deleteLine 1
insertSpace 10
deleteLine 5
deleteCharacter 15
insertSpace 1

All commands start with 1 alphabetic character (A-Z, a-z) followed by any number of other non-white space characters.

Each command can optionally take one integer parameter. The default integer parameter is 1. This optional parameter
is the number of times to execute that command (although you only need to output the commands, not execute them).

For now, assume:

Input is completely valid and that the input is trimmed of whitespace on both ends and there will only be
exactly one space inbetween values.

*/


public class Solution {


    public static void main(String[] args) {
        String input = "deleteLine 10 insertSpace 10 deleteLine 5 deleteLine deleteCharacter 15 insertSpace";
        
        parseAndPrintCommands(input);
    }
    
    
    static void parseAndPrintCommands(String input) {
       // input.
       String[] buffer = input.split(" ");
       // System.out.println(buffer);
        
        for (int i=0; i<buffer.length;i++) {
        	//System.out.println(" i is " +i);
	       // if(i%2 == 1 || i==0) {
	        	System.out.print("" +buffer[i]);
	        	try {
	         		System.out.println(" "+Integer.parseInt(buffer[i+1]));
	        		i++;
	        	}catch(Exception e) {
	        		System.out.println(" 1");
	        		//i++;
	        	}
	        //}
        }
        

    }
}

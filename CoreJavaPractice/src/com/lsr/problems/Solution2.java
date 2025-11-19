package com.lsr.problems;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER threshold
     */

    public static List<String> processLogs(List<String> logs, int threshold) {
    // Write your code here
    	//List<String>  reciver_user_id = new ArrayList<>();
    	/*
    	Map<String,Integer> sortedMap = new HashMap<>();
    	List<String>  output = new ArrayList<>();
    	for (String log : logs) {
    		int counter =1;
			String[] splitLog = log.split(" ");
			if (splitLog.length < 3) {
                continue; // Skip malformed logs
            }
			if(sortedMap.containsKey(splitLog[0])) {
				counter= sortedMap.get(splitLog[0])+1;
			}
			sortedMap.put(splitLog[0], counter);
			if(splitLog.length >1 && splitLog[0] != splitLog[1] ) {
				if(sortedMap.containsKey(splitLog[1])) {
					counter= sortedMap.get(splitLog[1])+1;
				}
				sortedMap.put(splitLog[1], counter);
			}
		}
    	for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			Integer val = entry.getValue();
			if (val >= threshold)
				System.out.println(entry.getKey());
				System.out.println(val);
				System.out.println(threshold);
				output.add(entry.getKey());
		}    	
    	System.out.println("sortedMap  "+sortedMap);
        Collections.sort(output, Comparator.comparingInt(Integer::parseInt));

    	System.out.println("output  "+output);
    	
    	return output;
    	*/
    	 // Map to count transactions for each user
        Map<String, Integer> transactionCount = new HashMap<String, Integer>();

        for (String log : logs) {
            String[] parts = log.split(" ");
            // Check if we have the expected number of parts
            if (parts.length < 3) {
                continue; // Skip malformed logs
            }

            String sender = parts[0];
            String recipient = parts[1];

            // Increment transaction count for sender
            transactionCount.put(sender, transactionCount.containsKey(sender) ? transactionCount.get(sender) + 1 : 1);
            // Increment transaction count for recipient (if different from sender)
            if (!sender.equals(recipient)) {
                transactionCount.put(recipient, transactionCount.containsKey(recipient) ? transactionCount.get(recipient) + 1 : 1);
            }
        }

        // List to store user IDs that exceed the threshold
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : transactionCount.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }

        // Sort the result in ascending order
        Collections.sort(result, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });

        return result;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
    	List<String> logs = new ArrayList<>();
    	logs.add("4");
    	logs.add("1 2 50");
    	logs.add("1 7 70");
    	logs.add("1 3 20");
    	logs.add("2 3 17");
    	logs.add("2");
    	Result.processLogs(logs, 2);
    }
}

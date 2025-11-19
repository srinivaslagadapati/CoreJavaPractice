package assesment;

import java.util.ArrayList;
import java.util.List;

public class generateParanthesisSolution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        System.out.println(" from main backtrack");
        backtrack(result, "", 0, 0, n, false);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int n, boolean isRecursive) {
    	
    	System.out.println(" backtrack Start: "+" open: "+open +" close: "+close +" n. "+n ); 
    	
    	// If the current string has used n opening and n closing parentheses
        if (current.length() == 2 * n) {
        	addToResult(result, current, open, close, n, isRecursive);
        }
        checkAndAddString(result, current, open, close, n);
        System.out.println("backtrack end: "+" open: "+open +" close: "+close +" n. "+n  ); 
    }

	private void checkAndAddString(List<String> result, String current, int open, int close, int n) {
		System.out.println(" checkAndAddString "+" current: "+current +" open: "+open +" close: "+close);
		// Add an opening parenthesis if we have not used n opening parentheses
        if (open < n) {
        	System.out.println("call backtrack add (" );
            backtrack(result, current + "(", open + 1, close, n, true);
        }
        
        // Add a closing parenthesis if the number of closing parentheses used is less than opening
        if (close < open) {
        	System.out.println("call backtrack add )" );
            backtrack(result, current + ")", open, close + 1, n, true);
        }
        System.out.println(" checkAndAddString end");
	}

	private void addToResult(List<String> result, String current, int open, int close, int n, boolean isRecursive) {
		result.add(current);
		System.out.println("addToResult: "+result+ 
				" current: "+current +" open: "+open +" close: "+close +" n.. "+n+ isRecursive);
	}
    
    public static void main(String[] args) {
    	generateParanthesisSolution solution = new generateParanthesisSolution();
        int n = 1;
        List<String> result = solution.generateParenthesis(n);
        System.out.println(result); // ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }
}

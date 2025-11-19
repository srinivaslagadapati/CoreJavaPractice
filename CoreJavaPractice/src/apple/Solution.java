package apple;
import java.util.*;

public class Solution {
  public static void main(String[] argv) {

    char[][] matrix1 = {
      {'W','W','W','W'},
      {'B','W','W','W'},
      {'B','W','B','B'},
      {'W','W','B','W'},
      {'B','B','W','W'}
    };

    int[][] rows1_1 = {{},{1},{1,2},{1},{2}};
    int[][] columns1_1 = {{2,1},{1},{2},{1}};

    System.out.println(verifyMatrix(matrix1, rows1_1, columns1_1)); // should print true
  }
  
  static boolean verifyMatrix(char[][] matrix, int[][] rows, int[][] columns) {
	  
	  System.out.println(" matrix row  "+matrix.length);
	  System.out.println(" matrix col  "+matrix[0].length);
	  
      int m = matrix.length;
      int n = matrix[0].length;
      for(int row=0; row< matrix.length;row++) {
    	  System.out.println(" row "+row );
    	  int counter=0;
    	  for(char c : matrix[row]) {
    		 
    		  if(c == 'B') {
    			  counter++;
    		  }
    	  }
    	 
    	  int bVal=0;
    	  for(int i : rows[row]) {
    		  bVal+= i;
    	  }
    	  System.out.println(" B "+counter );
    	  System.out.println(" bVal "+bVal );
    	  if(counter != bVal) return false;
    	  
    	 
    	  System.out.println(" --- " );
    	  
      }
      
      for(int i=0; i< n;i++) {
    	  char[] col = new char[m];
    	  for(int j=0; j< m;j++) {
    		  col[j] = matrix[j][i];
    	  }
    	  int counter=0;
		  for(char c: col) {
			 // System.out.println("col..."+ c);
			  if(c == 'B') {
    			  counter++;
    		  }
		  }
		  System.out.println("counter of B in col..."+ counter);
		  
		  int bVal=0;
    	  for(int k : columns[i]) {
    		  bVal+= k;
    	  }
    	  System.out.println(" bVal in col "+bVal );
    	  if(counter != bVal) return false;
      }

      // Validate rows
      for (int i = 0; i < m; i++) {
          List<Integer> actual = getGroups(matrix[i]);
          if (!matches(actual, rows[i])) {
              System.out.println("Row " + i + " mismatch: expected " + Arrays.toString(rows[i]) + " got " + actual);
              return false;
          }
      }

      // Validate columns
      for (int j = 0; j < n; j++) {
          char[] col = new char[m];
          for (int i = 0; i < m; i++) col[i] = matrix[i][j];
          List<Integer> actual = getGroups(col);
          if (!matches(actual, columns[j])) {
              System.out.println("Column " + j + " mismatch: expected " + Arrays.toString(columns[j]) + " got " + actual);
              return false;
          }
      }

      return true;
  }

  // Extract consecutive 'B' group lengths from a row or column
  static List<Integer> getGroups(char[] arr) {
      List<Integer> groups = new ArrayList<>();
      int count = 0;
      for (char c : arr) {
          if (c == 'B') count++;
          else {
              if (count > 0) groups.add(count);
              count = 0;
          }
      }
      if (count > 0) groups.add(count);
      return groups;
  }

  // Compare actual vs expected sequence
  static boolean matches(List<Integer> actual, int[] expected) {
      if (actual.size() != expected.length) return false;
      for (int i = 0; i < expected.length; i++) {
          if (actual.get(i) != expected[i]) return false;
      }
      return true;
  }
}

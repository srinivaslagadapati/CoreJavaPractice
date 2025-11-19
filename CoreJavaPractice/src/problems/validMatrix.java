package problems;

public class validMatrix {
	
	static boolean verifyMatrix(int[][] matrix){
	    
	    boolean isValid =true;
	    int n = matrix.length;
	    for (int r=0;r<n;r++){
	      boolean[] seenRow = new boolean[n+1];
	        for (int col=0;col<n;col++){
	          int value = matrix[r][col];
	          
	          if(value<1 || value >n){return false;}
	          if(seenRow[value]){
	            return false;
	          }
	          seenRow[value] = true;
	        }      
	    }
	    
	   for (int col=0;col<n;col++){
	     boolean[] seenInCol = new boolean[n+1];
	      for (int row=0;row<n;row++){
	        int value = matrix[row][col];
	         if(value<1 || value >n){return false;}
	          if(seenInCol[value]){
	            return false;
	          }
	          seenInCol[value] = true;
	      }
	   }
	    
	    return isValid;
	  }

}

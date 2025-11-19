package problems;
import java.util.*;

/*
 * Click `Run` to execute the snippet below!


# 10  | 11 |  12 | 13
#—————————
#14 | 16 | 15 | 17 
#—————————
#18  | 19 | 20 | 21


# Sum = 31

example: (0,0#2,3)


 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Main {
  public static void main(String[] args) {
    // System.out.println("Hello");
     List<String> strings = Arrays.asList(
      "10 11 12 13",
      "14 16 15 17",
      "18 19 20 21"
     );
    findpairofSum(strings,31);
  }
  static void findpairofSum(List<String> input,int target){
      int rows = input.size();
      int cols = input.get(0).split("\\s+").length;
      int[][] arr = new int[rows][cols];
      for(int i=0; i<rows;i++){
        String[] parts = input.get(i).trim().split("\\s+");
        for(int j=0; j<cols;j++){
          arr[i][j] = Integer.parseInt(parts[j]);
        }
      }
          //System.out.println(strings);
      Map<Integer,List<int[]>> map = new HashMap<>();
      for (int r=0;r<rows;r++){
        for (int c=0;c<rows;c++){
          int value = arr[r][c];
          int complement = target-value;
          if(map.containsKey(complement)){
            for (int[] coord : map.get(complement)){
              System.out.print("("+coord[0]+" , "+coord[1]+") ->"+complement );
               System.out.println(" ( "+r+" , "+c+") ->"+value+" = "+target);
            }
          }
          map.computeIfAbsent(value, k->new ArrayList<>()).add(new int[]{r,c});
        }

      }
  }
}



// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!
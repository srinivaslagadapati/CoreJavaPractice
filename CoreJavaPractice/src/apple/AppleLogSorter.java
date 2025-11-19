package apple;

import java.util.*;

class AppleLogSorter {
    public static List<String> reorderLogs(List<String> logs) {
        Comparator<String> comp = (log1, log2) -> {
            System.out.println(log1);
            System.out.println(log2);

            String[] s1 = log1.split(" ", 2);
            String[] s2 = log2.split(" ", 2);
            System.out.println(s1[1].charAt(0));
            System.out.println(s2[1].charAt(0));
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
            System.out.println(isDigit1);
            System.out.println(isDigit2);
            if (!isDigit1 && !isDigit2) {
                int cmp = s1[1].compareTo(s2[1]);
                if (cmp != 0) return cmp;
                return s1[0].compareTo(s2[0]);
            }
         int  digit = isDigit1 ? (isDigit2 ? 0 : 1) : -1;
         System.out.println(digit);

            return digit;
        };

        logs.sort(comp);
        System.out.println(logs);
        return logs;
    }
    
    public static void main (String[] args){
    	List<String> logs = new ArrayList<String>();
    	// Input: ["a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"]

    	logs.add("a1 9 2 3 1");
    	logs.add("g1 act car");
    	logs.add("zo4 4 7");
    	logs.add("ab1 off key dog");
    	logs.add("a8 act zoo");
    	reorderLogs(logs);
    }
}

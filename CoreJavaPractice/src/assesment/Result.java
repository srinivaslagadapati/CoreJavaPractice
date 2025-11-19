package assesment;
import java.util.ArrayList;
import java.util.List;
public class Result {
	

	    public static String getMinimumString(String s_id) {
	        System.out.println("s_id "+s_id);

	        List<Integer> digits = new ArrayList<>();
	        for (char c : s_id.toCharArray()) {
	            digits.add(c - '0');
	        }
	        
	        StringBuilder result = new StringBuilder();
	        
	        while (!digits.isEmpty()) {
	        	System.out.println("digits "+digits);
	            int minIndex = 0;
	            int minValue = digits.get(0);
	            for (int i = 0; i < digits.size(); i++) {
	            	 System.out.println("digits[i] "+digits.get(i) + " minValue "+ minValue);
	                if (digits.get(i) < minValue) {
	                    minValue = digits.get(i);
	                    minIndex = i;
	                    System.out.println("minValue "+minValue);
	                    System.out.println("minIndex "+minIndex);
	                }
	            }
	            
	            result.append(minValue);
	            System.out.println("result append "+result);
	            // Increase all digits before minIndex
	            for (int i = 0; i < minIndex; i++) {
	            	 System.out.println(" digits.set at  "+i+" Math.min(digits.get(i)"+Math.min(digits.get(i)+ 1, 9));
	                digits.set(i, Math.min(digits.get(i) + 1, 9));
	            }
	            System.out.println("remove minIndex "+minIndex);
	            digits.remove(minIndex);
	        }
	        System.out.println("result toString "+result);
	        return result.toString();
	    }
    public static void main(String[] args) {
        System.out.println(getMinimumString("34892")); // Expected Output: "02599"
    }
}




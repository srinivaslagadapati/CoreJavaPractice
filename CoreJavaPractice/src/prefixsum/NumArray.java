package prefixsum;

class NumArray {
    private int[] nums ;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int sum =0;
        for(int i=0; i<nums.length;i++ ){
            if (i >= left && i <= right){
                sum += nums[i];
            }
        }
         System.out.println("sum "+ sum);
        return sum;
    }
    public static void main(String[] args) {
    	int[] nums = {-2, 0, 3, -5, 2, -1};
    	NumArray numArray = new NumArray(nums);
    	numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
    	numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
    	numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    	
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 * 
 * Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

 */

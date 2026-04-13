class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                min= Math.min(min,Math.abs(i-start));
            }
        }
        
        return min;
    }
}

//Optimal Solution 

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        
        for (int d = 0; d < n; d++) {
            // check left
            if (start - d >= 0 && nums[start - d] == target) {
                return d;
            }
            
            // check right
            if (start + d < n && nums[start + d] == target) {
                return d;
            }
        }
        
        return -1; // just in case (though problem guarantees existence)
    }
}
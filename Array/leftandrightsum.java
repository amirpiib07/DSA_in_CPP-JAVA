class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] left= new int[n];
        int[] right= new int[n];
        
        for(int j=1; j<n; j++){
            left[j]=left[j-1]+nums[j-1];
        }
        
        for(int j=n-2; j>=0; j--){
            right[j]=right[j+1]+nums[j+1];
        }
        
        for(int j=0; j<n; j++){
            right[j]=Math.abs(right[j]-left[j]);
        }
        
        return right;
    }
}
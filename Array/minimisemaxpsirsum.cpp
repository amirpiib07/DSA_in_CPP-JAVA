class Solution {
    public int minPairSum(int[] nums) {
        int MaxSum=0;
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int sum=nums[i]+nums[j];
            MaxSum=Math.max(MaxSum,sum);
            i++;
            j--;
        }
        return MaxSum;
    }
}
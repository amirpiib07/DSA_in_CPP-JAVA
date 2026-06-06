class Solution {
    public int fi(int[] nums, int target) {
        int ans=-1;
        int m=0, n=nums.length-1;
        while(n>=m){
            int mid=m+(n-m)/2;
            if(nums[mid]==target) {
                ans=mid;
                n=mid-1;
            }
            else if(nums[mid]>target) n=mid-1;
            else m=mid+1;
        }
        return ans;

    }

    public int fj(int[] nums, int target) {
        int ans=-1;
        int m=0, n=nums.length-1;
        while(n>=m){
            int mid=m+(n-m)/2;
            if(nums[mid]==target) {
                ans=mid;
                m=mid+1;
            }
            else if(nums[mid]>target) n=mid-1;
            else m=mid+1;
        }
        return ans;
        

    }

    public int[] searchRange(int[] nums, int target) {
        int[] f = new int[2];
        int i = fi(nums, target);
        int j = fj(nums, target);
        f[0] = i;
        f[1] = j;
        return f;

    }
}
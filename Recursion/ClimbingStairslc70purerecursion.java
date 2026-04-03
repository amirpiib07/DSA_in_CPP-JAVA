class Solution {
    public int ans(int n){
        if(n == 0 || n == 1) return 1;
        return ans(n-1) + ans(n-2);
    }

    public int climbStairs(int n) {
        return ans(n);
    }
}
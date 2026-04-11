class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 
            && (n & (n - 1)) == 0   // power of 2
            && (n & 0x55555555) != 0; // even position bit
    }
}
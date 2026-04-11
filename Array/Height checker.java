class Solution {
    public int heightChecker(int[] heights) {
        int[] count = new int[101]; // heights range [1,100]

        // Step 1: Count frequency
        for (int h : heights) {
            count[h]++;
        }

        int i = 0;
        int mismatch = 0;

        // Step 2: Simulate sorted order
        for (int h = 1; h <= 100; h++) {
            while (count[h] > 0) {
                if (heights[i] != h) {
                    mismatch++;
                }
                i++;
                count[h]--;
            }
        }

        return mismatch;
    }
}
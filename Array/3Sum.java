class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the fixed element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Early termination: smallest possible sum > 0
            if (nums[i] > 0) break;

            int lo = i + 1, hi = n - 1;
            int target = -nums[i];

            while (lo < hi) {
                int sum = nums[lo] + nums[hi];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                    // Skip duplicates for lo
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    // Skip duplicates for hi
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;

                    lo++;
                    hi--;
                } else if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }

        return result;
    }
}
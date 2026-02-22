public boolean check(int[] nums, int mid, int k) {
        int count = 1;
        int currSum = 0;
        for (int ele : nums) {
            if (currSum + ele > mid) {
                count++;
                currSum = ele;
            } else
                currSum += ele;
        }
        return count <= k;
    }

    public int splitArray(int[] nums, int k) {
        int hi = 0;
        int lo = 0;
        for (int ele : nums) {
            hi += ele;
            lo = Math.max(ele, lo);
        }
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(nums, mid, k)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;

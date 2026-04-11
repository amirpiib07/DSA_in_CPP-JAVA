class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return f(nums, 0);
    }

    public List<List<Integer>> f(int[] nums, int i) {
        List<List<Integer>> res = new ArrayList<>();

        // base case
        if (i == nums.length) {
            res.add(new ArrayList<>()); // empty subset
            return res;
        }

        // get subsets from next index
        List<List<Integer>> smallAns = f(nums, i + 1);

        for (List<Integer> list : smallAns) {
            // skip case
            res.add(new ArrayList<>(list));

            // pick case
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            res.add(newList);
        }

        return res;
    }
}
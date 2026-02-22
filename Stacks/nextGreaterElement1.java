public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int[] ans1 = new int[nums2.length];
        int idx = nums2.length - 1;
        Stack<Integer> st = new Stack<>();

        while (idx >= 0) {

            while (st.size() > 0 && st.peek() < nums2[idx])
                st.pop();
            if (st.size() == 0)
                ans1[idx] = -1;
            else if (st.peek() > nums2[idx])
                ans1[idx] = st.peek();
            st.push(nums2[idx]);
            idx--;

        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], ans1[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i]))
                ans[i] = map.get(nums1[i]);
        }

        return ans;

    }

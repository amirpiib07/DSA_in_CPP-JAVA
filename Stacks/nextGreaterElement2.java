public int[] nextGreaterElements(int[] nums) {
        int[] ans= new int[nums.length];
        Stack<Integer> st= new Stack<>();
        int i=nums.length-1;
        while(i>=0){
            st.push(nums[i--]);
        }
        i=nums.length-1;
        while(i>=0){
            while(st.size()>0 && st.peek()<=nums[i]) st.pop();
            if(st.size()==0){
                st.push(nums[i]);
                ans[i]=-1;
            }
            else if(st.peek()>nums[i]){
                ans[i]=st.peek();
                st.push(nums[i]);
            }
            i--;
        }
        return ans;
    }

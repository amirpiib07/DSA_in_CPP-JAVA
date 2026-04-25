class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        int n= heights.size();vector<int> ans(n);
        ans[n-1]=0;
        stack<int> st;
        st.push(n-1);
        for(int j=n-2;j>=0;j--){
            int count=0;
            while(!st.empty() && heights[st.top()]<heights[j]){
                st.pop();
                count++;
            }
            ans[j]=count+(st.empty()?0:1);
            count=0;
            st.push(j);
        }
        return ans;
    }
};
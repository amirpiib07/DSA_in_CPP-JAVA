class Solution {
public:
    int largestRectangleArea(vector<int>& h) {
        int n=h.size();
      
        stack<int> st;
        int ans=0;
        for(int j=0;j<=n;j++){
            int currH=(j==n)?0:h[j];
            while(!st.empty() && h[st.top()]>currH){
                int height=h[st.top()];
                st.pop();
                int width=st.empty()?j:j-st.top()-1;
                ans=max(ans,height*width);
            }
            st.push(j);
        }
        return ans;
    }
};
//T.C=O(n^2)  S.C=O(1)
class Solution {
public:
    int tz(vector<int>& row){
        int n=row.size();
        int cnt=0;
        for(int j=n-1;j>=0;j--){
            if(row[j]==0) cnt++;
            else break;
        }
        return cnt;
    }
    int minSwaps(vector<vector<int>>& grid) {
        int n=grid.size();
        int swaps=0;
        for(int i=0;i<n;i++){
            int need=n-i-1;
            int j=i;
            while(j<n&&tz(grid[j])<need) j++;
            if(j==n) return -1;
            while(j>i){
                swap(grid[j],grid[j-1]);
                swaps++;
                j--;
            }
        }
        return swaps;
    }
};

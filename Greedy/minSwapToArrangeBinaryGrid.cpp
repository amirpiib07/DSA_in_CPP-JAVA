//T.C=O(n^2), S.C=O(n)
//LC 1536
class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<int> tz(n);
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0)
                    count++;
                else
                    break;
            }
            tz[i] = count;
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int need = n - i - 1;
            int j = i;
            while (j < n && tz[j] < need)
                j++;
            if (j == n)
                return -1;
            while (j > i) {
                swap(tz[j], tz[j - 1]);
                j--;
                swaps++;
            }
        }
        return swaps;
    }
};

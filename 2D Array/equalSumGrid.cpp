class Solution {
public:
    bool canPartitionGrid(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();

        // Use long long -- values up to 10^5 * 10^5 = 10^10, overflows int
        vector<long long> row_sum(m, 0), col_sum(n, 0);

        long long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row_sum[i] += grid[i][j];
                col_sum[j] += grid[i][j];
                total     += grid[i][j];
            }
        }

        if (total % 2 != 0) return false;
        long long target = total / 2;

        // Check horizontal cuts (between rows)
        long long prefix = 0;
        for (int i = 0; i < m - 1; i++) {   // stop before last row
            prefix += row_sum[i];
            if (prefix == target) return true;
        }

        // Check vertical cuts (between columns)
        prefix = 0;
        for (int j = 0; j < n - 1; j++) {   // stop before last column
            prefix += col_sum[j];
            if (prefix == target) return true;
        }

        return false;
    }
};

class Solution {
public:
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        int count = 4;
        
        while (count--) {
            for (int i = 0; i < mat.size(); i++) {
                for (int j = 0; j < i; j++) {
                    swap(mat[i][j], mat[j][i]);
                }
            }

            for (int i = 0; i < mat.size(); i++) {
                int m = 0, n = mat[0].size() - 1;
                while (m < n) {
                    swap(mat[i][m], mat[i][n]);
                    m++;
                    n--;
                }
            }

            bool same = true;
            for (int i = 0; i < mat.size(); i++) {
                for (int j = 0; j < mat[0].size(); j++) {
                    if (mat[i][j] != target[i][j]) {
                        same = false;
                        break;
                    }
                }
                if (!same) break;
            }

            if (same) return true;
        }

        return false;
    }
};

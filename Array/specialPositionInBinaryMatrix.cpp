//TC=O(m*n) SC=O(1)
//LC 1582

class Solution {
public:
    int numSpecial(vector<vector<int>>& mat) {
        int ans=0;
        for(int i=0;i<mat.size();i++){
            int found=0;
            int key=0;
            int c=0;
            for(int j=0;j<mat[0].size();j++){
                if(mat[i][j]==1){
                    found=1;
                    c=j;
                }
                if(found==1) key++;
                found=0;
                
            }
            if(key==1){
                int f=0;
                int ky=0;
                for(int k=0;k<mat.size();k++){
                    if(mat[k][c]==1){
                        f=1;
                    }
                    if (f==1) ky++;
                    f=0;
                }
                if(ky==1) ans++;
            }
        }
        return ans;
    }
};

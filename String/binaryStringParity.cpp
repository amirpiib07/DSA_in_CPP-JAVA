//minimum changes to make to make alternating string
class Solution {
public:
    int minOperations(string s) {
        int c0 = 0, c1 = 0;

        for(int i = 0; i < s.size(); i++){
            if(s[i] != (i % 2 + '0')) c0++;
            if(s[i] != ((i + 1) % 2 + '0')) c1++;
        }

        return min(c0, c1);
    }
};

class Solution {
public:
    int solve(string s, bool help){
        int ans = 0;
        int i = 0;

        while(i < s.size()){
            if(help == false && s[i] == '1'){
                ans++;
                help = true;
            }
            else if(help == true && s[i] == '0'){
                ans++;
                help = false;
            }
            else if(help == false && s[i] == '0'){
                help = true;
            }
            else if(help == true && s[i] == '1'){
                help = false;
            }
            i++;
        }
        return ans;
    }

    int minOperations(string s) {
        int a = solve(s, false); // assume start with '0'
        int b = solve(s, true);  // assume start with '1'
        return min(a, b);
    }
};

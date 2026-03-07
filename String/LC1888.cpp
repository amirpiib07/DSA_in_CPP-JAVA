class Solution {
public:
    int minFlips(string s) {
        int n = s.size();
        string t = s + s;
        int d1 = 0, d2 = 0;
        int ans = INT_MAX;
        for (int i = 0; i < t.size(); i++) {
            char p1 = (i % 2) ? '1' : '0';
            char p2 = (i % 2) ? '0' : '1';
            if (t[i] != p1)
                d1++;
            if (t[i] != p2)
                d2++;
            if (i >= n) {
                char rp1 = ((i - n) % 2) ? '1' : '0';
                char rp2 = ((i - n) % 2) ? '0' : '1';
                if (t[i - n] != rp1)
                    d1--;
                if (t[i - n] != rp2)
                    d2--;
            }
            if (i >= n - 1)
                ans = min(ans, min(d1, d2));
        }
        return ans;
    }
};

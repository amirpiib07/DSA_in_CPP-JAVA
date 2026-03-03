//T.C=O(n)
//S.C=O(1)
class Solution {
public:
    char findKthBit(int n, int k) {
        bool invert = false;

        while (n > 1) {
            int len = (1 << n) - 1;
            int mid = (len / 2) + 1;

            if (k == mid) {
                return invert ? '0' : '1';
            }

            if (k > mid) {
                k = len - k + 1;   // mirror
                invert = !invert;  // flip state
            }

            n--;
        }

        // Base case S1 = "0"
        return invert ? '1' : '0';
    }
};

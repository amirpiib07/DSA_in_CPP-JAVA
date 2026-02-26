// LC 1404- number of steps to represents the binary to one 
// T.C= O(n^2)

class Solution {
    public int numSteps(String s) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() != 1) {
            if (sb.charAt(sb.length() - 1) == '1') {
                StringBuilder help = new StringBuilder("");
                int i = sb.length() - 1;
                int carry = 1;
                while (i >= 0) {
                    int ch = ((sb.charAt(i) - '0' + carry) % 2);
                    carry = (sb.charAt(i) - '0' + carry) / 2;
                    help.append(ch);
                    i--;
                }
                if (carry == 1)
                    help.append(carry);
                help.reverse();
                sb.replace(0, sb.length(), help.toString());
                ans++;
            } else {
                StringBuilder help = new StringBuilder("");

                sb.replace(0, sb.length(), sb.substring(0, sb.length() - 1).toString());
                ans++;
            }
        }
        return ans;
    }
}

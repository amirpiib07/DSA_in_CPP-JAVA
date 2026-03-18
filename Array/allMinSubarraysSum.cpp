class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        const int MOD = 1e9 + 7;
        int n = arr.size();

        // prev_less[i] = index of nearest element strictly less than arr[i] on left
        // -1 if none
        vector<int> prev_less(n), next_less_eq(n);

        // --- Compute prev_less using monotonic stack (increasing) ---
        stack<int> st;
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] >= arr[i])
                st.pop();
            prev_less[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }

        // --- Compute next_less_eq using monotonic stack ---
        while (!st.empty()) st.pop();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] > arr[i])  // strictly greater
                st.pop();
            next_less_eq[i] = st.empty() ? n : st.top();
            st.push(i);
        }

        // --- Compute answer ---
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            long long L = i - prev_less[i];       // subarrays ending at i
            long long R = next_less_eq[i] - i;    // subarrays starting at i
            ans = (ans + (long long)arr[i] % MOD * L % MOD * R % MOD) % MOD;
        }

        return (int)ans;
    }
};

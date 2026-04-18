class Solution {
public:
    int partition(vector<int>& nums, int low, int high) {
        int pivot = nums[high]; // take last element
        int i = low;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                swap(nums[i], nums[j]);
                i++;
            }
        }

        swap(nums[i], nums[high]); // place pivot correctly
        return i;                  // pivot index
    }

    int quickSelect(vector<int>& nums, int low, int high, int k) {
        int pivotIndex = partition(nums, low, high);

        if (pivotIndex == k)
            return nums[pivotIndex];

        else if (pivotIndex < k)
            return quickSelect(nums, pivotIndex + 1, high, k);

        else
            return quickSelect(nums, low, pivotIndex - 1, k);
    }

    int findKthLargest(vector<int>& nums, int k) {
        int n = nums.size();
        int target = n - k; // convert to kth smallest index
        return quickSelect(nums, 0, n - 1, target);
    }
};



// STL method
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        nth_element(nums.begin(), nums.end() - k, nums.end());
        return nums[nums.size() - k];
    }
};

//DS method
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        multiset<int> st;

        for (int x : nums) {
            st.insert(x);
            if (st.size() > k) {
                st.erase(st.begin());  // remove smallest
            }
        }

        return *st.begin();
    }
};

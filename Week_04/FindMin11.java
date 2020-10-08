class Solution {
    public int findMin(int[] nums) {
        if (1 == nums.length) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1, first = nums[0], last = nums[r];
        if (first < last) {
            return first;
        }
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= first && nums[mid] > last) {
                l = mid + 1;
            } else if (nums[mid] <= first && nums[mid] < last) {
                r = mid;
            } 
        }
        return nums[l];
    }
}
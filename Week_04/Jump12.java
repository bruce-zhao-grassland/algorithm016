class Solution {
    public int jump(int[] nums) {
        int maxPos = 0, end = 0, steps = 0;
        for (int i = 0, len = nums.length; i < len - 1; ++i) {
            if (maxPos < i + nums[i]) {
                maxPos = i + nums[i];
            }
            if (i == end) {
                end = maxPos;
                steps++;
                if (end > len - 2) {
                    break;
                }
            }
        }
        return steps;
    }
}
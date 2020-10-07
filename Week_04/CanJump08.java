class Solution {
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        boolean canJump = false;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (i > rightMost) {
                break;
            } else if (rightMost < i + nums[i]) {
                rightMost = i + nums[i];
            }
           
            if (rightMost >= len - 1) {
                canJump = true;
                break;
            }
        }
        return canJump;
    }
}
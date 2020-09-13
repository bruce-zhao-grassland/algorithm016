class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        if (0 == (k %= nums.length)) {
            return; 
        }
        int count = 0;
		// 每个元素移动一次，共移动 num.length次
        for(int i = 0; count < nums.length; i++) {
            int current = i;
            int prev = nums[current];
            do {
                current = (current + k) % nums.length;
                int temp = nums[current];
                nums[current] = prev;
                prev = temp;
                count++;
            } while (current != i);
        }
    }
}
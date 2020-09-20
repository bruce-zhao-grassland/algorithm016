class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        valueIndexMap.put(nums[0], 0);
		// 没有匹配上就存起来，直到遍历完数组
        for (int i = 1; i < nums.length; i++) {
            int gap = target - nums[i];
            Integer index = valueIndexMap.get(gap);
            if (index == null) {
                valueIndexMap.put(nums[i], i);
            } else {
                return new int[]{index, i};
            }
        }
        return new int[0];
    }
}
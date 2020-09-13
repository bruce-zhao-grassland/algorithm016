class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        valueIndexMap.put(nums[0], 0);
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
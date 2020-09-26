/**
 * 数学中的全排列
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<List<Integer>> res = new ArrayList<>();
        if (0 == len) {
            return res;
        }
        List<Integer> list = new ArrayList<>(len);
        if (1 == len) {
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        traverseBack(nums, 0, used, res, list);
        return res;
    }

    private void traverseBack(int[] nums, int level, boolean[] used, List<List<Integer>> res, List<Integer> list) {
        if (level == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            } 
            used[i] = true;
            list.add(nums[i]);
            traverseBack(nums, level+1, used, res, list);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}
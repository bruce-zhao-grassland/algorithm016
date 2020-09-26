/**
 * 全排列的变种
 * 首先排序数字，这里按从小到大的顺序
 * 对于相同的数字，比如，1,1需要前面的一个1先被用掉，后面的1才能使用
 * 因为对于1来说，在全排列中没有差别，所以，就按照一个顺序来使用就可以了
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == nums || 0 == nums.length) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        if (1 == nums.length) {
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (0 != i && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size()-1);
        }
    } 
}
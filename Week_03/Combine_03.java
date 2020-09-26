/**
 * 数学中的组合，用过的元素不可再用，即只会向后走，不会向前走
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (1 == k) {
            for (int i = 1; i <= n; ++i) {
                res.add(Arrays.asList(i));
            }
            return res;
        }
        if (k == n) {
            List<Integer> l = new ArrayList<>(n);
            for (int i = 1; i <= n; ++i) {
                l.add(i);
            }
            res.add(l);
            return res;
        }
        List<Integer> list = new ArrayList<>(k);
        dfs(1, n, k, 0, res, list);
        return res;
    }

    private void dfs(int start, int n, int k, int level, List<List<Integer>> res, List<Integer> list) {
        if (k == level) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; ++i) {
            list.add(i);
            dfs(i+1, n, k, level+1, res, list);
            list.remove(list.size()-1);
        }
    }
}
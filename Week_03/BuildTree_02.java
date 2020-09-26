/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 这题和知道中序遍历，求后序遍历，本质上是一样的
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (0 == len) {
            return null;
        }
		// 放置中序遍历的元素及其数组索引，可以以O(1)的时间在中序中查找到根元素所在位置
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; ++i) {
            map.put(inorder[i], i);
        }
        return dfsBuildTree(preorder, 0, len-1, inorder, 0, len-1, map);
    }

    private TreeNode dfsBuildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe || is > ie) {
            return null;
        } 
        int target = preorder[ps];
        int ir = map.get(target);
		// 构建本级根元素
        TreeNode root = new TreeNode(target);
        root.left = dfsBuildTree(preorder, ps+1, ps+ir-is, inorder, is, ir-1, map);
        root.right = dfsBuildTree(preorder, ps+ir-is+1, pe, inorder, ir+1, ie, map);
        return root;
    }
}
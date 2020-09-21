/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	/**
	 * 前序遍历
	 * 和中序遍历很相似
	 * 先把父节点值放入列表，再递归左右子树
	 */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }

    private void help(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        res.add(root.val);
        help(root.left, res);
        help(root.right, res);
    }
}
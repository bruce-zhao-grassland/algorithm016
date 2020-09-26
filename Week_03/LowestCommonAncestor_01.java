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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 递归退出条件，为null的时候，或者就是p与q
        if (null == root || root == p || root == q) {
            return root;
        }
		// 看下左右字节点是否可以获取非null
		// 为null，表明不在root这个分支上
		// left和right都不为null，说明root是最近祖先，
		// 有一个为null，说明p，q在一边，返回这个非null即可
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (null == left) {
            return right;
        } else if (null == right) {
            return left;
        } else {
            return root;
        }
    }
}
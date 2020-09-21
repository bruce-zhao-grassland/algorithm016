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
     * Morris，O(1)空间复杂度，O(n)时间复杂度
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        TreeNode predecessor = null;
        while (null != root) {
            if (null != root.left) {
                predecessor = root.left;
                // 找到最右边的节点
                while (null != predecessor.right && root != predecessor.right) {
                    predecessor = predecessor.right;
                }
                // 最右边节点的右节点设置为 root，指回去
                if (null == predecessor.right) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    sortedList.add(root.val);
                    // 把之前右子树指向的删掉
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                sortedList.add(root.val);
                root = root.right;
            }
        }
        return sortedList;
    }

    /**
     * 递归法中序遍历二叉树
	 * 1. 处理退出条件
	 * 2. 处理本层逻辑
	 * 3. drill down
	 * 4. reverse 本层状态
	 * TIPs：使用递归实现简单
	 * O(n)空间复杂度，O(n)时间复杂度
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        help(root, sortedList);
        return sortedList;
    }

    private void help(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        help(root.left, res);
        res.add(root.val);
        help(root.right, res);
    }

    /**
     * 用栈实现中序遍历二叉树
	 * O(n)空间复杂度，O(n)时间复杂度
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (null != cur || !stack.empty()) {
            while(null != cur) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            sortedList.add(cur.val);
            cur = cur.right;
        }
        return sortedList;
    }
}
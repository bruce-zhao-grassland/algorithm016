/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }
	// 二叉树，适合递归，处理本节点，然后处理子节点
    private void dfs(Node root, List<Integer> list) {
        if (null == root) {
            return;
        }
        list.add(root.val);
        if (null == root.children) {
            return;
        }
        root.children.forEach(a -> dfs(a, list));
    }
}
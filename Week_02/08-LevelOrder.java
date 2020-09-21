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
    private List<List<Integer>> res = new ArrayList<>();

	/**
	 * 深度遍历的方式层级获取节点值
	 */
    public List<List<Integer>> levelOrder(Node root) {
        if (null != root) {
            traverseNode(root, 0);
        }
        return res;
    }

    private void traverseNode(Node root, int level) {
		// 预先创建好容器，等待放入值，只需创建1次
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (null == root.children) return;
        for (Node n : root.children) {
            traverseNode(n, level+1);
        }
    }

    // public List<List<Integer>> levelOrder(Node root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (null == root) {
    //         return res; 
    //     }
    //     ArrayDeque<Node> deque = new ArrayDeque<>();
    //     deque.offer(root);
    //     while (!deque.isEmpty()) {
    //         int size = deque.size();
    //         List<Integer> list = new ArrayList<>(size);
    //         while (size-- > 0) {
    //             Node temp = deque.poll();
    //             list.add(temp.val);
    //             if (null != temp.children) {
    //                 deque.addAll(temp.children);
    //             }
    //         }
    //         res.add(list);
    //     }
    //     return res;
    // }
}
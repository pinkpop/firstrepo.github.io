/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        //用connectTwoNode函数将左子树和右子树连接
        connectTwoNode(root.left, root.right);
        return root;
    }
    private void connectTwoNode(Node node1, Node node2){
        if(node1 == null || node2 == null){
            return;
        }
        //将传入的两个点连接
        node1.next = node2;
        //将两个点的左右子树连接
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        //再将跨越父节点的两个点连接
        connectTwoNode(node1.right, node2.left);
    }
}
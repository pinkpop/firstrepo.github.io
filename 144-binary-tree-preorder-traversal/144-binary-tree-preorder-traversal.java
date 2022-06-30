/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> res = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
       //version1 递归
        traverse(root);
        return res;
    }
    void traverse(TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
        
        //version 2 : Divide and conquer

        //version 3: 非递归方法 stack
//         Stack<TreeNode> stack = new Stack<TreeNode>();
//         List<Integer> result = new ArrayList<Integer>();
        
//         if(root == null){
//             return result;
//         }
        
//         stack.push(root);
//         while(!stack.empty()){
//             TreeNode node = stack.pop();
//             result.add(node.val);
//             if(node.right != null){
//                 stack.push(node.right);
//             }
//             if(node.left != null){
//                 stack.push(node.left);
//             }
//         }
//         return result;
        
//     }
// }
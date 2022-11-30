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
    
//     public List<Integer> preorderTraversal(TreeNode root) {
//        //version1 递归
//         List<Integer> res = new LinkedList<>();
//       if(root == null){
//           return res;
//       }
//         res.add(root.val);
//         res.addAll(preorderTraversal(root.left));
//         res.addAll(preorderTraversal(root.right));
//         return res;
//     }
// }
        
        //version 2 : Divide and conquer
//     public List<Integer> preorderTraversal(TreeNode root) {
       
//     }
// }
        //version 3: 非递归方法 stack
    Deque<TreeNode> stack = new ArrayDeque<>();
     public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
         if(root == null){
             return ans;
         }
         stack.push(root);
         while(!stack.isEmpty()){
             TreeNode node = stack.pop();
             ans.add(node.val);
         if(node.right != null){
             stack.push(node.right);
         }
         if(node.left != null){
             stack.push(node.left);
         }
         }
         return ans;
    }
}
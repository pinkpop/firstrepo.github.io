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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null){
            return res;
        }
        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                level.add(cur.val);
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right!= null){
                queue.offer(cur.right);
            }
            }
            //将每一层添加到最前面
        res.addFirst(level);
        }
        
        return res;
    }
}
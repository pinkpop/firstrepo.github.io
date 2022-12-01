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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean flag = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0; i< size; i++){
                 TreeNode cur = q.poll();
                if(flag){
                    level.addLast(cur.val);
                } else {
                    level.addFirst(cur.val);
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                } 
            }
            flag = !flag;
            res.add(level);
        }
        return res;
            }
       
        }
    

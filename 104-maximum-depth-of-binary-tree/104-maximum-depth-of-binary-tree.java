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
    int res;
    int depth;
    public int maxDepth(TreeNode root) {
//version1:traverse 遍历一遍二叉树，用一个外部变量记录每个节点所在的深度，取最大值就可以得到最大深度
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        //前序位置是进入一个节点的时候，后序位置是离开一个节点的时候，depth 记录当前递归到的节点深度
        depth ++;
        //如果到达叶子，则更新最大深度
        if(root.left == null && root.right == null){
            res = Math.max(depth, res);
        }
        
        traverse(root.left);
        traverse(root.right);
        
        depth --;
    }
}        
        
        
//version 2 分治法，计算左右子树的最大深度，比较之后+1      
        
//         if(root == null)
//             return 0;
//         // if(root.left == null && root.right == null)
//         //     return 1;
//         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    //}
//}
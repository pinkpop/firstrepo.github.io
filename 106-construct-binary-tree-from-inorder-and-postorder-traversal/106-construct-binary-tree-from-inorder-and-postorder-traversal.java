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
    //hashmap存放值和index
    HashMap<Integer,Integer> ValToIndex = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            ValToIndex.put(inorder[i],i);
        }
        return build(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
    }
    TreeNode build(int[] inorder, int inStart, int inEnd,
                    int[] postorder, int postStart, int postEnd ){
        if(inStart > inEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        int index = ValToIndex.get(rootVal);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStart, index-1,
                         postorder, postStart, postStart + leftSize -1);
        root.right = build(inorder, index + 1, inEnd,
                          postorder, postStart+leftSize, postEnd - 1);
        return root;
    }
}
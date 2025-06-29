/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> x= new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!= null){
            // x= root.val;
            // return x;
            inorderTraversal(root.left);
            x.add(root.val);
            inorderTraversal(root.right);
        }
        return x;
    }
}
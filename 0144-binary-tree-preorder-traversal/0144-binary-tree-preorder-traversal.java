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
    List<Integer> x= new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!= null){
            // x= root.val;
            // return x;
            x.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return x;
    }
}
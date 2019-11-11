/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean result = false;
    public boolean isSymmetric(TreeNode root) {    
    if(root == null||root.left==null&&root.right==null){
        return true;
    }
        
        if(root.left!=null&&root.right!=null){
              result =   symmetricHelper(root.left,root.right);    
        }
        else return false;
            
        return result;
    }
    public boolean symmetricHelper(TreeNode l,TreeNode r){
        if(l==null&&r==null){
            return true;
        }
        if(l==null||r==null){
            return false;
        }
        if(l.val!=r.val) return false;
        
        
        return symmetricHelper(l.left,r.right) && symmetricHelper(l.right,r.left);
    }
}

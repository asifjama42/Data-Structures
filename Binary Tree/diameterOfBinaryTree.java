class Solution {
    int max =0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(max==0){
            height(root);
        }
       return max;
    }
    public int height(TreeNode t){
        if(t==null) return -1;
        int l = height(t.left);
        int r = height(t.right);
        int a = Math.max(r,l) + 1;
        if(max<l+r+2){
            max = l+r+2;
        }       
        return a;
    }
}

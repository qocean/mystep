package leetcode;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return findResult(root.left , root.right);
    }

    public boolean findResult(TreeNode node1 , TreeNode node2){
        if(node1 == null && node2 == null) return true;
        else if(node1 != null && node2 != null){
            if(node1.val == node2.val)
                return findResult(node1.left , node2.right) && findResult(node1.right , node2.left);
            return false;
        }else{
            return false;
        }
    }
}

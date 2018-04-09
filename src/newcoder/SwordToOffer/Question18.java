package newcoder.SwordToOffer;

/**
 * 问题描述：
 *     二叉树的镜像定义：源二叉树
     8
   /  \
  6   10
 / \  / \
 5  7 9 11
 镜像二叉树
     8
   /  \
  10   6
 / \  / \
 11 9 7  5
 */
public class Question18 {
    public void Mirror(TreeNode root) {
        exchange(root);
    }

    public void exchange(TreeNode root){
        if(root == null) return;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        exchange(leftNode);
        exchange(rightNode);
        root.left = rightNode;
        root.right = leftNode;
    }
}

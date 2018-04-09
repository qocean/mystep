package newcoder.SwordToOffer;

import java.util.LinkedList;

/**
 * 问题描述：
 *      输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 解题思路：
 *
 */
public class Question39 {
    private int max = -1;
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        boolean result = true;
        LinkedList<TreeNode> list = new LinkedList<>();
        int leftDepth , rightDepth;
        list.add(root.left);    list.add(root.right);
        while((!list.isEmpty()) && result) {
            TreeNode left = list.pop();
            lastSearch(left, 0);
            leftDepth = max;
            max = -1;
            TreeNode right = list.pop();
            lastSearch(right, 0);
            rightDepth = max;
            max = -1;
            if (Math.abs(leftDepth - rightDepth) > 1) result = false;
            if (left != null) {
                list.add(left.left);
                list.add(left.right);
            }
            if (right != null) {
                list.add(right.left);
                list.add(right.right);
            }
        }
        return result;
    }

    private void lastSearch(TreeNode node , int nowDepth){
        if(node == null){
            if(nowDepth > max) max = nowDepth;
        }else{
            //先左孩子
            lastSearch(node.left , nowDepth+1);
            //后又孩子
            lastSearch(node.right , nowDepth+1);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        Question39 test = new Question39();

        System.out.println(test.IsBalanced_Solution(root));
    }
}

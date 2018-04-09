package newcoder.SwordToOffer;

/**
 * 问题描述：
 *      输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *  解题思路：
 *      树的后序遍历
 */
public class Question38 {

    public int max = -1;
    public int TreeDepth(TreeNode root) {
        lastSearch(root , 0);
        return max;
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

    }

}

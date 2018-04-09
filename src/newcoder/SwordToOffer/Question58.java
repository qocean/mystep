package newcoder.SwordToOffer;

/**
 *  问题描述：
 *      请实现一个函数，用来判断一颗二叉树是不是对称的。
 *      注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 *  解题思路：
 *      这道题需要注意，镜像的意思是按照中轴线折叠，两个子树能够完全重叠
 */
public class Question58 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)   return true;
        return compareTwo(pRoot.left , pRoot.right);
    }

    boolean compareTwo(TreeNode node1 , TreeNode node2){
        if(node1 == null){
            if(node2 == null)   return true;
            else{   return false;   }
        }else{
            if(node2 == null)   return false;
            else{
                if(node1.val == node2.val){
                    return compareTwo(node1.left , node2.right) && compareTwo(node1.right , node2.left);
                }else{
                    return false;
                }
            }
        }
    }
}

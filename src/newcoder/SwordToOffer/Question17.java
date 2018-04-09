package newcoder.SwordToOffer;

/**
 * 问题描述：
 *    输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Question17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return depthThrough(root1,root2);
    }

    //对树A进行深度优先遍历
    public boolean depthThrough(TreeNode root1,TreeNode root2){
        if(root1 != null && root2 != null) {
            if (root1.val == root2.val)
                if (findAnswer(root1, root2)) return true;
            if (depthThrough(root1.left, root2)) return true;
            if (depthThrough(root1.right, root2)) return true;
        }
        return false;
    }

    //对树A的当前子树和树B通过深度优先遍历查看结构是否相同
    public boolean findAnswer(TreeNode root1,TreeNode root2){
        TreeNode temp1 = root1, temp2 = root2;
        if(temp2 == null) return true;
        if(temp1 == null) return false;


        if(temp1.val == temp2.val)
        {
            return(findAnswer(temp1.left,temp2.left) && findAnswer(temp1.right,temp2.right));
        }else
            return false;
    }
}

package newcoder.SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题描述：
 *     输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

/**
 * 解题思路：
 *     从中序遍历开始，第一个节点为整个树的根节点，则根的做子树中有{4,7,2},右子树中有{5,3,8,6}。
 * 其左右子树的先序遍历和中序遍历同样和给的一样（很重要的结论），这样就拿到了左右子树的根节点，这样
 * 依次递归，就可以得到整个树。
 */
public class Question5 {

    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        Solution5 solution = new Solution5();
        TreeNode root = solution.reConstructBinaryTree(pre, in);
    }
}


class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution5 {
    private Map<Integer,Integer> inPosition = new HashMap<>();
    private Map<Integer,Integer> prePosition = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for(int i = 0 ; i < pre.length ; i++){
            prePosition.put(pre[i],i);
        }
        for(int i = 0 ; i < in.length; i++)
        {
            inPosition.put(in[i],i);
        }
        return findAnswer(0,in.length-1,in,pre,0);
    }
    private TreeNode findAnswer(int start,int end,int[] in,int[] pre, int nowRoot){
//        System.out.println(start + "    " + end + "    " +nowRoot);
        if(start == end ){
            TreeNode result = new TreeNode(in[start]);
            return result;
        }else if(start > end){
            return null;
        }else{
            TreeNode left = findAnswer(start,inPosition.get(pre[nowRoot])-1,in,pre,nowRoot+1);
            TreeNode right = findAnswer(inPosition.get(pre[nowRoot])+1,end,in,pre,prePosition.get(pre[nowRoot]) + inPosition.get(pre[nowRoot])-start+1);
            TreeNode result = new TreeNode(pre[nowRoot]);
            result.left = left;
            result.right = right;
            return result;
        }
    }
}

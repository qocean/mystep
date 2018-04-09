package newcoder.SwordToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 *  问题描述：
 *      请实现一个函数按照之字形打印二叉树，
 *      即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 *      第三行按照从左到右的顺序打印，其他行以此类推。
 *
 *  解题思路：
 *      使用栈的思路，但是要注意入栈的顺序，有的时候要左孩子先入栈，有的要右孩子先入栈
 */
public class Question59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) return result;
        Stack<TreeNode> fathers = new Stack<>();
        Stack<TreeNode> children = new Stack<>();
        fathers.add(pRoot);
        boolean flag = true;    //flag为true,先加入左孩子，为false，先加入右孩子
        do{
            ArrayList<Integer> list = new ArrayList<>();
            while(!fathers.empty()){
                TreeNode node = fathers.pop();
                if(flag){
                    if(node.left != null) children.push(node.left);
                    if(node.right != null) children.push(node.right);
                }else{
                    if(node.right != null) children.push(node.right);
                    if(node.left != null) children.push(node.left);
                }
                list.add(node.val);
            }
            result.add(list);
            flag = !flag;
            fathers = children;
            children = new Stack<>();
        }while (!fathers.empty());
        return result;
    }
}

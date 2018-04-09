package newcoder.SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 *  问题描述：从上往下打印二叉树
 *
 *      从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 */
public class Question22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            if(queue.peek().left != null){
                queue.offer(queue.peek().left);
            }
            if(queue.peek().right != null){
                queue.offer(queue.peek().right);
            }
            result.add(queue.peek().val);
            queue.remove();
        }
        return result;
    }

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for(Integer i : queue){
            System.out.println(i);
        }
        queue.remove();
        for(Integer i : queue){
            System.out.println(i);
        }
    }
}


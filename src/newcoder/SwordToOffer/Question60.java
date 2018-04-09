package newcoder.SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  问题描述：
 *      请实现两个函数，分别用来序列化和反序列化二叉树
 *
 *  实现思路：
 *      队列来实现按层输出，但是要记录每层的数量
 */
public class Question60 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null)   return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int nowLevel = 1;
        int nextLevel = 0;
        while(!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0 ; i<nowLevel ; i++){
                TreeNode node = queue.poll();
                if(node.left != null){queue.add(node.left); nextLevel++;}
                if(node.right != null){queue.add(node.right);  nextLevel++;}
                list.add(node.val);
            }
            nowLevel = nextLevel;
            nextLevel = 0;
            result.add(list);
        }
        return result;
    }
}

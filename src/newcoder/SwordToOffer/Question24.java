package newcoder.SwordToOffer;


import java.util.ArrayList;


/**
 *  问题描述：二叉树中和为某一值的路径
 *
 *      输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *      路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Question24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null) return null;
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        ArrayList<Integer> nowResult = new ArrayList<>();
        scanTree(root,target,nowResult,finalResult);
        return finalResult;
    }

    public void scanTree(TreeNode root , int value , ArrayList<Integer> nowResult , ArrayList<ArrayList<Integer>> finalResult){
        if(root == null) return;

        if( (value-root.val)==0){
            if(root.left==null && root.right==null)
            {
                //得到正确的结果了
                ArrayList<Integer> oneResult = new ArrayList<>();
                for(int temp : nowResult){
                    oneResult.add(temp);
                }
                oneResult.add(root.val);
                finalResult.add(oneResult);
            }else{
                //此时不是叶子节点，则没有用
                return;
            }
        }else if( (value-root.val) < 0 ){
            //加和大于当前值了，不考虑
            return;
        }else{
            //加和大于0，则继续进行
            nowResult.add(root.val);
            scanTree(root.left,value-root.val,nowResult,finalResult);
            scanTree(root.right,value-root.val,nowResult,finalResult);
            nowResult.remove(nowResult.size()-1);   //去除痕迹
        }
    }
}

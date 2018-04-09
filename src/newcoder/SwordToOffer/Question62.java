package newcoder.SwordToOffer;

public class Question62 {
    TreeNode result = null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        midelSearch(pRoot , 0 , k );
        return result;
    }

    int midelSearch(TreeNode node , int i , int k ){
        if(node == null)  return i;
        i =  midelSearch(node.left , i , k );
        i++;
        if(i==k) result = node;
        i =  midelSearch(node.right , i , k );
        return i;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;     node1.right = node3;
        node2.left = node4;     node2.right = node5;
        node3.left = node6;     node3.right = node7;

        Question62 test = new Question62();
        test.KthNode(node1 , 1);
    }
}

package newcoder.SwordToOffer;

/**
 *  问题描述：二叉搜索树与双向链表
 *
 *      输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *      要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 */
public class Question26 {
    TreeNode father = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        TreeNode root = pRootOfTree;
        father = null;
        boolean flag = false;
        TreeNode start = null , last = null;
        //3
        TreeNode nowMinNode = findMin(root);
        if(nowMinNode == pRootOfTree && nowMinNode.right == null){
            return nowMinNode;
        }
        flag = reSetTree(nowMinNode);
        if(flag) root = root.right;
//        System.out.println( flag + "   " + nowMinNode.val);
        start = nowMinNode;
        last =  start;

        while( true ){
            nowMinNode = findMin(root);
            flag = reSetTree(nowMinNode);
            if(flag) root = root.right;

            if(nowMinNode.left==null && nowMinNode.right==null && flag){
                last.right = nowMinNode;
                nowMinNode.left = last;
                last = last.right;
                break;
            }

            last.right = nowMinNode;
            nowMinNode.left = last;
            last = last.right;
        }
        start.left = null;
        last.right = null;
        return start;
    }

    public boolean reSetTree(TreeNode nowMinNode){
        if(nowMinNode.right != null && father != null){
            father.left = nowMinNode.right;
            father = null;
            return false;
        }else if(nowMinNode.right == null && father != null){
            father.left = null;
            father = null;
            return false;
        }else if(father == null){
            return true;
        }
        return true;
    }

    public TreeNode findMin(TreeNode root){
        if(root.left == null){
            return root;
        }
        TreeNode temp = root;
        while(temp.left != null){
            father = temp;
            temp = temp.left;
        }
        return temp;
    }

    public static void main(String[] args){
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);

        treeNode4.left = treeNode3;
        treeNode4.right = treeNode5;
        treeNode6.left = treeNode4;

        treeNode8.right = treeNode9;
        treeNode10.left = treeNode8;
        treeNode10.right = treeNode11;
        treeNode6.right = treeNode10;

        Question26 test = new Question26();
        TreeNode result = test.Convert(treeNode6);
        while(result != null){
            System.out.println(result.val);
            result = result.right;
        }

    }
}

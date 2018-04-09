package newcoder.SwordToOffer;


/**
 *  问题描述：
 *      请实现一个函数，用来判断一颗二叉树是不是对称的。
 *      注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 *  解题思路：
 *      如果有有孩子，那么下个节点就是右子树中最左的节点
 *      如果没有右孩子，就要不断的找父亲节点，直至其所在子树是该父亲的左孩子，则返回该父亲，或者返回null（该节点是最后一个或是根节点）
 */
public class Question57 {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)   return null;
        if(pNode.right == null) {
            TreeLinkNode father = pNode.next;
            while(father != null){
                if(father.right == pNode){
                    pNode = father;
                    father = father.next;
                }else{
                    return father;
                }
            }
            return null;
        }else{
            return findRightLeft(pNode);
        }
    }

    /**
     * 如果节点有右孩子的情况
     * @param node
     * @return
     */
    private TreeLinkNode findRightLeft(TreeLinkNode node){
        TreeLinkNode next = node.right;
        while(next != null && next.left != null){
            next = next.left;
        }
        return next;
    }


    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}

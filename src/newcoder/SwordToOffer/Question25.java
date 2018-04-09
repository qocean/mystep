package newcoder.SwordToOffer;
import java.util.HashMap;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

/**
 * 问题描述：复杂链表的复制
 *
 *      输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *      返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 解题思路：
 *      思路1：先只复制next指针的值，同时用HashMap存储旧的对象和新的对象之间的关系，然后再通过HashMap复制random指针
 *
 *      思路2：剑指offer 148页的第三种思路
 */
public class Question25 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        //思路1
//        public RandomListNode Clone(RandomListNode pHead)
//        {
//            if(pHead == null) return null;
//            RandomListNode nowNode = pHead.next;
//            RandomListNode cloneHead = new RandomListNode(pHead.label);
//            RandomListNode copyNode = cloneHead;
//            HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
//            map.put(pHead,cloneHead);
//            while(nowNode != null){
//                RandomListNode temp = new RandomListNode(nowNode.label);
//                copyNode.next = temp;
//                copyNode = copyNode.next;
//                map.put(nowNode,copyNode);
//                nowNode = nowNode.next;
//            }
//
//            nowNode = pHead;
//            copyNode = cloneHead;
//            while(nowNode != null){
//                if(nowNode.random != null)
//                    copyNode.random = map.get(nowNode.random);
//                nowNode = nowNode.next;
//                copyNode = copyNode.next;
//            }
//            return cloneHead;
//        }
//      End 思路1
        RandomListNode nowNode = pHead.next;
        RandomListNode cloneHead = new RandomListNode(pHead.label);
        RandomListNode copyNode = cloneHead;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        map.put(pHead,cloneHead);
        while(nowNode != null){
            RandomListNode temp = new RandomListNode(nowNode.label);
            copyNode.next = temp;
            copyNode = copyNode.next;
            map.put(nowNode,copyNode);
            nowNode = nowNode.next;
        }

        nowNode = pHead;
        copyNode = cloneHead;
        while(nowNode != null){
            if(nowNode.random != null)
                copyNode.random = map.get(nowNode.random);
            nowNode = nowNode.next;
            copyNode = copyNode.next;
        }
        return cloneHead;
    }

    private void addNode(RandomListNode pHead){
        RandomListNode nowNode = pHead;
        while(nowNode != null){
            RandomListNode node = new RandomListNode(nowNode.label);
            node.next = nowNode.next;
            nowNode.next = node;
            nowNode = node.next;
        }
    }

    private void setRandomNode(RandomListNode pHead){
        RandomListNode nowNode = pHead;
        while(nowNode != null){
            RandomListNode nextNode = nowNode.next;
            if(nowNode.random != null)
                nextNode.random = nowNode.random.next;
            else{
                nextNode.random =null;
            }
            nowNode = nextNode.next;
        }
    }

    private RandomListNode getFinalResult(RandomListNode pHead){
        RandomListNode head = pHead.next;
        RandomListNode lastNode = head;
        RandomListNode nowNode = head.next;

        RandomListNode preLastNode = pHead;


        while(nowNode != null){
            RandomListNode nextNode = nowNode.next;
            lastNode.next = nextNode;
            lastNode = nextNode;
            nowNode = nextNode.next;

            preLastNode.next = nextNode;
            preLastNode = nextNode;
        }
        return head;
    }

    public static void main(String[] args){
        RandomListNode first = new RandomListNode(1);
        RandomListNode second = new RandomListNode(2);
        RandomListNode third = new RandomListNode(3);
        first.next = second;
        second.next= third;
        first.random = third;
        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());
        System.out.println("-----------------------------------");
        Question25 test = new Question25();
        RandomListNode result = test.Clone(first);
        RandomListNode node = first;
        while(node != null){
            System.out.println(node.toString());
            node = node.next;
        }
        System.out.println("-----------------------------------");
        node = result;
        while(node != null){
            System.out.println(node.toString());
            node = node.next;
        }
    }
}

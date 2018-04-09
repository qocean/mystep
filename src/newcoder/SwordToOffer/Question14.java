package newcoder.SwordToOffer;

/**
 *问题描述：
 *    输入一个链表，输出该链表中倒数第k个结点。
 */

/**
 * 解题思路：
 *    设置一个标志位m，表示遍历到的点前的第k个点。
 *    有两个特殊情况：给的是一个空的链表和链表中个数不足k个的问题
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Question14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null) return null;
        int m = 0;
        ListNode result = head;
        ListNode nextNode = head;
        while(nextNode.next != null){
            if(m-k+1 ==0){result=result.next; nextNode = nextNode.next;}
            else{
                m++;
                nextNode = nextNode.next;
            }
        }
        if(m-k+1 != 0) return null;
        return result;
    }
}

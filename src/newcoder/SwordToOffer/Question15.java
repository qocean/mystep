package newcoder.SwordToOffer;


/**
 * 问题描述：
 *     输入一个链表，反转链表后，输出链表的所有元素。
 */


public class Question15 {
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        ListNode result = null;
        while(head != null){
            ListNode temp = new ListNode(head.val);
            temp.next = result;
            result = temp;
            head = head.next;
        }
        return result;
    }
}

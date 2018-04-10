package newcoder.SwordToOffer;


/**
 * 问题描述：
 *     输入一个链表，反转链表后，输出链表的所有元素。
 */


public class Question15 {

    private ListNode nextNode;

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

    /**
     * 不申请额外空间，直接在原有的链表基础上做操作
     * @param head
     * @return
     */
    public ListNode ReverseList2(ListNode head) {
        if(head == null) return null;
        ListNode nextNode = head.next;
        head.next = null;
        while(nextNode != null){
            ListNode temp = nextNode.next;
            nextNode.next = head;
            head = nextNode;
            nextNode = temp;
        }
        return head;
    }
}

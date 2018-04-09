package newcoder.SwordToOffer;

/**
 * 问题描述：
 *      输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */


public class Question16 {
    public ListNode Merge(ListNode list1,ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode root = null , list1Next = list1 , list2Next = list2;
        if(list1.val <= list2.val){
            root = new ListNode(list1.val);
            list1Next = list1.next;
        }else{
            root = new ListNode(list2.val);
            list2Next = list2.next;
        }
        ListNode nextOne = root;
        while(list1Next != null && list2Next != null){
            ListNode temp = null;
            if(list1Next.val <= list2Next.val)
            {
                temp = new ListNode(list1Next.val);
                list1Next = list1Next.next;
            }else{
                temp = new ListNode(list2Next.val);
                list2Next = list2Next.next;
            }
            nextOne.next = temp;
            nextOne = nextOne.next;
        }
        if(list1Next == null)   nextOne.next = list2Next;
        else nextOne.next = list1Next;
        return root;
    }
}

package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p = l1 , q = l2 ;
            ListNode head = new ListNode(0) , next = head;
            int carry = 0;
            while(p != null && q!= null) {
                int sum = p.val + q.val + carry;
                carry = sum/10;

                ListNode temp = new ListNode(sum%10);
                next.next = temp;
                next = temp;
                p=p.next; q=q.next;
            }

            while(p != null){
                int sum = p.val + carry;
                carry = sum/10;
                ListNode temp = new ListNode(sum%10);
                next.next = temp;
                next = temp;
                p=p.next;
            }

            while(q != null){
                int sum = q.val + carry;
                carry = sum/10;
                ListNode temp = new ListNode(sum%10);
                next.next = temp;
                next = temp;
                q = q.next;
            }

            if(carry != 0){
                ListNode temp = new ListNode(carry);
                next.next = temp;
                next = temp;
            }

            return head.next;
        }


    public static void main(String [] args){
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);

        listNode3.next = listNode2; listNode2.next = listNode1;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);

        listNode6.next = listNode5; listNode5.next = listNode4;

        ListNode result = addTwoNumbers(listNode3 , listNode6);

        while(result != null){
            System.out.print(result.val);
            result = result.next;
        }
    }
}

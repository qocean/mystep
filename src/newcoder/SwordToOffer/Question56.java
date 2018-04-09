package newcoder.SwordToOffer;

public class Question56 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null) return pHead;
        ListNode newHead = new ListNode(pHead.val-1);
        newHead.next = pHead;
        int prefixValue = pHead.val;
        ListNode node1 = newHead;
        ListNode node2 = pHead;

        while(node2 != null){
            boolean flag = false;
            while(node2.next != null && node2.next.val == prefixValue){
                node2 = node2.next;
                flag =true;
            }
            if(flag && node2.next == null) {node1.next = node2.next; break;}
            if(flag){
                node2 = node2.next;
                node1.next = node2;
                prefixValue = node2.val;
            }else{
                node1 = node1.next;
                node2 = node2.next;
                if(node2 != null)
                    prefixValue = node2.val;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next=node2;   node2.next=node3;   node3.next=node4;
        node4.next=node5;   node5.next=node6;   node6.next=node7;
        Question56 test = new Question56();
        ListNode node =  test.deleteDuplication(node1);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}

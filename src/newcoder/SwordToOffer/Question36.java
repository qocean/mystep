package newcoder.SwordToOffer;

/**
 *  问题描述：
 *      输入两个链表，找出它们的第一个公共结点。
 *
 *  解题思路：
 *      考虑长度问题。
 */

public class Question36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int a=0,b=0;
        ListNode nodea = pHead1;
        while(nodea != null){
            a++;
            nodea = nodea.next;
        }
        ListNode nodeb = pHead2;
        while(nodeb != null){
            b++;
            nodeb = nodeb.next;
        }
        nodea = pHead1;
        nodeb = pHead2;
        while(a != b){
            if(a>b){
                nodea=nodea.next;
                a--;
            }else{
                nodeb=nodeb.next;
                b--;
            }
        }
        while(nodea != nodeb){
            nodea=nodea.next;
            nodeb=nodeb.next;
        }
        return nodea;
    }
}

package newcoder.SwordToOffer;

import java.util.HashSet;
import java.util.Set;

/**
 *  问题描述：
 *      一个链表中包含环，请找出该链表的环的入口结点。
 *
 */
public class Question55 {

    /**
     * 我的解题方案，使用Hash
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Set<ListNode> existSet = new HashSet<>();
        while(pHead != null){
            if(existSet.contains(pHead))  return pHead;
            existSet.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

}

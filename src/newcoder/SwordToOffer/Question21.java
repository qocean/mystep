package newcoder.SwordToOffer;

import java.util.Stack;

/**
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Question21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int length = popA.length;
        int[] temp = new int[length];
        int positionA = 0;
        int positionTemp = 0;
        for(int i = 0 ; i < length ; ){
            if( positionTemp !=0 && popA[i] == temp[positionTemp-1]){
//                System.out.println("--  " + popA[i]);
                positionTemp--;
                i++;
            }else{
                if(positionA >= length) return false;
                temp[positionTemp++] = pushA[positionA++];
            }
        }
        if(positionTemp !=0 ) return false;
        return true;
    }

    public static void main(String[] args){
        int[] pushA = { 1 , 2 ,3 , 4, 5};
        int[] pushB = {3 ,5 , 4 , 2 , 1};
//        int[] pushB = {4 , 3 , 5 , 1,2};
        Question21 test = new Question21();
        System.out.println(test.IsPopOrder2(pushA,pushB));
    }

    /**
     * 适用栈来了一次二刷操作
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        int length = popA.length;
        Stack<Integer> stack = new Stack<>();
        int pushPosition = 0 , popPosition = 0;
        stack.push(pushA[pushPosition++]);
        while(popPosition < length){
            if(!stack.isEmpty() && stack.peek() == popA[popPosition]){
               stack.pop();
               popPosition++;
            }else{
                if(pushPosition >= length) return false;
                stack.push(pushA[pushPosition++]);
            }
        }

        return true;
    }
}

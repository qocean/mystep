package newcoder.SwordToOffer;


/**
 * 问题描述：
 *  用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

/**
 * 解题思路：
 *     这个问题没有思考清楚，用stack1进行push操作，用stack2进行pop操作，自己想的太麻烦了
 */

import java.util.Stack;

class Solution6 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

public class Question6 {
}

package newcoder.SwordToOffer;

import java.util.Stack;

/**
 * 问题描述：
 *     定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * 修改时间：2018-04-12
 * 修改原因：适用辅助栈来实现
 */
public class Question20 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty() || minStack.peek()> node){
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

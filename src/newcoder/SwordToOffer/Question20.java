package newcoder.SwordToOffer;

import java.util.Stack;

/**
 * Created by QiHaiyang on 2017/7/24.
 */
public class Question20 {
    Stack<Integer> stack = new Stack<>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        Stack<Integer> tempStack = new Stack<>();
        int min = stack.peek();
        stack.pop();
        tempStack.push(min);
        while(!stack.empty()){
            int tempInt = stack.peek();
            stack.pop();
            if(min > tempInt) min = tempInt;
            tempStack.push(tempInt);
        }
        while(!tempStack.isEmpty()){
            stack.push(tempStack.peek());
            tempStack.pop();
        }
        return min;
    }
}

package newcoder.SwordToOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *   问题描述：
 *       汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 *       对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 *       例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 *   解题思路：
 *      考虑到n可能大于字符串长度的情况，要进行一次取模操作
 *      用队列解决，出队列后再入队列就可以了。
 */
public class Question43 {
    public String LeftRotateString(String str,int n) {
        if(str.length() == 0) return "";
        Queue<Character> queue = new LinkedList<>();
        int length = str.length();
        int k = n%length;
        for(int i=0 ; i < length ; i++)
            queue.add(str.charAt(i));
        for(int i=0 ; i < k ; i++){
            Character c = queue.remove();
            queue.add(c);
        }

        StringBuilder result = new StringBuilder();
        for(int i=0 ; i < length ; i++)
            result.append(queue.remove());
        return result.toString();
    }

    public static void main(String[] args){
        Question43 test = new Question43();
        System.out.println(test.LeftRotateString("abcXYZdef" , 12));
    }
}

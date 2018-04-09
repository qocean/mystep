package newcoder.SwordToOffer;


/**
 * 问题描述：
 *     输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

/**
 * 问题解析：
 *     这个问题就是个坑：正数补码是其本身，负数补码为正数取反加1。
 * 计算机中存储的就是补码，所以不用考虑正数和负数的情况
 */
public class Question11 {
    public int NumberOf1(int n) {
        //对于正整数
        int count = 0;
        while(n!=0){
            n = (n-1)&n;
            count++;
        }
        //对于负数

        return count;
    }
}

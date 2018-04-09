package newcoder.SwordToOffer;

/**
 * 问题描述：
 *     大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 *n<=39
 */

/**
 * 问题解析：
 *     递归方案大家都会写，需要写的是非递归方案
 *     非递归方案：从低向上，而不是递归的从上到下，算是动态规划了
 */
public class Question8 {
    public static int Fibonacci(int n) {
        if(n <= 0) return 0;
        if(n == 1 || n == 2) return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static int FeiDiGui(int n){
        if(n <= 0 ) return 0;
        if(n==1||n==2) return 1;
        int[] num = new int[n+1];
        num[1] = 1; num[2]=1;
        for(int i = 3; i <= n ; i++){
            num[i] = num[i-1] + num[i-2];
        }
        return num[n];
    }

    public static void main(String[] args){
        System.out.println(FeiDiGui(1));
    }
}

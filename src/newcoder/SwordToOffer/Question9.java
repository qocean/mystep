package newcoder.SwordToOffer;

/**
 * 问题描述：
 *     一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

/**
 * 解题思路：
 *     一次跳两级或者一级，最后的时候有两种情况：青蛙在n-1阶上或者n-2阶上
 * 这个时候再跳一阶或者两阶就结束了，所以f(n)=f(n-1)+f(n-2)。
 * 延伸分析：
 *     如果一次可以跳三阶，那么就是f(n)=f(n-1)+f(n-2)+f(n-3),以此类推
 */
public class Question9 {
    public static int JumpFloor(int target) {
        if(target == 1) return 1;
        int[] num = new int[target+1];
        num[1] = 1; num[2] = 2;
        for(int i = 3 ; i <= target ; i++)
            num[i] = num[i-1] + num[i-2];
        return num[target];
    }
    public static void main(String[] args){
        System.out.println(JumpFloor(5));
    }
}

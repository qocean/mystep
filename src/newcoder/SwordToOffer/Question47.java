package newcoder.SwordToOffer;

/**
 *  问题描述：
 *      求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  解题思路：
 *      看的别人的答案
 */
public class Question47 {

    /**
     * 感觉饿这个代码不对，pow不能用啊，里面实现应该是用了乘法的
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = (int) (Math.pow(n,2) + n);
        return sum>>1;
    }

    /**
     * 这个真是神一样的代码，很是佩服
     * @param n
     * @return
     */
    public int Sum(int n){
        int res = n;
        boolean flag = (n>0)&&((res+=Sum_Solution(n-1))>0);
        return res;
    }
}

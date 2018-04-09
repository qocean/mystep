package newcoder.SwordToOffer;

public class Question30{

    /**
     * 问题描述：连续子数组的最大和
     *
     *      最大字串和
     */

    /**
     * 算法解析：
     *     用sum来保存当前的最大结果，tempsum表示临时计算的最大结果
     *       tempsum = (tempsum<0) ? array[i] : (tempsum+array[i]);
     *       上面这行代码最关键，可以考虑到当算到array[i-1]的时候，tempsum<0了，那么前面的就没有用了，
     *       为什么呢，如果需要前面的数据来做字串中的数据，必然包含array[i-1]，因为这个是用来做连接的，
     *       但是array[i-1]把前面的加和都给减掉了，前面都是负数了，那前面的部分就没用了，所以就可以不要了，
     *       重新算就是，sum一定要保存当前的最大结果。
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = array[0];
        int tempsum = array[0];
        for(int i=1 ; i<array.length ; i++){
            tempsum = (tempsum<0) ? array[i] : (tempsum+array[i]);
            sum = (tempsum>sum) ? tempsum : sum;
        }
        return sum;
    }
}

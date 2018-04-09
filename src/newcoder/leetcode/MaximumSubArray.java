package newcoder.leetcode;

/**
 * 问题描述：
 *      最大子数组和问题
 *
 *  解题思路：
 *      当当前的最大值为负数的时候，为何就不要了呢？
 *      当前最大和为负数，那么对于求最大值没有任何好处，是消极营销，所以就不要了
 */
public class MaximumSubArray {
    public int maxSubArray(int[] A) {
        int length = A.length;
        int maxSum = Integer.MIN_VALUE , nowSum = 0;
        for(int i=0 ; i < A.length ; i++){
            nowSum+=A[i];
            maxSum=Math.max(maxSum,nowSum);
            if(nowSum<0)
                nowSum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args){

    }

}

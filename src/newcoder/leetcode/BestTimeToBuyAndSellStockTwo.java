package newcoder.leetcode;

/**
 *
 *  买卖袜子问题2（可以多次买进和卖出，但是每次买进前需要先卖出）
 *
 *  解题思路：
 *      如果价格递增，如【1，2，4】
 *      那么可以考虑第一天买进，第二天卖出，这个时候把当前最低价格设置为2，这样如果后面有比2高的价格，可以再次进行卖出，
 *      相当于第一天买进、第三天卖出。
 *      如【1，2，1，4】
 *      第一天买进，第二天卖出，但是第三天价格比第二天价格低了，所以前面的决策就是正确的。
 *
 *      动态规划的一个公式，假设有i<k<j，p[i][j]表示第i天买入，第j天卖出的收入，则有
 *      d[i][j] =d[i][k] + d[k][j]     //这个公式很重要
 */
public class BestTimeToBuyAndSellStockTwo {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2) return 0;
        int profit = 0;
        int tempLowPrice = Integer.MAX_VALUE , tempHighPrice = Integer.MIN_VALUE;
        for(int i=0 ; i<length ; i++){
            tempHighPrice = prices[i];
            if(tempHighPrice - tempLowPrice >0){
                profit += (tempHighPrice - tempLowPrice);
                tempLowPrice = prices[i] ;  //这一步最关键
                continue;
            }
            tempLowPrice = Math.min(tempLowPrice , prices[i]);
        }
        return profit;
    }
}

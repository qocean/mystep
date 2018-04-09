package newcoder.leetcode;

/**
 *  卖袜子问题
 *
 *  解题思路：
 *      从后往前遍历的，这样就知道后面哪天卖的最贵，然后在前面找到两个数的差最大的那个就可以了
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int bestProfit = Integer.MIN_VALUE;
        int highestPrice = prices[prices.length-1];
        for(int i=prices.length-1 ; i>=0 ; i--){
            int profit = highestPrice - prices[i];
            bestProfit = Math.max(profit,bestProfit);
            highestPrice = Math.max(prices[i] , highestPrice);
        }
        return bestProfit;
    }
}

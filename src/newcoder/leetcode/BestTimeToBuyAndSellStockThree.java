package newcoder.leetcode;

public class BestTimeToBuyAndSellStockThree {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2) return 0;
        int profit = 0,lastSellPosition=-1;
        int tempLowPrice = Integer.MAX_VALUE , tempHighPrice;
        for(int i=0 ; i<length ; i++){
            tempHighPrice = prices[i];
            if(tempHighPrice - tempLowPrice >0){
                if(lastSellPosition < 0) { profit += (tempHighPrice - tempLowPrice);}
                else{
                    if(prices[lastSellPosition] == tempLowPrice) {  profit += (tempHighPrice - tempLowPrice); }
                    else{System.out.println(profit);  profit = tempHighPrice - tempLowPrice; }
                }
                lastSellPosition=i;
                //判断过程开始
                tempLowPrice = prices[i] ;  //这一步最关键
                continue;
            }
            tempLowPrice = Math.min(tempLowPrice , prices[i]);
        }
        return 0;
    }

    public static void main(String[] args){
        int prices[] = {6,1,3,2,4,7};
        BestTimeToBuyAndSellStockThree test = new BestTimeToBuyAndSellStockThree();
        System.out.println(test.maxProfit(prices));
    }
}

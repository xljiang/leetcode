package leetcode;

public class BestTimeToBuyAndSellStock {

	// dp (my solution)
	public int maxProfit(int[] prices){
	    if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
		int[] f = new int[n];
		f[0] = 0; // f[i] is the max profit of subarray [0,i]
		int min = prices[0];
		for (int i = 1; i < n; i++){
			f[i] = Math.max(f[i-1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return f[n-1];
	}
	
	// dp, O(1) space, O(n) time
    public int maxProfitDP(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
	}
    
    // method 3: greedy
    public int maxProfit3(int[] prices) {
        int max = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
        	profit += prices[i] - prices[i-1];
            if (profit < 0) {
            	profit = 0;
            }
            max = Math.max(max, profit);
        }        
        return max;
    }
    

}

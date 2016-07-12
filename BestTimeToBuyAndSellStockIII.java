package leetcode;

public class BestTimeToBuyAndSellStockIII {

	public int maxProfit(int[] prices){
		if (prices == null || prices.length <= 1){
			return 0;
		}
		
		int n = prices.length;
		int[] left = new int[n]; // left[i] is the maxProfit of [0, i]
		int[] right = new int[n]; // right[i] is the maxProfit of [i, n-1]
		
		// dp from left to right, calculate left[i]
		left[0] = 0;
		int minLeft = prices[0]; // minLeft is the minPrice of [0, i]
		for (int i = 1; i < n; i++){
			left[i] = Math.max(left[i-1], prices[i] - minLeft);
			minLeft = Math.min(minLeft, prices[i]);
		}
			
		// dp from right to left, calculate right[i]
		right[n-1] = 0;
		int maxRight = prices[n-1]; // minRight is the minPrice of [i, n-1]
		for (int i = n-2; i >= 0; i--){
			right[i] = Math.max(right[i+1], maxRight - prices[i]);
			maxRight = Math.max(maxRight, prices[i]);
		}
		
		// calculate maxProfit
		int maxProfit = 0;
		for (int i = 0; i < n; i++){
			maxProfit = Math.max(maxProfit, left[i] + right[i]);
		}
		
		return maxProfit;
	}
}

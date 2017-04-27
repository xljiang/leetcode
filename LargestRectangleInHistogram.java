package leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {

	// method 1, O(n2) algorithm, TLE
	public int largestRectangleArea(int[] heights){
		int maxArea = 0;
		for (int i = 0; i < heights.length - 1; i++){
			int ht = heights[i];
			for (int j = i + 1; j < heights.length; j++){
				int width = j - i + 1;
				ht = Math.min(ht, heights[j]);
				maxArea = Math.max(maxArea, width * ht);
			}
		}
		return maxArea;
	}
	
	// method 2, O(n) algorithm
	public int largestRectangleArea2(int[] heights){
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> s = new Stack<Integer>(); 
        
        int i = 0;
        while (i <= len){
            int h = (i == len ? 0 : heights[i]);  // 0 as dummy end
            if (s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
                i++;
            } else {
                int top = s.pop();
                int area = heights[top] * (s.isEmpty() ? i : i - 1 - s.peek());
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
	}
}

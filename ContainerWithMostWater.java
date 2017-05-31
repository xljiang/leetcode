package leetcode;

public class ContainerWithMostWater {
	// TLE since May 2017
	public int maxArea(int[] height){
		int area = 0;
		int i = 0, j = height.length - 1;
		while (i < j){
		    area = Math.max(area, (j-i) * Math.min(height[i], height[j]));
		    if (height[i] < height[j]){
		        i++;
		    } else {
		        j--;
		    }
		}
		return area;
	}
	
	// a little bit optimization
    public int maxArea2(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, area);
            if (height[i] <= height[j]) { // move i forward
                int currHeight = height[i];
                while (i < j && height[i] <= currHeight) {
                    i++;
                }
            } else { // move j backward
                int currHeight = height[j];
                while (j > i && height[j] <= currHeight) {
                    j--;
                }
            }
        }
        return max;
    }
}

package leetcode;

public class TrappingRainWater {

	// a TLE answer: delete bottom layer each time
	public int trap(int[] height){
		int sum = 0;
		int maxHt = 0;
		for (int i = 0; i < height.length; i++){
			maxHt = Math.max(maxHt, height[i]);
		}
		
		for (int m = 0; m < maxHt; m++){
			for (int i = 1; i < height.length - 1;){
				int left, right;
				if (height[i] == 0){
					left = i - 1;
					right = i+1;
					while (right < height.length && height[right] == 0){
						right++;
					}
					System.out.println("i:"+i+"left"+left+"right"+right);
					if (left != 0 && right < height.length){
					    sum += right - left - 1;
					} 
					i = right + 1;
				} else{
					i++;
				}
			}
			
			// update height (all value -1, if value = 0, keep 0)
			for (int i = 0; i < height.length; i++){
				if (height[i] != 0){
					height[i] = height[i] - 1;
				}
			}
		}
		return sum;
	}
	
	// method 2: O(n) time O(1) space
	public int trap2(int[] height){
		int left = 0, right = height.length - 1; // index
		int maxLeft = 0, maxRight = 0; // height
		int sum = 0;
		while (left < right){
			if (height[left] <= height[right]){
				if (height[left] > maxLeft){
					maxLeft = height[left];
				} else{
					sum += maxLeft - height[left];
				}
				left++;
			} else {
				if (height[right] > maxRight){
					maxRight = height[right];
				} else{
					sum += maxRight - height[right];
				}
				right--;
			}
		}
		return sum;
	}
}

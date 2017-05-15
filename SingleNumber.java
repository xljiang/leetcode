package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber {
	// method 1
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        Iterator<Integer> itr = set.iterator();
        int res = 0;
        while(itr.hasNext()) {
            res = itr.next();
        }
        return res;
    }
    
	// method 2, no extra space used
	public int singleNumber2(int[] nums){
		int result = 0;
		for (int i = 0; i < nums.length; i++){
			result ^= nums[i];
		}
		return result;
	}
}

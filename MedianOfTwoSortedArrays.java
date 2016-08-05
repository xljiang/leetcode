package leetcode;

public class MedianOfTwoSortedArrays {

	
	// method 1, O(log(min(m,n)))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // set array A, B, with len(A) = m, len(B) = n and n >= m
		int m = nums1.length, n = nums2.length;
		int[] A, B;
		if (n >= m){
			A = nums1;
			B = nums2;
		} else {
			A = nums2;
			B = nums1;
			int tmp = m;
			m = n;
			n = tmp;
		}
		
		// or:
		// if (m > n) return findMedianSortedArrays(nums2, nums1);
		// here use A, B just for convenience.
        
        // Binary search
        int imin = 0, imax = m;
        while (imin <= imax){
            int i = (imin + imax)/2;
            int j = (m+n+1)/2 - i; // satisfy both (m+n) = odd and even
            if ((j == 0 || i == m || B[j-1] <= A[i]) && (i == 0 || j == n || A[i-1] <= B[j])){
                // i is perfect
                int maxOfLeft, minOfRight;
                
                // find maxOfLeft
                if (i == 0) maxOfLeft = B[j-1];
                else if (j == 0) maxOfLeft = A[i-1];
                else maxOfLeft = Math.max(A[i-1], B[j-1]);
                
                // calculate median when (m+n) is odd
                if ((m+n) % 2 == 1){
                    return maxOfLeft/1.0;
                } 
                
                // find minOfRight
                if (i == m) minOfRight = B[j];
                else if (j == n) minOfRight = A[i];
                else minOfRight = Math.min(A[i], B[j]);
                
                // calculate median when (m + n) is even
                return (maxOfLeft + minOfRight)/2.0;
                
            } else if (j > 0 && i < m && B[j-1] > A[i]){
                // i is too small, need to update search range to [i+1, imax]
                imin = i + 1;
            } else { // (i > 0 && j < n && A[i-1] > B[j])
                // i is too big, need to update search range to [imin, i-1]
                imax = i - 1;
            }
        }

        return -1;
    }
    
    
    // method 2: O(log(m+n))

    
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n + 1)/2;
        double median = (double)getkth(nums1, 0, m-1, nums2, 0, n-1, k);
        
        if ((m+n) % 2 == 0){
            double median2 = (double)getkth(nums1, 0, m-1, nums2, 0, n-1, k+1);
            median = (median + median2)/2;
        }
        return median;
    }
    
    public int getkth(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k){
        if (aStart > aEnd) return B[bStart + k - 1];
        if (bStart > bEnd) return A[aStart + k - 1];
        
        int aMid = (aStart + aEnd)/2, bMid = (bStart + bEnd)/2;
        
        if (A[aMid] <= B[bMid]){ 
            if (k <= (aMid - aStart) + (bMid - bStart) + 1){
                return getkth(A, aStart, aEnd, B, bStart, bMid - 1, k);
            } else {
                return getkth(A, aMid + 1, aEnd, B, bStart, bEnd, k-(aMid-aStart)-1);
            }
        } else { 
            if (k <= (aMid - aStart) + (bMid - bStart) + 1){
                return getkth(A, aStart, aMid - 1, B, bStart, bEnd, k);
            } else {
                return getkth(A, aStart, aEnd, B, bMid + 1, bEnd, k-(bMid-bStart)-1);
            }
        }
    }
    
    
    
    
    // method 3: O(log(m+n)), similar as method 3, with some changes
    
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1)/2;
        int r = (m + n + 2)/2;
        return (findkth(nums1, 0, nums2, 0, l) + findkth(nums1, 0, nums2, 0, r))/2.0;
    }
    
    public int findkth(int[] A, int aStart, int[] B, int bStart, int k){
    	if (aStart > A.length - 1) return B[bStart + k - 1];
    	if (bStart > B.length - 1) return A[aStart + k - 1];
    	if ( k == 1) return Math.min(A[aStart], B[bStart]);
    	
    	int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
    	if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
    	if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];
    	
    	if (aMid < bMid){ // keep aRight + b
    	    return findkth(A, aStart + k/2, B, bStart, k-k/2);
    	} else {   // keep a + bRight
    	    return findkth(A, aStart,B, bStart + k/2, k-k/2);
    	}
    }
}

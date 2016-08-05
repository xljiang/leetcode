package leetcode;

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        int i = 1, j = x, mid = i + (j-i)/2;
        while (i < j){
            if (mid > x/mid){
                j = mid - 1;
            } else if ((mid+1)>x/(mid+1)){
                return mid;
            } else{
                i = mid + 1;
            }
            mid = i + (j-i)/2;
        }
        return mid;
    }
    
    
    public int mySqrt2(int x) {
        if (x == 0){
            return 0;
        }
        int i = 1, j = x;
        while (true){
            int mid = i + (j-i)/2;
            if (mid > x/mid){
                j = mid - 1;
            } else {
                if ((mid+1) > x/(mid+1)){
                    return mid;
                }
                i = mid + 1;
            }
        }
    }
    
    
    public int mySqrt3(int x) {
        if (x == 0){
            return x;
        }
        int start = 1, end = x, ans=0;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (mid == x/mid)
                return mid;
            if (mid < x/mid)
            {
                start = mid + 1;
                ans = mid;
            }
            else   
                end = mid - 1;
        }
        return ans;
    }
    

}

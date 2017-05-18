package leetcode;

public class AddDigits {

	// method 1: iteration
    public int addDigits(int num) {
        int res = num;
        while (num > 9) {
            res = 0;
            while (num != 0) {
                res += num % 10;
                num = num / 10;
            }
            num = res;
        }
        return res;
    }
    
    // method 2: digit root
    public int addDigits2(int num) {
        return 1 + (num - 1) % 9;
    }
}

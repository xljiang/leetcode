package leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()){
            return b;
        }
        if (b == null || b.isEmpty()){
            return a;
        }
        StringBuffer sb = new StringBuffer();
        
        int carry = 0;
        int m = a.length();
        int n = b.length();
        
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int aBit = (i >= 0) ? (a.charAt(i) - '0') : 0;
            int bBit = (j >= 0) ? (b.charAt(j) - '0') : 0;
            int result = 0;
            // int result = aBit ^ bBit ^ carry;
            // carry = (aBit + bBit + carry) >= 2 ? 1: 0;
            int sum = aBit + bBit + carry;
            if (sum <= 1){
                result = sum;
                carry = 0;
            } else if (sum == 2){
                result = 0;
                carry = 1;
            } else if (sum == 3){
                result = 1;
                carry = 1;
            }
            sb.append(result);
        }
        
        return sb.reverse().toString();
    }

}

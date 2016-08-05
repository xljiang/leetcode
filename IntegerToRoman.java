package leetcode;

public class IntegerToRoman {
    public String intToRoman(int num) {
    	
        // Set up key numerals and numeral pairs
        int[] values = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder res = new StringBuilder();

        // Loop through each of the values to diminish the number
        for (int i = 0; i < values.length; i++){
            
            // If the number being converted is less than the test value, append
            // the corresponding numeral or numeral pair to the resultant string
            while (num >= values[i]){
                res.append(numerals[i]);
                num -= values[i];
            }
        }
        return res.toString();
    }
}

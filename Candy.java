package leetcode;

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // give each child 1 candy
        
        // Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
        for (int i = 1; i < n; i++){ 
            if (ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        
        // Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
        for (int i = n - 2; i >= 0; i--){
            if (ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        
        // sum up
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += candies[i];
        }
        return sum;
    }
    
}

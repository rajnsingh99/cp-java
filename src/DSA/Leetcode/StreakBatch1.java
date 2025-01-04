package DSA.Leetcode;


import java.util.ArrayList;
import java.util.List;

public class StreakBatch1 {

    public static void main(String[] args) {
        System.out.println("Leetcode Streak batch-1");
        int[] candies = {2,3,5,1,3};
        int extra = 1;
        System.out.println(kidsWithCandies(candies, extra));
    }

    public static String mergeAlternately(String word1, String word2) {
        int m = 0;
        int n = 0;
        StringBuilder builder = new StringBuilder();
        while (word1.length() > m && word2.length() > n) {
            builder.append(word1.charAt(m));
            ++m;
            builder.append(word2.charAt(n));
            ++n;
        }

        for (int i = m; i < word1.length(); i++) {
            builder.append(word1.charAt(i));
        }

        for (int i = n; i < word2.length(); i++) {
            builder.append(word2.charAt(i));
        }

        return builder.toString();
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int highestCandy = Integer.MIN_VALUE;
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            if (candy > highestCandy) {
                highestCandy = candy;
            }
        }

        for (int candy : candies) {
            if (candy + extraCandies >= highestCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

}

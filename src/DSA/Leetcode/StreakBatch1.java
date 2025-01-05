package DSA.Leetcode;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreakBatch1 {

    public static void main(String[] args) {
        System.out.println("Leetcode Streak batch-1");
        System.out.println(reverseVowels("IceCreAm"));

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

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                --n;
            }
        }

        return n <= 0;
    }


    public static String reverseVowels(String s) {
        Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> vowelSet = new HashSet<>(Arrays.asList(vowels));
        char[] str = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (vowelSet.contains(str[start]) && vowelSet.contains(str[end])) {
                // swap;
                char temp = str[start];
                str[start] = str[end];
                str[end] = temp;
                --end;
                ++start;
            } else if (vowelSet.contains(str[start])) {
                --end;
            } else if (vowelSet.contains(str[end])) {
                ++start;
            } else {
                --end;
                ++start;
            }
        }

        return String.valueOf(str);
    }

}

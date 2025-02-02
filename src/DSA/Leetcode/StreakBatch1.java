package DSA.Leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class StreakBatch1 {

    public static void main(String[] args) {
        System.out.println("Leetcode Streak batch-1");
        int[] flower = new int[]{0};
        maxOperations(new int[]{2,2,2,3,1,1,4,1}, 4);

        List<String> stringList = new ArrayList<>();
        stringList.add("raj");
        stringList.add("narayan");
        stringList.add("singh");
        stringList.add("1Pinnacle");
        System.out.println(stringList.stream().filter(str -> str.matches("^\\d.*")).toList());
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
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            --n;
        }

        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                --n;
            }
        }

        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            --n;
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

    public static String reverseWords(String s) {
        List<String> wordList = new ArrayList<>();
        s += " ";
        int start = -1;
        int end = -1;

        for (int i = 0; i < s.length(); i++) {
            if (start < 0 && s.charAt(i) != ' ') {
                start = i;
                end = i;
            }

            if (start >= 0 && s.charAt(i) != ' ') {
                ++end;
            }

            if (end >= 0 && s.charAt(i) == ' ') {
                // extract word
                String word = s.substring(start, end);
                wordList.add(word);
                start = -1;
                end = -1;
            }
        }

        StringBuilder finalStr = new StringBuilder();
        for (int i = wordList.size() - 1; i >= 0; i--) {
            if (i == 0) {
                finalStr.append(wordList.get(i));
            } else {
                finalStr.append(wordList.get(i)).append(" ");
            }
        }

        return finalStr.toString();
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }

        return result;
    }

    public static int compress(char[] chars) {
        Map<String, Integer> charMap = new HashMap<>();
        for (Character aChar : chars) {
            if (charMap.containsKey(String.valueOf(aChar))) {
                Integer count = charMap.get(String.valueOf(aChar));
                charMap.put(String.valueOf(aChar), ++count);
            } else {
                charMap.put(String.valueOf(aChar), 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String key : charMap.keySet()) {
            result.append(key);
            if (charMap.get(key) != 1) {
                result.append(charMap.get(key));
            }
        }

        return result.length();
    }

    public static boolean increasingTriplet(int[] nums) {
        int count = 1;
        for(int i = 0; i < nums.length; i++) {
            int curMin = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > curMin) {
                    curMin = nums[j];
                    ++count;
                }
            }

            if (count >= 3) {
                break;
            } else {
                count = 1;
            }
        }

        return count >= 3;
    }

    public static int[] moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        for (int num : nums) {
            if (num == 0) {
                result[end] = 0;
                end--;
            } else {
                result[start] = num;
                start++;
            }
        }

        System.arraycopy(result, 0, nums, 0, result.length);
        return nums;
    }

    static int[][] memo;
    public static boolean isSubsequence(String s, String t) {
        memo = new int[s.length()][t.length()];
        int subsequenceLength =subsequenceLength(s, t, s.length() - 1, t.length() -1);
        return s.length() == subsequenceLength;
    }

    private static int subsequenceLength(String s, String t, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (s.charAt(m) == t.charAt(n)) {
            return 1 + subsequenceLength(s, t, m - 1, n -1);
        } else {
            return Math.max(subsequenceLength(s, t , m - 1, n), subsequenceLength(s, t, m, n- 1));
        }
    }

    public static void maxOperations(int[] nums, int k) {
        System.out.println(maxOpsSol(nums, k, 0, nums.length - 1));
    }

    private static int maxOpsSol(int[] nums, int k, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (nums[i] + nums[j] == k) {
            return 1 + maxOpsSol(nums, k, i + 1, j - 1);
        } else {
            return Math.max(maxOpsSol(nums, k, i + 1, j), maxOpsSol(nums, k, i, j - 1));
        }
    }
}

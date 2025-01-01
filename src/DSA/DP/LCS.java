package DSA.DP;


import java.util.Arrays;

import static java.util.Collections.rotate;

public class LCS {

    public static void main(String[] args) {
//        String str = "nayan";
//        lcs(str, Utils.reverseString(str), str.length(), str.length());
//        System.out.println(longestPalindrome(str, Utils.reverseString(str), 0));

        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

    private static String longestPalindrome(String str1, String str2, int m) {
        if(str1.length() == 1) {
            return String.valueOf(str1.charAt(0));
        }

        if(str1.length() == m) {
            return "";
        }

        if(str1.charAt(m) == str2.charAt(m)) {
            return str1.charAt(m) + longestPalindrome(str1, str2, m + 1);
        } else {
            return longestPalindrome(str1, str2, m + 1);
        }
    }

    private static void lcs(String str1, String str2, int m, int n) {
        int[][] t = new int[m+1][n+1];
        for (int i = 0; i < m + 1; i++) {
            t[i][0] = 0;
        }

        for (int i = 0; i < n + 1; i++) {
            t[0][i] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j-1)) {
                    t[i][j] = 1 + t[i -1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j]);
                }
            }
        }

        System.out.println(t);
    }

    private static void rotate(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            int lastElement = arr[arr.length -1];
            int prev = arr[0];
            for (int j = 1; j < arr.length; j++) {
                int itemToSet = prev;
                prev = arr[j];
                arr[j] = itemToSet;
            }

            arr[0] = lastElement;
        }

        System.out.println(Arrays.toString(arr));
    }

}

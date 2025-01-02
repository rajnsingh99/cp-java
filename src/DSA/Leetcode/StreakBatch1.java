package DSA.Leetcode;


public class StreakBatch1 {

    public static void main(String[] args) {
        System.out.println("Leetcode Streak batch-1");
        System.out.println(mergeAlternately("gmumn", "azia"));
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

}

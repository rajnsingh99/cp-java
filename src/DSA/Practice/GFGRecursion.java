package DSA.Practice;


public class GFGRecursion {

    public static void main(String args[]) {
        int[] coins = {1,2,3};
        System.out.println(count(coins, coins.length, 5));
    }

    private static void print1ToN(int n) {
        if (n == 0) {
            return;
        }
        print1ToN(n - 1);
        System.out.print(n);
    }

    private static void printNTo1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n);
        printNTo1(n - 1);
    }

    private static void mean(int[] arr, int n) {
        int sum = sumForMean(arr, n);
        System.out.println(sum / (n + 1));
    }

    private static int sumNaturalNo(int n) {
        if (n <= 1) {
            return n;
        }

        return n + sumNaturalNo(n - 1);
    }

    private static void reverseString(String s, int n) {
        if (n == s.length() - 1) {
            System.out.print(s.charAt(n));
            return;
        }

        reverseString(s, n + 1);
        System.out.print(s.charAt(n));
    }

    private static int lengthOfString(String s, int n) {
        if (s.isEmpty()) {
            return 0;
        }

        if (n == s.length() - 1) {
            return 1;
        }

        return 1 + lengthOfString(s, n + 1);
    }

    private static int sumOfDigit(int digit) {
        if (digit == 0) {
            return 0;
        }

        return (digit % 10) + sumOfDigit(digit / 10);
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static int findMin(int[] arr, int n) {
        if (n == 0) {
            return arr[0];
        }

        return Math.min(arr[n - 1], findMin(arr, n - 1));
    }

    private static void palindromeCheck(String str) {
        String palindromeStr = palindrome(str, str.length() -1);
        System.out.println(21 & 10);
    }
    private static String palindrome(String str, int n) {
        if (n == 0) {
            return String.valueOf(str.charAt(0));
        } else {
            return str.charAt(n) + palindrome(str, n - 1);
        }
    }

    private static int count(int coins[], int n, int sum) {
        if (sum == 0)
            return 1;

        // If sum is less than 0 then no
        // solution exists
        if (sum < 0)
            return 0;

        // If there are no coins and sum
        // is greater than 0, then no
        // solution exist
        if (n <= 0)
            return 0;

        // count is sum of solutions (i)
        // including coins[n-1] (ii) excluding coins[n-1]
        return count(coins, n - 1, sum)
                + count(coins, n, sum - coins[n - 1]);
    }

    /**
     * Helper functions
     */
    private static int sumForMean(int[] arr, int n) {
        if (n == 0) {
            return arr[0];
        }
        int sum;
        sum = arr[n] + sumForMean(arr, n - 1);
        return sum;
    }


}

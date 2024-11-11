package Interview;


public class GFGRecursion {

    public static void main(String args[]) {
        System.out.println(sumOfDigit(12345));
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
        if(digit == 0) {
            return 0;
        }

        return (digit % 10) + sumOfDigit(digit / 10);
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

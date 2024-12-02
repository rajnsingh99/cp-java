package DSA.Practice;

import java.util.*;

public class GFGRecursion {

    public static void main(String[] args) {
//       Stack<Integer> stack = new Stack<>();
//       stack.add(-3);
//       stack.add(14);
//       stack.add(18);
//       stack.add(-5);
//       stack.add(30);
//       System.out.println(stack);
//       sortStack(stack);
//       System.out.println(stack);

        printAllPalindromicPartitions("nitin");
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

    private static void floodFill(int[][] arr, int x, int y) {
        if(arr[x][y] == 1) {
            arr[x][y] = 3;
        }

        if (x < 2)
            floodFill(arr, x + 1, y);
        if (y < 2)
            floodFill(arr, x, y + 1);
    }

    private static Integer reverseQueue(Queue<Integer> queue, int size) {
        if(size == 0) {
            return queue.remove();
        }


        Integer num = reverseQueue(queue, size - 1);
        queue.add(num);
        return num;
    }

    private static void pyramid(int n, int size) {
        if(n == size) {
            return;
        }

        for (int i = 0; i<= n; i++) {
            System.out.print("*");
        }
        System.out.println();
        pyramid(n + 1, size);
    }

    private static String longestPalindrome(String str, int n) {
        if(str.length() - 1 == n) {
            return String.valueOf(str.charAt(n));
        }

        String subStr = str.charAt(n) + longestPalindrome(str, n + 1);
        System.out.println("----> " + subStr + " --> " + checkPalindrome(subStr));
        return subStr;
    }

    private static boolean checkPalindrome(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }

        return str.equalsIgnoreCase(stringBuilder.toString());
    }

    private static void subset(String input, String output) {
        if(input.isEmpty()) {
            System.out.println("output > " + output);
            return;
        }

        String op1 = output;
        String op2 =  output + input.charAt(0);
        String new_input = input.substring(1);
        subset(new_input, op1);
        subset(new_input, op2);
    }

    private static void subset2(int[] output, int[] input) {
        if(input.length == 0) {
            System.out.println(Arrays.toString(output));
            return;
        }

        List<Integer> output2 = new ArrayList<>(Arrays.stream(output).boxed().toList());
        output2.add(input[0]);
        List<Integer> newInput = new ArrayList<>(Arrays.stream(input).boxed().toList());
        newInput.removeFirst();
        subset2(output, newInput.stream().mapToInt(Integer::intValue).toArray());
        subset2(output2.stream().mapToInt(Integer::intValue).toArray(), newInput.stream().mapToInt(Integer::intValue).toArray());
    }

    private static void sortStack(Stack<Integer> stack) {
        if(stack.size() == 1) {
            return;
        }

        int prevValue = stack.pop();
        sortStack(stack);
        System.out.println("-> " + stack);

        if(prevValue > stack.peek()) {
           insertItemStack(stack, prevValue);
        } else {
            stack.add(prevValue);
        }
    }

    private static void insertItemStack(Stack<Integer> stack, int valueToInsert) {
        if(stack.empty()) {
            stack.add(valueToInsert);
            return;
        }
        if(stack.peek() < valueToInsert) {
            int prevValue = stack.pop();
            insertItemStack(stack, valueToInsert);
            stack.add(prevValue);
        } else {
            stack.add(valueToInsert);
        }
    }

    private static void printAllPalindromicPartitions(String input) {
        Set<String> subsets = new HashSet<>();
        getAllCombinations(input, "", subsets);
        for(String subset : subsets){
            if (input.contains(subset)) {
                System.out.println(subset);
            }
        }
    }

    private static void getAllCombinations(String input, String output, Set<String> subsets) {
        if(input.isEmpty()) {
            if(checkPalindrome(output)) {
                subsets.add(output);
            }
            return;
        }

        String op2 =  output + input.charAt(0);
        String new_input = input.substring(1);
        getAllCombinations(new_input, output, subsets);
        getAllCombinations(new_input, op2, subsets);
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

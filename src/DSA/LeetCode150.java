package DSA;

import java.util.Stack;

public class LeetCode150 {
    public static void main(String[] args) {
    }

    private static int removeDuplicateFromSortedArray2(int[] input) {
        int swapCounter = 0;
        int currItem = input[0];
        int occurCounter = 0;

        for (int i = 0; i < input.length - swapCounter; i++) {
            // Code to identify the occurrence
            if (currItem == input[i] && occurCounter < 2) {
                currItem = input[i];
                ++occurCounter;
            } else if (currItem != input[i]) {
                currItem = input[i];
                occurCounter = 0;
                ++occurCounter;
            } else if (currItem == input[i] && occurCounter >= 2) {
                // Rearrange the array
                for (int j = i + 1; j < input.length - swapCounter; j++) {
                    int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
                --i;
                ++swapCounter;
            } else {
                occurCounter = 0;
            }
        }

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        return input.length - swapCounter;
    }

    public static boolean canJump(int[] nums) {
        System.out.println(nums.length);
        for (int i = nums[0]; i < nums.length; i++) {
            int step = nums[i];
            System.out.println("step " + step + " index " + i);
            if (step == 0) {
                return false;
            }

            if (step + i == nums.length - 1) {
                return true;
            } else if (step + i < nums.length) {
                i = step + i - 1;
            } else {
                return false;
            }
        }
        return false;
    }

    private static void monotonicStack(int[] arr) {
        Stack<Integer> incrementalStack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!incrementalStack.isEmpty()
                    && incrementalStack.peek() > arr[i]) {
                incrementalStack.pop();
            }
            incrementalStack.push(arr[i]);
            System.out.println(" stack " + incrementalStack);
        }
        System.out.println(" final stack " + incrementalStack);
    }

    private static void SW_largestSum(int[] array, int k) {

    }


}

package DSA.DP;

public class Knapsack {

    public static void main(String[] args) {

        int[] value = {1, 4, 5, 7};
        int[] weight = {1, 3, 4, 5};
        System.out.println(knapsackRecursion(value, weight, 11, 4));
    }

    private static int knapsackRecursion(int[] val, int[] weight, int sum, int index) {
        if(index == 0 || sum == 0) {
            return 0;
        }

        if(weight[index - 1] <= sum) {
            return Math.max(
                    val[index - 1] + knapsackRecursion(val, weight, sum - weight[index - 1], index - 1),
                    knapsackRecursion(val, weight, sum, index -1));
        } else {
            return knapsackRecursion(val, weight, sum, index - 1);
        }
    }
}

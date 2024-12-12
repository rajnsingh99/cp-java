package DSA.DP;

public class Knapsack {

    private static int[][] cache;

    public static void main(String[] args) {

        int[] value = {1, 4, 5, 7};
        int[] weight = {1, 3, 4, 5};
        cache = new int[value.length + 1][12];
        initaliseCache();
        System.out.println(knapsackRecursion(value, weight, 11, 4));
        System.out.println();

        knapsackTopdown(value, weight, 7, 4);
    }

    private static void initaliseCache() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 12; j++) {
                cache[i][j] = -1;
            }
        }
    }

    private static int knapsackRecursion(int[] val, int[] weight, int sum, int index) {
        if(index == 0 || sum == 0) {
            return 0;
        }

        if(cache[index][sum] != -1) {
            System.out.println("cache -> " + cache[index][sum]);
            return cache[index][sum];
        }

        if(weight[index - 1] <= sum) {
            cache[index][sum] = Math.max(
                    val[index - 1] + knapsackRecursion(val, weight, sum - weight[index - 1], index - 1),
                    knapsackRecursion(val, weight, sum, index -1));
        } else {
            cache[index][sum] = knapsackRecursion(val, weight, sum, index - 1);
        }

        return cache[index][sum];
    }

    private static void knapsackTopdown(int[] val, int[] wt, int sum, int n) {
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
                   t[i][0] = 0;
        }

        for (int i = 0; i < sum + 1; i++) {
            t[0][i] = 0;
        }

        int w = sum;
        for(int i =1; i< n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {

                if(wt[n -1] <= w) {
                    t[n][w] = Math.max(val[n-1] + t[n-1][w - wt[n - 1]], t[n - 1][w]);
                } else {
                    t[n][w] = t[n -1][w];
                }
            }
        }

        System.out.println(t[n][sum]);
    }
}

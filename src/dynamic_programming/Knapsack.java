package dynamic_programming;

public class Knapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int maxProfits = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] >= capacity) continue;

            for (int j = 0; j < weights.length; j++) {
                if (weights[i] + weights[j] <= capacity) {
                    maxProfits = Math.max(maxProfits, (profits[i] + profits[j]));
                }
            }
        }
        return maxProfits;
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
//        int[] profits = {1, 6, 10, 16};
//        int[] weights = {1, 2, 3, 5};
        int[] weights = {2, 3, 1, 4};
        int[] profits = {4, 5, 3, 7};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 5);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
package dynamic_programming;

import java.util.Arrays;

public class Main {
    static int[] memoization;

    public static void main(String[] args) {
        int n = 4;
        memoization = new int[n + 1];
        System.out.println(bottomUpFibo(n));
    }

    public static int topDownFibo(int n) {
        if (n <= 1) {
            return n;
        }

        if (memoization[n] != 0) {
            return memoization[n];
        }

        memoization[n] = topDownFibo(n - 1) + topDownFibo(n - 2);
        return memoization[n];
    }

    public static int bottomUpFibo(int n) {
        memoization[1] = 1;
        for (int i = 2; i <= n; i++) {
            memoization[i] = memoization[i - 1] + memoization[i - 2];
        }

        return memoization[n];
    }
}

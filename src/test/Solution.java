package test;

public class Solution {

    public int[] solution2(int[] grade) {
        int[] answer = new int[grade.length];
        int[] sortGrade = new int[grade.length];

        System.arraycopy(grade, 0, sortGrade, 0, sortGrade.length);
        shellSort(sortGrade, sortGrade.length);

        int max = sortGrade[0];
        int rank = 0;
        for (int i = 0; i < grade.length; i++) {
            /*
            * {3, 2, 1, 2}
            * {3, 2, 2, 1}
            *
            * */
        }

        return answer;
    }

    public void shellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2) {
            if (h % 2 == 0) {
                ++h;
            }

            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] < tmp; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = tmp;
            }
        }
    }

    public int solution3(int n) {
        int answer = 0;

        while (true) {
            if (n % 5 == 0) {
                return n / 5 + answer;
            } else if (n <= 0) {
                return -1;
            }

            n = n - 3;
            answer++;
        }
    }

    public int[] solution4(int N, int[] coffee_times) {
        int[] answer = new int[coffee_times.length];
        int[] cloneTimes = new int[coffee_times.length];
        int idx = 0;
        boolean[] complete = new boolean[coffee_times.length];

        System.arraycopy(coffee_times, 0, cloneTimes, 0, coffee_times.length);

        while (!isEmpty(cloneTimes)) {
            int tmp = N;
            for (int i = 0; i < cloneTimes.length; i++) {
                if (tmp == 0) break;

                if (cloneTimes[i] != 0) {
                    --cloneTimes[i];
                    --tmp;
                }

                if (cloneTimes[i] == 0) {
                    if (!complete[i]) {
                        answer[idx] = i + 1;
                        complete[i] = true;
                        ++idx;
                    }
                }
            }
        }

        return answer;
    }

    public boolean isEmpty(int[] coffee_times) {
        for (int coffee_time : coffee_times) {
            if (coffee_time > 0) {
                return false;
            }
        }

        return true;
    }
}

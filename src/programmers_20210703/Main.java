package programmers_20210703;

// 76501
public class Main {
    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};

        // true : 양수, false : 음수
        boolean[] signs = {true, false, true};

        Solution solution = new Solution();
        System.out.println(solution.solution(absolutes, signs));
    }
}

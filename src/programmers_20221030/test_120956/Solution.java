package programmers_20221030.test_120956;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
//        String[] arr = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        String[] arr = {"aya", "yee", "u", "maa", "wyeoo"};

        System.out.println(solution(arr));
    }

    public static int solution(String[] babbling) {
        // "11", "uuu1", "1", "111", "1a"

        return (int) Arrays.stream(babbling)
                .map(i -> i.replace("aya", "1"))
                .map(i -> i.replace("ye", "1"))
                .map(i -> i.replace("woo", "1"))
                .map(i -> i.replace("ma", "1"))
                .map(i -> i.replace("1", ""))
                .filter(String::isEmpty)
                .count();
    }
}

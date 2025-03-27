package baekjoon_20250327.test_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int count = Integer.parseInt(br.readLine());
    //
    //     String[] inputs = new String[count];
    //
    //     for (int i = 0; i < count; i++) {
    //         inputs[i] = br.readLine();
    //     }
    //
    //     for (String input : inputs) {
    //         char[] chars = input.toCharArray();
    //         int psCount = 0;
    //
    //         for (char character : chars) {
    //             if ('(' == character) {
    //                 psCount++;
    //             }
    //
    //             if (')' == character) {
    //                 psCount--;
    //             }
    //
    //             if (psCount < 0) {
    //                 break;
    //             }
    //         }
    //
    //         System.out.println(psCount != 0 ? "NO" : "YES");
    //     }
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] inputs = new String[count];

        for (int i = 0; i < count; i++) {
            inputs[i] = br.readLine();
        }

        for (String input : inputs) {
            char[] chars = input.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (char character : chars) {
                if ('(' == character) {
                    stack.push(character);
                } else if (')' == character && stack.isEmpty()) {
                    isValid = false;
                    break;
                } else if (')' == character) {
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            System.out.println(isValid ? "YES" : "NO");
        }
    }
}

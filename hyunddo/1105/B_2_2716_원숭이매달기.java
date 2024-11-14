package day1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_2_2716_원숭이매달기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < T; t++) {
            String ch = br.readLine().trim();
            if (ch.length() == 0) {
                sb.append(1).append('\n');
                continue;
            }

            Stack<Character> stack = new Stack<>();
            int answer = 0;

            for (int i = 0; i < ch.length(); i++) {
                if (ch.charAt(i) == '[') {
                    stack.push(ch.charAt(i));
                } else {
                    answer = Math.max(answer, stack.size());
                    stack.pop();
                }
            }
            sb.append((int)Math.pow(2, answer)).append('\n');
        }
        System.out.println(sb);
    }
}
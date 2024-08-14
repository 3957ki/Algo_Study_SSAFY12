import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        String answer = br.readLine();

        int result = 0;

        result = makeStr(input, answer);
        System.out.println(result);

    }

    public static int makeStr(String input, String answer) {
        int reverse_num = Integer.MAX_VALUE;
        if (input.length() != answer.length()) {
            return -1;
        }
        int[] input_count = new int[26];
        int[] answer_count = new int[26];
        for (int i = 0; i < input.length(); i++) {
            input_count[input.charAt(i) - 'A'] += 1;
            answer_count[answer.charAt(i) - 'A'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (input_count[i] != answer_count[i]) return -1;
        }
        int count = 0;
        char[] input_arr = input.toCharArray();
        char[] answer_arr = answer.toCharArray();

        int input_idx = input.length()-1;
        int answer_idx = input.length()-1;

        while (input_idx>=0) {
            if (input_arr[input_idx] == answer_arr[answer_idx]) {
                answer_idx--;
            } else count++;
            input_idx--;
        }
        return count;
    }

//    private static boolean Reverse(char[] input, char[] answer) {
//        for (int i = 0; i < input.length; i++) {
//            if (input[input.length - 1 - i] != answer[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
}
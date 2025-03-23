package study20250123;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_17255_N으로만들기 {
    static int N;
    static Set<String> uniquePaths;
    static int length;
    static char[] digits;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        length = input.length();
        N = Integer.parseInt(input);
        digits = input.toCharArray();
        uniquePaths = new HashSet<>();

        for (int i = 0; i < length; i++) {
            solve(i, i, String.valueOf(digits[i]), String.valueOf(digits[i]));
        }
        
        System.out.println(uniquePaths.size());
        sc.close();
    }

    private static void solve(int left, int right, String current, String path) {
        if (left == 0 && right == length - 1) {
            uniquePaths.add(path);
            return;
        }

        if (left > 0) {
            solve(left - 1, right, 
                  digits[left - 1] + current, 
                  path + " " + digits[left - 1] + current);
        }

        // Expand to the right
        if (right < length - 1) {
            solve(left, right + 1, 
                  current + digits[right + 1], 
                  path + " " + current + digits[right + 1]);
        }
    }
}

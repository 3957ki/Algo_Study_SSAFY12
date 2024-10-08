package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2_16456 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int answer;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N == 1 || N == 2) {
            System.out.println(1);
            return;
        } else if (N == 3) {
            System.out.println(2);
            return;
        }
        dp = new long[N+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 3]) % 1_000_000_009;
        }
        System.out.println(dp[N]);
    }


}

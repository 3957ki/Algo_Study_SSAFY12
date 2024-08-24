package src.study0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2번_호반우상인의이상한품질계산법_그리디 {
    static int N;
    static int[] cow;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cow = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cow[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        Arrays.sort(cow);
        if (N % 2 == 0) {
            for (int i = N/2; i < N; i++) {
                sum += cow[i] * 2;
            }
        } else {
            for (int i = N/2+1; i < N; i++) {
                sum += cow[i] * 2;
            }
            sum += cow[N/2];
        }

        System.out.println(sum);
    }
}


package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//5
//2 2
//3 4
//5 6
//1 9
//-2 -8
public class BOJ_1_Greedy_14400 {
    static int N;
    static int[] x;
    static int[] y;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        x = new int[N];
        y = new int[N];
        int xSum = 0;
        int ySum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            xSum += x[i];
            ySum += y[i];
        }
        double[] s = {(double) xSum / N, (double) ySum / N};
        int[][] store = {
                {(int) Math.ceil(s[0]), (int) Math.ceil(s[1])},
                {(int) Math.floor(s[0]),(int) Math.floor(s[1])},
                {(int) Math.floor(s[0]), (int) Math.ceil(s[1])},
                {(int) Math.ceil(s[0]), (int) Math.floor(s[1])},
        };
        int lowDistance = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int distance = 0;

            for (int j = 0; j < N; j++) {
                distance += Math.abs(store[i][0] - x[j]) + Math.abs(store[i][1] - y[j]);
            }
            lowDistance = Math.min(distance, lowDistance);
        }

        System.out.println(lowDistance);
    }
}

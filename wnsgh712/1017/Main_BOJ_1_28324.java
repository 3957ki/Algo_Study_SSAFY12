package src.algo1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1_28324 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] section;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        section = new int[N];
        int[] speed = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            section[i] = Integer.parseInt(st.nextToken());
        }
        speed[N-1] = 1;
        long answer = 1;
        for (int i = N-2; i >= 0; i--) {
            speed[i] += Math.min(section[i], speed[i+1] + 1);
            answer += speed[i];
        }


        System.out.println(answer);
    }
}

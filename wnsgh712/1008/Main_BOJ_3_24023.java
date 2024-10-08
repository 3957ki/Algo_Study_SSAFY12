package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3_24023 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 될 때까지 늘린다.
        // 안되면 해당 인덱스 바로 다음부터 다시 시작
        // 어쩌면 안되나? 현재 값과 K값의 & 결과가 0이면 끝
        int s = 0;
        int curSum = 0;
        for (int i = 0; i < N; i++) {
            int cur =  Integer.parseInt(st.nextToken());
            curSum |= cur;
            if (curSum == K) {
                System.out.println((s + 1) + " " + (i + 1));
                return;
            }
            if ((cur | K) != K || curSum > K) {
                s = i + 1;
                curSum = 0;
            }
        }

        System.out.println(-1);


    }
}
/*
5 7
8 1 2 3 7
5 7
8 10 1 2 55
5 7
10 10 10 10 7
5 7
7 10 10 10 10
5 6
1 5 2 4 1
 */
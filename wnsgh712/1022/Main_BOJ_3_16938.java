package src.algo1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3_16938 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, L, R, X;
    static int[] p;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        p = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(answer);

    }
    static int answer;
    // pSum 문제 난이도 합
    // hard, easy 가장 어렵/쉬운 문제
    private static void solution(int cur, int pSum, int easy, int hard) {

        if (cur == N) {
            if (pSum < L || pSum > R) return;
            if (hard - easy < X) return;
            answer++;
            return;
        }
        // 문제 안고르기
        solution(cur + 1, pSum, easy, hard);

        // 문제 고르기
        solution(cur + 1, pSum + p[cur], Math.min(easy, p[cur]), Math.max(hard, p[cur]));
    }

}
/*
 문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다
 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같다
N, L, R, X
N = 15

 캠프에 사용할 문제를 고르는 방법의 수
 */

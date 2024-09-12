package algo0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합하고
// log(10^8) ~= 26
// 이분 탐색
public class Main_BOJ_18114_블랙프라이데이 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] w;
    static int N, C;
    static int R = 3;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        w = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
            sum += w[i];
        }
        if (sum < C) {
            System.out.println(0);
            return;
        }

        System.out.println(이분탐색() ? 1 : 0);

    }

    private static boolean 이분탐색() {
        int start = 1;
        int end = 100_000_000;
        int cur = (start + end) / 2;

        while (start <= end) {
            flag = false;
            조합(0, cur);
            if (flag) {
                // 조합이 성공하면 가격
            }
            return false;
        }
    }

    static boolean flag = false;
    private static void 조합(int prev, int price) {
        if (price > C) return;
        if (price == C) {
            flag = true;
            return;
        }

        for (int i = prev; i < N; i++) {

            조합(i+1, price+);
        }
    }
}
/*
5 5
1 2 3 4 5
 */
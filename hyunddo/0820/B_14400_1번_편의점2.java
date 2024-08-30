package day0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14400_1번_편의점2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x);
        Arrays.sort(y);

        // 중간값을 기준으로 Manhattan 거리 합계 계산
        int medianX1 = x[n / 2];
        int medianY1 = y[n / 2];
        int answer1 = 0;
        for (int i = 0; i < n; i++) {
            answer1 += Math.abs(x[i] - medianX1) + Math.abs(y[i] - medianY1);
        }

        // 짝수 개수일 경우, 두 중간값 중 하나를 고려하여 거리 합계 계산
        int medianX2 = x[(n / 2) - 1];
        int medianY2 = y[(n / 2) - 1];
        int answer2 = 0;
        for (int i = 0; i < n; i++) {
            answer2 += Math.abs(x[i] - medianX2) + Math.abs(y[i] - medianY2);
        }

        // 두 계산 중 최솟값을 선택
        System.out.println(Math.min(answer1, answer2));
    }
}

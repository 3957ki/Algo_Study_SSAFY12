package study20250417;

import java.io.*;
import java.util.*;

public class Main_15553_난로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] t = new int[N];
        for (int i = 0; i < N; i++) t[i] = Integer.parseInt(br.readLine());
        Arrays.sort(t);
        
        // 간격 추출하고 정렬
        Integer[] gaps = new Integer[N-1];
        for (int i = 1; i < N; i++) gaps[i-1] = t[i] - t[i-1];
        Arrays.sort(gaps);
        
        // 정답 계산: 기본 N명 + 합쳐야 할 간격
        long ans = N;
        for (int i = 0; i < N-K; i++) ans += gaps[i] - 1;
        
        System.out.println(ans);
    }
}
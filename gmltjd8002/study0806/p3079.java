package study0806;

import java.io.*;
import java.util.*;

public class p3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 게이트 수
        long m = Long.parseLong(st.nextToken()); // 사람 수

        long[] arr = new long[n]; // 게이트 당 시간
        long max = 0;

        for (int i = 0; i < n; i++) { //시간 배열, 한 게이트 당 최대시간 값 받기
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long low = 0;
        long high = max * m; // 최악의 경우

        while (low < high) {
            long mid = (high + low) / 2;
            long sumPerson = 0;

            for (long i : arr) {
                sumPerson += mid / i;
                if (sumPerson >= m) break; // 이미 기존보다 크면 루프 나가기
            }

            if (sumPerson >= m) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }
}
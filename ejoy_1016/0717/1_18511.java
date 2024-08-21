package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Algo0717 {
    
    static String N;    
    static int nLen = 0;
    static int[] nArr;
    
    static int K;
    static Integer[] kArr;
    
    static int result = 0;

    // 깊이 우선 탐색 함수
    public static void dfs(int depth, int currentNum) {
        if (depth == nLen) {
            if (currentNum <= Integer.parseInt(N) && currentNum > result) {
                result = currentNum; // 더 큰 값으로 갱신
            }
            return;
        }

        for (int i = 0; i < K; i++) { // 오름차순 탐색
            int nextNum = currentNum * 10 + kArr[i];
            if (nextNum <= Integer.parseInt(N)) {
                dfs(depth + 1, nextNum); // 다음 자리로 이동
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.next(); // 목표 숫자 N
        nLen = N.length(); // N의 자리 수
        K = sc.nextInt(); // K의 원소 개수

        kArr = new Integer[K];
        for (int i = 0; i < K; i++) {
            kArr[i] = sc.nextInt(); // K의 원소들을 배열에 저장
        }

        // K 배열을 내림차순으로 정렬
        Arrays.sort(kArr, Comparator.reverseOrder());

        // DFS 탐색 시작 (초기 currentNum은 0)
        dfs(0, 0);

        // 결과 출력
        System.out.println(result);
        sc.close();
    }
}

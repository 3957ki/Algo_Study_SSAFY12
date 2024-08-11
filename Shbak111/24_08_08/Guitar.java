package 실전코테스터디.Algo_0808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  V[i]는 i번째 곡을 연주하기 전에 바꿀 수 있는 볼륨을 의미
 *  현재 볼륨이 P이고 지금 i번째 곡을 연주하기 전이라면, i번 곡은 P+V[i]나 P-V[i] 로 연주해야 한다
 *  0보다 작은 값으로 볼륨을 바꾸거나, M보다 큰 값으로 볼륨을 바꿀 수 없다.
 *
 *  곡의 개수 N과 시작 볼륨 S, 그리고 M이 주어졌을 때, 마지막 곡을 연주할 수 있는 볼륨 중 최댓값을 구하는 프로그램을 작성하시오
 *  모든 곡은 리스트에 적힌 순서대로 연주
 *  만약 마지막 곡을 연주할 수 없다면 (중간에 볼륨 조절을 할 수 없다면) -1을 출력
 */


public class Guitar {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/guitar.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        int[] V = new int[N];
        int[][] dp = new int [N + 1][max + 1];
        boolean[][] possible = new boolean[N + 1][max + 1];

        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for(int i = 0;i < N;i++){
            V[i] = Integer.parseInt(st2.nextToken());
        }

        possible[0][start] = true;
        int plus = 0;
        int minus = 0;
        for(int i = 1;i < N + 1;i++){
            for(int j = 0; j< max + 1;j++){
                if(possible[i-1][j]){
                    plus = j + V[i - 1];
                    minus = j - V[i - 1];
                    if(plus < max + 1) possible[i][plus] = true;
                    if(minus >= 0) possible[i][minus] = true;
                }
            }
        }
        int answer = -1;
        for(int i = 0;i < max + 1;i++){
            if(possible[N][i]){
                answer = i;
            }
        }
        System.out.println(answer);
    }
}

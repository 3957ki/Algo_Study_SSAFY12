import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *  2+1중에 가장 싼 것은 무료로 지불
 *  한 번에 3개의 유제품을 사지 않는다면 할인 없이 정가를 지불
 *   최소비용으로 유제품을 구입
 *
 *    유제품의 수 N (1 ≤ N ≤ 100,000)
 *    N개의 줄에는 각 유제품의 가격 Ci (1 ≤ Ci ≤ 100,000)
 *
 *    일단 무조건 3개 묶어야되.
 *    근데 비싼거
 */

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\실전코테스터디\\Algo_0822\\B_11508_21세일\\b_11508.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0;i < N;i++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        int sum = 0;
        if(N % 3 == 0){
            for(int i = N - 1;i >= 0;i = i - 3){
                sum = sum + arr[i] + arr[i-1];
            }
        } else if(N % 3 == 1) {
            for(int i = N - 1;i >= 1;i = i - 3){
                sum = sum + arr[i] + arr[i-1];
            }
            sum += arr[0];
        } else if(N % 3 == 2) {
            for(int i = N - 1;i >= 2;i = i - 3){
                sum = sum + arr[i] + arr[i-1];
            }
            sum += arr[0];
            sum += arr[1];
        }

        System.out.println(sum);
    }
}
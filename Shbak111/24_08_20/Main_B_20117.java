import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  모든 호반우의 품질을 묶음의 '중앙값'으로 결정하게 된다.
 *  묶음이 짝수인 경우 묶음 안에 있는 호반우를 품질을 기준으로 정렬했을 때 (묶음 개수/2+1)번째 호반우를 중앙값으로 정의
 *  홀수인 경우 ((묶음 개수+1)/2)번째 호반우를 중간값으로 정의
 *
 *  일단은 부분집합인듯? 근데 시간초과 해결을 어케하지...
 *  기억이 안나네..
 *
 */
public class Main_B_20117 {
    static int[] arr;
    static int N;
    static boolean[] selected;
    static int result = 0;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\실전코테스터디\\Algo_0820\\B_20117_호반우상인\\hoban.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new boolean[N];
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for(int i = 0;i < N;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        if(N % 2 == 0){
            for(int i = 0;i < N/2;i++){
                result += arr[N - i - 1] * 2;
            }
        } else {
            for(int i = 0;i < N/2;i++){
                result += arr[N - i - 1] * 2;
            }
            result += arr[N/2];
        }

        System.out.println(result);
    }
}
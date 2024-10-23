import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 그러니까 원래 배열 P에서 i번째 카드를 가져온다는 의미
 */

public class Main_B_22858 {
    static int N;
    static int K;
    static int[] arr;
    static int[] Darr;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\실전코테스터디\\Algo_0827\\B_22858_원상복구\\b_22858.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        Darr = new int[N + 1];
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for(int i = 1;i < N + 1;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        StringTokenizer st3 = new StringTokenizer(bf.readLine());
        for(int i = 1;i < N + 1;i++){
            Darr[i] = Integer.parseInt(st3.nextToken());
        }

        for(int i = 0;i < K;i++){
            int[] prev = new int[N+1];
            for(int j = 1;j < N + 1;j++){
                prev[Darr[j]] = arr[j];
            }
            arr = prev;

            //System.out.println(Arrays.toString(arr));
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 1;i < arr.length;i++){
            builder.append(arr[i]).append(" ");
        }
        System.out.println(builder);
    }
}
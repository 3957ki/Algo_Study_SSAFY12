import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob1_14469 {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //입장시간 순서대로 정렬
        Arrays.sort(arr, (o1, o2)-> o1[0]-o2[0]);

        /*
         * 초기값 : 현재 소 도착시간 + 현재 소 검문 시간
         * 이전 소 입장시간 < 현재 소 도착시간 -> 현재 소 도착시간 + 현재 소 검문시간
         * 이전 소 입장시간 > 현재 소 도착시간 -> 이전 소 입장시간 + 현지 소 검문시간
         */
        int enter = arr[0][0] + arr[0][1];;
        for(int i=1; i<N; i++){
            if(enter < arr[i][0]) enter = arr[i][0] + arr[i][1];
            else enter += arr[i][1];
        }

        System.out.println(enter);


    }
}

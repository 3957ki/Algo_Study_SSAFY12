import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_벼락치기 {
    static int N,T;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        int total = 0;
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //시간
            arr[i][1] = Integer.parseInt(st.nextToken()); //벌금
            total += arr[i][1];
        }


        int[] dp = new int[T+1];
        for (int i=0;i<N;i++) {
        	int time = arr[i][0];
        	int money = arr[i][1];
        	for (int j=T;j>=1;j--) {
        		if (j>=time) {
        			dp[j] = Math.max(dp[j], dp[j-time]+money);
        		}
        	}
        }
        System.out.println(total - dp[T]);

    }
}

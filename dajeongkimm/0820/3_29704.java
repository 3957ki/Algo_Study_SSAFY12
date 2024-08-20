import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3 {
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


        int[][] dp = new int[N+1][T+1];
        for (int i=1;i<=N;i++){
            for (int j=1;j<=T;j++){
                if (arr[i-1][0] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i-1][0]]+arr[i-1][1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(total - dp[N][T]);

    }
}

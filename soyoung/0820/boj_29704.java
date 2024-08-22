import java.io.*;
import java.util.*;

public class boj_29704 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int totalCost = 0;
        int[] dp = new int[T+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            totalCost += cost;

            for(int j=T; j>=day; j--){
                dp[j] = Math.max(dp[j], dp[j-day]+cost);
            }
        }

        bw.write(totalCost - dp[T]+" ");
        bw.close();

    }
}


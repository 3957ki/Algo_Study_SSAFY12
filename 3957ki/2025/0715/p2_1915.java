import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2_1915 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= M; j++){
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        int[][] dp = new int[N+1][M+1];
        int answer = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == 0) continue;
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer*answer);

    }
}
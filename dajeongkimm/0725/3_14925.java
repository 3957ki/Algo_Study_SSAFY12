import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][N];
        boolean zero = false;
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        int[][] dp = new int[M][N];

        int answer = 0;

        // 첫번째 행 초기화
        for (int j=0;j<N;j++){
            if (arr[0][j] == 0) dp[0][j] = 1;

        }
        // 첫번째 열 초기화
        for (int i=0;i<M;i++){
            if (arr[i][0] == 0) dp[i][0] = 1;
        }

        for (int i=1;i<M;i++){
            for (int j=1;j<N;j++){
                if (arr[i][j] == 0){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]),dp[i][j-1]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }

            }
        }
//        for (int i=0;i<M;i++){
//            for (int j=0;j<N;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        System.out.println(answer);

    }
}
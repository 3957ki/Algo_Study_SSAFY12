import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_ {
    static int n,m,k;

    static int[][] cost;
    static int[] home;

    static int INF = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cost = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = INF;
            }
            cost[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
//            if (cost[a][b] > c) cost[a][b] = c;
            cost[a][b] = c;
        }

        k = Integer.parseInt(br.readLine());

        home = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            home[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cost[i][j] > cost[i][k] + cost[k][j]) cost[i][j] = cost[i][k] + cost[k][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        int[] distance_array = new int[n + 1];

        for (int x = 1; x <= n; x++) {
            int tmp = 0;
            for (int j = 0; j < k; j++) {
                int h = home[j];
                tmp = Math.max(cost[h][x] + cost[x][h], tmp);
            }
            distance_array[x] = tmp;
            answer = Math.min(answer, tmp);

        }

        for (int i=1;i<=n;i++){
            if (distance_array[i] == answer) {
                System.out.print(i+" ");
            }
        }
    }
}

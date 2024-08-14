import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class one {
    static int n;
    static int[][] arr;

    static int answer;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;

        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<n;i++){
            visited[i] = true;
            DFS(i,i,1,0);
            visited[i] = false;
        }
        System.out.println(answer);




    }
    private static void DFS(int start, int cur, int cnt, int cur_cost){
        if (cnt == n){
            if (arr[cur][start] != 0){
                int total_cost = cur_cost + arr[cur][start];
                if (total_cost < answer) answer = total_cost;
            }

            return;
        }
        if (cur_cost > answer) return;

        for (int i=0;i<n;i++){
            if (!visited[i] && arr[cur][i] != 0) {
                visited[i] = true;
                DFS(start, i, cnt+1, cur_cost + arr[cur][i]);
                visited[i] = false;
            }
        }
    }
}
package 실전코테스터디.Algo_0808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TravelingSales {
    public static int answer = Integer.MAX_VALUE;

    public void DFS(int[][] W, boolean[] visited, int start, int next, int sum, int level) {
        if (level == W.length) {
            if(W[next][start] == 0) return; // <- 이거 조건 하나 때문에 못풀었음. 이게 의미하는 바가 뭘까
            answer = Math.min(sum + W[next][start], answer);
            return;
        }

        for (int i = 0; i < W.length; i++) {
            if (!visited[i] && W[next][i] != 0 && i != start) {
                visited[i] = true;
                DFS(W, visited, start, i, sum + W[next][i], level + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/travelingsale.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] W = new int[N][N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        TravelingSales tv = new TravelingSales();
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            tv.DFS(W, visited, i, i, 0, 1);
            visited[i] = false;
        }
        System.out.println(answer);
    }
}
package src.algo1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_4_15573 {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이분 탐색
        lowerBound();
    }

    public static int lowerBound() {
        int s = 0, e = 1_000_000;
        while (s <= e) {
            return 1;
        }
        return 0;
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean bfs(int d, int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int cnt = 1;
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0], y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > d) continue;
                if (++cnt == K) return true;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return false;
    }
}

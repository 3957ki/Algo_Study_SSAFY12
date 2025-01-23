import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출하기 {

    static int dr[] = {-1, 1, 0, 0};    //U D L R
    static int dc[] = {0, 0, -1, 1};

    static int N, M, answer;
    static boolean dfsvisited[][], wholevisited[][];
    static int map[][];
    static Queue<int[]> path;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        wholevisited = new boolean[N][M];
        dfsvisited = new boolean[N][M];
        path = new ArrayDeque<>();
        answer = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                char tmp = input.charAt(j);

                int dir = -1;
                if (tmp == 'U') dir = 0;
                else if (tmp == 'D') dir = 1;
                else if (tmp == 'L') dir = 2;
                else dir = 3;

                map[i][j] = dir;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!wholevisited[i][j] && !dfsvisited[i][j]) {
                    dfsvisited[i][j] = true;
                    path.clear();
                    path.add(new int[]{i, j});
                    dfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    static void dfs(int i, int j) {
        int dir = map[i][j];
        int ni = i + dr[dir];
        int nj = j + dc[dir];

        if ((ni >= N) || (nj >= M) || (ni < 0) || (nj < 0)) {
            check();
            return;
        }

        if (wholevisited[ni][nj]) {
            wholevisited[i][j] = true;
            check();
            return;
        }

        if (dfsvisited[ni][nj]) return;

        dfsvisited[ni][nj] = true;
        path.add(new int[]{ni, nj});
        dfs(ni, nj);
    }

    static void check() {
        while (!path.isEmpty()) {
            int arr[] = path.poll();

            int r = arr[0];
            int c = arr[1];

            wholevisited[r][c] = true;
            answer++;
        }
    }
}
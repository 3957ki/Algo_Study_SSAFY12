import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선발명단 {
    static int max;
    static int map[][];
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            map = new int[11][11];

            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = Integer.MIN_VALUE;
            visited = new boolean[11];
            dfs(0, 0);

            System.out.println(max);
        }
    }

    static void dfs(int index, int total) {
        if (index == 11) {
            max = Math.max(max, total);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (map[i][index] == 0) continue;
            if (visited[i]) continue;
            visited[i] = true;
            dfs(index + 1, total + map[i][index]);
            visited[i] = false;
        }
    }
}
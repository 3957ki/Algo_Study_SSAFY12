package day0813;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class b_q1986_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        int map[][] = new int[n + 1][m + 1];
        StringTokenizer st_q = new StringTokenizer(br.readLine());
        int num_q = Integer.parseInt(st_q.nextToken()); // queen
        int arr_q[][] = null;
        if (num_q > 0) {
            arr_q = new int[num_q][2];
            for (int i = 0; i < num_q; i++) {
                arr_q[i][0] = Integer.parseInt(st_q.nextToken());
                arr_q[i][1] = Integer.parseInt(st_q.nextToken());
                map[arr_q[i][0]][arr_q[i][1]] = 4;
            }
        }
        StringTokenizer st_k = new StringTokenizer(br.readLine());
        int num_k = Integer.parseInt(st_k.nextToken());
        int arr_k[][] = null;
        if (num_k > 0) {
            arr_k = new int[num_k][2];
            for (int i = 0; i < num_k; i++) {
                arr_k[i][0] = Integer.parseInt(st_k.nextToken());
                arr_k[i][1] = Integer.parseInt(st_k.nextToken());
                map[arr_k[i][0]][arr_k[i][1]] = 3;
            }
        }
        StringTokenizer st_p = new StringTokenizer(br.readLine());
        int num_p = Integer.parseInt(st_p.nextToken());
        if (num_p > 0) {
            for (int i = 0; i < num_p; i++) {
                map[Integer.parseInt(st_p.nextToken())][Integer.parseInt(st_p.nextToken())] = 2;
            }
        }
        if (num_q > 0) {
			int dy[] = { -1, 1, 1, -1, -1, 0, 1, 0 }; // 오른쪽위, 오른쪽 아래, 왼쪽아래, 왼쪽위
            int dx[] = { 1, 1, -1, -1, 0, 1, 0, -1 };
            
            for (int i = 0; i < num_q; i++) {
                int a = arr_q[i][0];
				int b = arr_q[i][1];
                for (int k = 0; k < 8; k++) {
					 int newy = a + dy[k];
					 int newx = b + dx[k];
                     while (newy > 0 && newy <= n && newx > 0 && newx <= m) {
                     	if (map[newy][newx] > 1)
                             break;
                     	map[newy][newx] = 1;
						newy = newy + dy[k];
                     	newx = newx + dx[k];
					}
                }
            }
        }
        if (num_k > 0) {
            int dx[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
            int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
            for (int i = 0; i < num_k; i++) {
                for (int k = 0; k < 8; k++) {
					int y = arr_k[i][0] + dy[k];
                    int x = arr_k[i][1] + dx[k];
                    if (y > 0 && y <= n && x > 0 && x <= m) {
                        if (map[y][x] == 0)
                            map[y][x] = 1;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(map[i][j] ==0)
                    answer++;
            }
        }
        System.out.println(answer);
    }
}
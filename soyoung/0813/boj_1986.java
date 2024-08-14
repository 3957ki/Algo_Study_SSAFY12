import java.util.*;
import java.io.*;

public class boj_1986 {
    static boolean[][] check;
    static char[][] board;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;

                if (i == 0) {
                    board[x][y] = 'Q';
                } else if (i == 1) {
                    board[x][y] = 'K';
                } else {
                    board[x][y] = 'P';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'P') {
                    check[i][j] = true;
                } else if (board[i][j] == 'Q') {
                    isValid_Q(i, j);
                } else if (board[i][j] == 'K') {
                    isValid_K(i, j);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    count++;
                }
            }
        }

        bw.write(count + "\n");
        bw.close();
    }

    static void isValid_Q(int x, int y) {
        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

        check[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (board[nx][ny] == 'P' || board[nx][ny] == 'K' || board[nx][ny] == 'Q') {
                    break;
                }

                check[nx][ny] = true;
                nx += dx[i];
                ny += dy[i];
            }
        }
    }

    static void isValid_K(int x, int y) {
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, -1, 1, 2, -2, -2, 2};

        check[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !check[nx][ny]) {
                check[nx][ny] = true;
            }
        }
    }
}

import java.util.*;
import java.io.*;

public class boj_1189 {
    static int R, C, K, ans;
    static char[][] board;
    static int startX, startY, endX, endY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                if(s.charAt(j) == 'T')
                    board[i][j] = 'T';
            }
        }

        startX = R-1;
        startY = 0;
        endX = 0;
        endY = C-1;

        boolean[][] check = new boolean[R][C];
        check[startX][startY] = true;
        dfs(startX, startY, 1, check);

        bw.write(ans+" ");
        bw.close();
    }
    static void dfs(int x, int y, int depth, boolean[][] check){

        if(x==endX && y==endY && depth == K){
            ans++;
            return;
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};


        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=R || ny<0 || ny>=C)
                continue;
            if(check[nx][ny] || board[nx][ny] == 'T')
                continue;

            check[nx][ny] = true;
            dfs(nx, ny, depth+1, check);
            check[nx][ny] = false;
        }
    }
}

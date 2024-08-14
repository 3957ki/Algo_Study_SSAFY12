import java.io.*;
import java.util.*;

public class boj_2589 {
    static int R, C;
    static char[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                board[i][j] = str.charAt(j);
            }
        }
        findLand();
        bw.write(ans + " ");
        bw.close();
    }
    static void findLand(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j] == 'L'){
                    int tmp = bfs(i, j);
                    if(ans < tmp)
                        ans = tmp;
                }
            }
        }
    }
    static int bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        boolean[][] check = new boolean[R][C];
        int[][] dist = new int[R][C];
        int max = Integer.MIN_VALUE;

        q.add(new Point(x, y));
        check[x][y] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx>=R || ny<0 || ny>=C)
                    continue;
                if(check[nx][ny] || board[nx][ny] == 'W')
                    continue;

                q.add(new Point(nx, ny));
                dist[nx][ny] = dist[p.x][p.y] + 1;
                check[nx][ny] = true;

                if(max < dist[nx][ny])
                    max = dist[nx][ny];
            }
        }
        return max;
    }
}
class Point{
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

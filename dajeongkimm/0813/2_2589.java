import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
    static int n,m;
    static int[][] board;

    static int answer;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
//    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        //육지는 1 바다는 0
        for (int i=0;i<n;i++){
            String tmp = br.readLine();
            for (int j=0;j<m;j++){
                if (tmp.charAt(j) == 'L') board[i][j] = 1;
            }
        }

        answer = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (board[i][j] == 1){
                    // 육지에서 육지로 가는 최단 거리 중 가장 큰 값을 가진 곳에 보물이 ..
                    answer = Math.max(BFS(i,j), answer);
                }
            }
        }
        System.out.println(answer);

    }

    //특정 육지로부터 육지 끝까지 가는 최단 거리
    // BFS는 모든 경로를 가면서 최단 거리 보장
    private static int BFS(int x, int y){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        int[][] visited = new int[n][m];
        visited[x][y] = 1;
        int cnt = 0;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];

            for (int i=0;i<4;i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if (nx>=0 && nx<n && ny>=0 && ny<m && visited[nx][ny] == 0 && board[nx][ny] == 1) {
                    visited[nx][ny] = visited[cur_x][cur_y]+1;
                    cnt = Math.max(visited[nx][ny], cnt);
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return cnt-1;
    }
}
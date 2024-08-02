import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    static int N,M;
    static int[][] R;
    static int[][] G;
    static int[][] B;
    static int[][] avg_arr;
    static int T;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        R = new int[N][M];
        G = new int[N][M];
        B = new int[N][M];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                R[i][j] = Integer.parseInt(st.nextToken());
                G[i][j] = Integer.parseInt(st.nextToken());
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T = Integer.parseInt(br.readLine());
        avg_arr = new int[N][M];
        for (int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                int tmp = (R[i][j] + G[i][j] + B[i][j]) / 3;
//                System.out.println(tmp);
//                System.out.println(T);
                if (tmp >= T) {
                    avg_arr[i][j] = 255;
                }
            }
        }
//        for (int i=0;i<N;i++){
//            for (int j=0;j<M;j++){
//                System.out.print(avg_arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        int answer = 0;
        visited = new boolean[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (avg_arr[i][j] == 255 && !visited[i][j]){
                    BFS(i,j);
                    answer += 1;
                }
            }
        }
        System.out.println(answer);

    }
    private static void BFS(int i, int j){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx>=0 && nx<N && ny>=0 && ny<M && avg_arr[nx][ny]==255 && !visited[nx][ny]){
                    queue.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
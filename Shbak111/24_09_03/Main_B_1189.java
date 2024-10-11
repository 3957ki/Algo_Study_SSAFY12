import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_1189 {
    static int R;
    static int C;
    static int K;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int result = 0;

    static void DFS(int x,int y, int count) {
        if(x == 0 && y == C - 1){
            if(count == K) result++;
            return;
        }

        for(int i = 0;i < dx.length;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 'T') continue;

                visited[nx][ny] = true;
                DFS(nx,ny, count + 1);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\실전코테스터디\\Algo_0903\\B_1189_컴백홈\\b_1189.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0;i < R;i++){
            String line = bf.readLine();
            for(int j = 0;j < C;j++){
                map[i][j] = line.charAt(j);
            }
        }

        visited[R-1][0] = true;
        DFS(R-1, 0, 1);

        System.out.println(result);
    }
}
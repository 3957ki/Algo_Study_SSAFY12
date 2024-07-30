import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int sheep = 0;
    static int wolf = 0;
    static int tmpv = 0;
    static int tmpk = 0;

    public static void DFS(char[][] arr, boolean[][] visited, int x,int y) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for(int i = 0;i < dx.length;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && !visited[nx][ny] && arr[nx][ny] !='#') {
                if(arr[nx][ny] == 'v') {
                    tmpv++;
                }
                else if(arr[nx][ny] == 'k') {
                    tmpk++;
                }
                visited[nx][ny] = true;
                DFS(arr, visited, nx, ny);
            }
        }
        return;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        //System.setIn(new FileInputStream("res/sheepkung.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        boolean[][] visited =new boolean[N][M];

        for(int i = 0;i < N;i++) {
            String line = bf.readLine();
            for(int j = 0;j <M;j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for(int i = 0;i<N;i++) {
            for(int j =0;j < M;j++) {
                visited[i][j] = true;
                DFS(arr, visited,i,j);
                if(tmpk > tmpv) {
                    sheep += tmpk;
                    wolf += 0;
                }
                else {
                    sheep += 0;
                    wolf += tmpv;
                }
                tmpk = 0;
                tmpv = 0;
            }
        }

        System.out.println(sheep + " " + wolf);
    }

}

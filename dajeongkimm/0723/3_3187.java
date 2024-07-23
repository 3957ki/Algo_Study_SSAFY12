import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int R;
    static int C;
    static char[][] arr;
    static int sheep;
    static int wolf;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int answer_sheep;
    static int answer_wolf;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for (int i=0;i<R;i++){
            String input = br.readLine();
            for (int j=0;j<C;j++){
                arr[i][j] = input.charAt(j);
            }
        }
        answer_sheep = 0;
        answer_wolf = 0;
        visited = new boolean[R][C];
        int count = 1;
        for (int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                if (arr[i][j] == '#'){
                    visited[i][j] = true;
                }
                else if (!visited[i][j] && arr[i][j] != '#'){
                    wolf = 0;
                    sheep = 0;
                    DFS(i,j);
//                    System.out.println("Area"+count+++": "+wolf+" "+sheep);
//                    System.out.println("i: "+i+" j: "+j);
                    if (sheep > wolf) {
                        answer_sheep += sheep;
                    } else {
                        answer_wolf += wolf;
                    }
//                    answer_sheep += sheep;
//                    answer_wolf += wolf;
                }
            }
        }
        System.out.println(answer_sheep+" "+answer_wolf);

    }
    private static void DFS(int x, int y){
        if (arr[x][y] == 'v') wolf++;
        if (arr[x][y] == 'k') sheep++;
        visited[x][y] = true;
//        if (sheep>wolf) wolf=0;
//        else sheep = 0;

        for (int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny]){
                if (arr[nx][ny] == '#') continue;
                else DFS(nx,ny);
            }
        }


    }
}
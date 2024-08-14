import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {1,0,0};
    static int[] dy = {0,1,-1};
    static int R, C;
    static int[][] arr;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for (int i=0;i<R;i++){
            String input = br.readLine();
            for (int j=0;j<C;j++){
                arr[i][j] = input.charAt(j)-'0';
            }
        }
        String answer = "NO";
        for (int j=0;j<C;j++){
            if (Electro(j)) {
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);
    }
    private static boolean Electro(int x) {
        boolean[][] visited = new boolean[R][C];
        visited[0][x] = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,x});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            if (cur_x==R-1) return true;

            for (int i=0;i<3;i++){
                int nx = cur_x+dx[i];
                int ny = cur_y+dy[i];

                if (nx>=0 && nx<R && ny>=0 && ny<C){
                    if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] =true;
                    }
                }
            }
        }
        return false;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static boolean[][] avail;

    static int[][] board;

    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        avail = new boolean[n][m];
        // Queen 1, Knight 2, Pawn 3
        board = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i=0;i<num;i++){
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1] = 1;
            avail[x-1][y-1] = true;
        }

        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        for (int i=0;i<num;i++){
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1] = 2;
            avail[x-1][y-1] = true;
        }

        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        for (int i=0;i<num;i++){
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1] = 3;
            avail[x-1][y-1] = true;

        }


        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (board[i][j] == 1){
                    Queen(i,j);
                } else if (board[i][j] == 2){
                    Knight(i,j);
                }
            }
        }

        int answer = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (!avail[i][j]){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
    private static void Queen(int x, int y){
        //가로
        int nx = x;
        int ny = y;
        while (true){
            ny++;
            if (ny<m && board[nx][ny] == 0){
                avail[nx][ny] = true;
            } else break;
        }
        ny = y;
        while (true){
            ny--;
            if (ny>=0 && board[nx][ny] == 0){
                avail[nx][ny] = true;
            } else break;
        }

        //세로
        ny = y;
        while (true){
            nx++;
            if (nx<n && board[nx][ny]==0){
                avail[nx][ny] = true;
            } else break;
        }

        nx = x;
        while (true) {
            nx--;
            if(nx>=0 && board[nx][ny]==0){
                avail[nx][ny] = true;
            } else break;
        }

        //대각선 - 왼쪽 위, 왼쪽 아래, 오른쪽 위, 오른쪽 아래
        nx = x;
        ny = y;
        while (true) {
            nx--;
            ny--;
            if (nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0){
                avail[nx][ny] = true;
            } else break;
        }
        nx = x;
        ny = y;
        while (true) {
            nx--;
            ny++;
            if (nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0){
                avail[nx][ny] = true;
            } else break;
        }
        nx = x;
        ny = y;
        while (true) {
            nx++;
            ny--;
            if (nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0){
                avail[nx][ny] = true;
            } else break;
        }
        nx = x;
        ny = y;
        while (true) {
            nx++;
            ny++;
            if (nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0){
                avail[nx][ny] = true;
            } else break;
        }

    }

    private static void Knight(int x, int y){
        for (int i=0;i<8;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0){
                avail[nx][ny] = true;}
        }

    }
}

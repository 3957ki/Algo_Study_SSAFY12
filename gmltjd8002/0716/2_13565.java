import java.io.*;
import java.util.*;
class Main{
    static int M;
    static int N;
    static int[][] map; // 길
    static boolean[][] isvisit; // 방문여부
    static boolean status = false;
    static int[] dx = {-1,1,0,0}; // 상 하
    static int[] dy = {0,0,-1,1}; // 좌 우
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        isvisit = new boolean[M][N];
        for(int i=0;i<M;i++){ // 행
            String str = br.readLine(); // 띄어쓰기 없으므로 br 바로 사용
            for(int j = 0; j<N;j++){ // 열
                map[i][j] = str.charAt(j) - '0'; // 길 값
            }
        }
        for(int i =0; i<N;i++){ // 0행에서 배열에 0이 존재하는 열값 찾기
            if(map[0][i] == 0){
                dfs(0,i);
            }
        }
        System.out.println(status ? "Yes" : "No"); // dfs돌려서 끝까지 왔는지 체크하는 코드
    }
    public static void dfs(int row, int col){
        isvisit[row][col] = true; // 현재 위치
        if((row == M-1) && (map[row][col] == 0)){ // 맨 아래행까지 도착 & 해당 좌표가 0
            status = true; // 모든 조건 만족(위에서 아래에 도달 시)
            return;
        }
        for(int i =0; i<4;i++){ // 4방향 delta 이동
            int r = row + dx[i];
            int c = col + dy[i];
        
            if(r >=0 && c >= 0 && r<M && c < N && !isvisit[r][c] && map[r][c] == 0) {
                dfs(r,c); // 해당 위치를 기준으로 재귀
            }
        }
    }
}
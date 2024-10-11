import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * n×m 크기의 체스 판
 * Queen, Knight, Pawn의 위치가 주어져 있을 때, 안전한 칸이 몇 칸인지 세는 프로그램을 작성
 * Queen은 가로, 세로, 대각선으로 갈 수 있는 만큼 최대한 많이 이동을 할 수 있는데 만약 그 중간에 장애물이 있다면 이동을 할 수 없다
 *  Pawn은 상대팀의 말은 잡을 수 없다고 하자(즉, 장애물의 역할만 한다는 것이다)
 *
 *  입력
 *  첫째 줄에는 체스 판의 크기 n과 m이 주어진다
 *  둘째 줄에는 Queen의 개수와 그 개수만큼의 Queen의 위치가 입력
 *  셋째 줄에는 Knight의 개수와 위치, 넷째 줄에는 Pawn의 개수와 위치가 입력
 *  night, Queen, Pawn의 개수는 각각 100을 넘지 않는 음이 아닌 정수
 */

public class Main_B_1986 {

    public static void qBFS(int[][] arr, int x,int y) {
        int[] dx = {0,1, 0,-1, 1,-1, 1,-1};
        int[] dy = {1,0,-1, 0, 1,-1,-1, 1};

        for(int i = 0;i < dx.length;i++){
            int nx = x;
            int ny = y;
            while(true){
                nx = nx + dx[i];
                ny = ny + dy[i];

                if(nx < arr.length && nx >= 0 && ny < arr[0].length && ny >= 0){
                    if(arr[nx][ny] == 3 || arr[nx][ny] == 2 || arr[nx][ny] == 1) {
                        break;
                    }
                    arr[nx][ny] = 7;
                    //System.out.println(nx + " " + ny);
                } else {
                    break;
                }

            }
        }
    }

    public static void kBFS(int[][] arr, int x,int y) {
        int[] dx = {-1,-2,-2,-1,1,2, 2, 1};
        int[] dy = { 2, 1,-1,-2,2,1,-1,-2};

        for(int i = 0;i < dx.length;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < arr.length && nx >= 0 && ny < arr[0].length && ny >= 0){
                if(arr[nx][ny] == 3 || arr[nx][ny] == 2 || arr[nx][ny] == 1) continue;
                arr[nx][ny] = 7;
                //System.out.println(nx + " " + ny);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\실전코테스터디\\Algo_0813\\Chess\\chess.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        int kind = 1;
        for(int i = 0;i < 3;i++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            int count = Integer.parseInt(st2.nextToken());
            if(count == 0){
                kind++;
                continue;
            }
            for(int j = 0;j < count;j++){
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                arr[x-1][y-1] = kind;
            }
            kind++;
        }

        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                if(arr[i][j] == 1){
                    //System.out.println("새시작q: "+ i + " " + j);
                    qBFS(arr,i,j);
                }
                else if (arr[i][j] == 2){
                    //System.out.println("새시작k: "+ i + " " + j);
                    kBFS(arr,i,j);
                }
            }
        }

        //System.out.println();
        int answer = 0;
        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                //System.out.print(arr[i][j] + " ");
                if(arr[i][j] == 0){
                    answer++;
                }
            }
            //System.out.println();
        }
        System.out.println(answer);
    }
}

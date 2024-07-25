import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int[][] arr;
    static int N;
    static int M;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static class Node {
        int x;
        int y;
        int cur_count;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Node> bigBlock;
    static ArrayList<Node> testBlock;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // -1 검정색, 0 무지개, 1~M 일반
        arr = new int[N][N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        //1. 크기가 가장 큰 블록
        while (true){
            int cur_cnt = first();
            System.out.println("tmp cnt: "+cur_cnt);
            if (cur_cnt == 0) break;
            answer += cur_cnt*cur_cnt;
            //2. 블록 제거 , 점수획득
            System.out.println("tmp answer: "+answer);
            for (Node n : bigBlock) {
                int x = n.x;
                int y = n.y;
                System.out.print(x+" "+y+"  ");
                arr[x][y] = -2;
            }
            System.out.println();
            //3. 중력 작용 (Gravity)
            Gravity(arr);
            //4. 90도 반시계 회전
            arr = Turn(arr);
            //5. 중력 작용
            Gravity(arr);
        }
        System.out.println(answer);

    }
    private static int first(){
        bigBlock = new ArrayList<>();
        visited = new boolean[N][N];
        int cur_cnt = 0;
        int cur_rainbow = 0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (arr[i][j] == -1) visited[i][j] = true;
                if (arr[i][j]>0) {
                    // i,j 가 기준 블록
                    // 무지개가 많은 블록 > 기준 블록의 행이 가장 큰 것 >  열이 가장 큰 것
                    testBlock = new ArrayList<>();
                    int result[] = BFS(i,j,arr[i][j]);
                    int count = result[0];
                    System.out.println(count);
                    int rainbow = result[1];
                    if (cur_cnt<count){
                        bigBlock = testBlock;
                        cur_cnt = count;
                    } else if (cur_cnt == count){
                        if (cur_rainbow <= rainbow) {
                            bigBlock = testBlock;
                            cur_rainbow = rainbow;
                        }
                    }
                }
            }
        }
        return cur_cnt;
    }
    private static int[] BFS(int x, int y, int color){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        //위치, 총 갯수, 무지개 갯수
        queue.add(new int[]{x,y,1,0});
        int result_count = 0;
        int result_rainbow = 0;
        while(!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cur_x = tmp[0];
            int cur_y = tmp[1];
            int count = tmp[2];
            int rainbow = tmp[3];
            result_count = Math.max(result_count,count);
            result_rainbow = Math.max(result_rainbow, rainbow);
            testBlock.add(new Node(cur_x, cur_y));
            for (int i=0;i<4;i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                if (arr[cur_x][cur_y] == 0) rainbow++;

                if (nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                    if (arr[nx][ny] == 0 || arr[nx][ny] == color) {
                        queue.add(new int[]{nx, ny, count+1, rainbow});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return new int[]{result_count, result_rainbow};
    }

    // 비어 있는 경우 --> -2
    private static void Gravity(int[][] arr){
        for (int i=N-2;i>=0;i--){
            for (int j=0;j<N;j++){
                if (arr[i][j] > -1){
                    int cur_num = arr[i][j];
                    int cur_i = i;
                    while (true){
                        cur_i++;

                        if (cur_i<N || arr[cur_i][j] != -1) {
                            cur_i--;
                            break;
                        }

                    }
                    arr[cur_i][j] = cur_num;
                    arr[i][j] = -2;
                }
            }
        }
    }

    private static int[][] Turn (int[][] arr){
        int[][] new_arr = new int[N][N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                new_arr[i][j] = arr[j][N-1-i];
            }
        }
        return new_arr;
    }
}
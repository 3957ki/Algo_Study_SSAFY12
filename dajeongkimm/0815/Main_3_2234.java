import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 1. 방의 개수
 * 2. 가장 넓은 방의 넓이
 * 3. 하나의 벽을 제거 -> 가장 넓은 방의 넓이
 *
 * Integer.toBinaryString(num)
 */
public class Main_3_2234 {
    static int N,M;

    static int[][] arr;

    //남 8 동 4 북 2 서 1
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static boolean[][] visited;

    static int room_count, room_capacity, room_capacity_alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        room_capacity = 0;
        room_count = 0;
        room_capacity_alpha = 0;

        visited = new boolean[N][M];

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (visited[i][j] == false) {
                    int tmp = BFS(i,j);
                    room_count++;
//                    printArr(visited);
                    room_capacity = Math.max(room_capacity, tmp);
                }
            }
        }

        //하나의 벽 제거 이후
//        for (int i=0;i<N;i++){
//            for (int j=0;j<M;j++){
//                int cur_num = arr[i][j];
//                String cur_binary = String.format("%04d", Integer.parseInt(Integer.toBinaryString(cur_num)));
//                for (int k=0;k<4;k++){
//                    int nx = i + dx[k];
//                    int ny = j + dy[k];
//
//                    if (nx>=0 && nx<N && ny>=0 && ny<M){
//                        if (cur_binary.charAt(k) == '1'){
//                            visited = new boolean[N][M];
//                            arr[i][j] -= (1<<(3-k));
//                            room_capacity_alpha = Math.max(room_capacity_alpha, BFS(i,j));
//                            arr[i][j] += (1<<(3-k));
//                        }
//                    }
//                }
//            }
//        }

        for (int i=0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if ((arr[i][j] & (1 << k)) != 0) {
                            visited = new boolean[N][M];
                            arr[i][j] -= (1 << k);
                            room_capacity_alpha = Math.max(room_capacity_alpha, BFS(i, j));
                            arr[i][j] += (1 << k);
                        }
                    }
                }
            }
        }

        System.out.println(room_count);
        System.out.println(room_capacity);
        System.out.println(room_capacity_alpha);

    }
    private static int BFS(int x, int y){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        int result = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];

            int cur_num = arr[cur_x][cur_y];
            String cur_binary = String.format("%04d", Integer.parseInt(Integer.toBinaryString(cur_num)));
            int idx = -1;

            for (char c : cur_binary.toCharArray()){
                idx++;
                if (c == '0') {
                    int nx = cur_x+dx[idx];
                    int ny = cur_y+dy[idx];

                    if (nx>=0 && nx<N && ny>=0 && ny<M){
                        if (visited[nx][ny] == false){
                            visited[nx][ny] = true;
                            result++;
                            queue.add(new int[]{nx,ny});
                        }
                    }
                }
            }

        }

        return result;

    }

    private static void printArr(int[][] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

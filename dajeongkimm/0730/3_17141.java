import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N,M;
    static int[][] arr;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<int[]> bomb;
    static ArrayList<int[]> totalBomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        bomb = new ArrayList<>();
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2){
                    bomb.add(new int[]{i,j});
                    arr[i][j] = 0;
                } else if (arr[i][j] == 1) {
                    arr[i][j] = -1;
                }
            }
        } //벽은 -1, 나머지는 모두 0
        // M개의 빈칸 선택 : DFS, 바이러스가 걸리는 최소 시간 : BFS
        // DFS로 M개의 바이러스 설치하기
        boolean[] visited = new boolean[N];
        totalBomb = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        DFS(0,list);

        //DFS 테스트 (ok)
//        for (int i=0;i<totalBomb.size();i++){
//            int[] printArr = totalBomb.get(i);
//            for (int j=0;j< printArr.length;j++){
//                System.out.print(printArr[j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        int answer = Integer.MAX_VALUE;

        for (int i=0;i<totalBomb.size();i++){
            //M개의 바이러스 설치 후 전체 배열에 바이러스가 퍼지는 시간
            int tmp = BFS(totalBomb.get(i));
            if (tmp == -1) continue;
            answer = Math.min(answer, tmp);
        }
        //불가능한 경우
        if (answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }



    }

    private static void DFS(int idx, ArrayList<Integer> index_list){
        if (index_list.size() == M){
            int[] result = new int[index_list.size()];
            for (int i=0;i<index_list.size();i++){
                result[i] = index_list.get(i);
            }
            totalBomb.add(result);
            return;
        }
        for (int i=idx;i<bomb.size();i++) {
            index_list.add(i);
            DFS(i + 1, index_list);
            index_list.remove(index_list.size()-1);
        }
    }
    private static int BFS(int[] virus_index){
        int[][] board = new int[N][N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                board[i][j] = arr[i][j];
            }
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i=0;i<virus_index.length;i++){
            int[] cur = bomb.get(virus_index[i]);
            int x = cur[0];
            int y = cur[1];
            queue.add(new int[]{x,y});
            board[x][y] = 1;
        }

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if (nx>=0 && nx<N && ny>=0 && ny<N && board[nx][ny] == 0){
                    board[nx][ny] = board[x][y]+1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        //모든 칸에 다 퍼지지 않았을 경우 체크
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (board[i][j] == 0) return -1;
            }
        }

        int result = 0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                result = Math.max(result, board[i][j]);
            }
        }
        return result-1;
    }
}
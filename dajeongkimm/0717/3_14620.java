import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int[][] arr;
    static int answer;
    static int[][] cost;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        HashMap<Integer, String> map= new HashMap<>();
        cost = new int[N-2][N-2];
        answer = Integer.MAX_VALUE;
        for (int i=1;i<N-1;i++){
            for (int j=1;j<N-1;j++){
                int tmp = 0;
                tmp += arr[i][j];
                tmp += arr[i-1][j];
                tmp += arr[i][j-1];
                tmp += arr[i][j+1];
                tmp += arr[i+1][j];

                cost[i-1][j-1] = tmp;

            }
        }
        for (int i=0;i<N-2;i++){
            for (int j=0;j<N-2;j++){
                int index = i*(N-2) + j;
                int[][] visited = new int[3][2];
                for (int x=0;x<3;x++){
                    Arrays.fill(visited[x], -1);
                }
                visited[0][0] = i;
                visited[0][1] = j;
                totalCost(index, cost[i][j], 1,visited);

            }
        }
        System.out.println(answer);

//        for (int i=0;i<N-2;i++){
//            for (int j=0;j<N-2;j++){
//                System.out.print(cost[i][j] + " ");
//            }
//            System.out.println();
//        }



    }
    private static void totalCost(int index, int cur_cost, int len, int[][] visited) {
        if (len == 3) {
            answer = Math.min(answer, cur_cost);
            return;
        }
        if (len>3) return;
        for (int idx = index+1; idx<(N-2)*(N-2);idx++){
            int i = idx/(N-2);
            int j = idx%(N-2);

            boolean flag = true;
            for (int x=0;x<len;x++){
                int tmp_i = visited[x][0];
                int tmp_j = visited[x][1];
                if (Math.abs(tmp_i-i) + Math.abs(tmp_j-j)  < 3) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                visited[len][0] = i;
                visited[len][1] = j;
                totalCost(index, cur_cost + cost[i][j], len+1, visited);
            }

        }
    }
}
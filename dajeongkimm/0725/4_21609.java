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
    
    static boolean[][] globalVisited;
    static ArrayList<Node> bigBlock;
    static ArrayList<Node> testBlock;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean debug = false;
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
        int time = 1;
        //1. 크기가 가장 큰 블록
        
        while (true){
        	if (debug) {
        		arrPrint(arr);
        		System.out.println();
        	}
            int cur_cnt = first();
           
            if (cur_cnt < 2) break;
            answer += cur_cnt*cur_cnt;
            //2. 블록 제거 , 점수획득
            if (debug) {
            	System.out.println(time+++": tmp answer: "+answer);
            }
            
            for (Node n : bigBlock) {
                int x = n.x;
                int y = n.y;
                arr[x][y] = -2;
                if (debug) {
                	System.out.println("delete : "+x+" "+y);
                }
            }
            if (debug) {
            	System.out.println("After delete");
        		arrPrint(arr);
        		System.out.println();
        	}
            //3. 중력 작용 (Gravity)
            Gravity(arr);
            if (debug) {
            	System.out.println("first gravity");
        		arrPrint(arr);
        		System.out.println();
        	}
            //4. 90도 반시계 회전
            arr = Turn(arr);
            if (debug) {
            	System.out.println("90turn");
        		arrPrint(arr);
        		System.out.println();
        	}
            //5. 중력 작용
            Gravity(arr);
            if (debug) {
            	System.out.println("second gravity");
        		arrPrint(arr);
        		System.out.println();
        	}
        }
        System.out.println(answer);

    }
    private static int first(){
        bigBlock = new ArrayList<>();
        globalVisited = new boolean[N][N];
        Node bestBlock = null;
        int cur_cnt = 0;
        int cur_rainbow = 0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (arr[i][j]>0 && globalVisited[i][j] == false) {
                    // i,j 가 기준 블록
                    // 무지개가 많은 블록 > 기준 블록의 행이 가장 큰 것 >  열이 가장 큰 것
                    testBlock = new ArrayList<>();
                    globalVisited[i][j] = true;
                    visited = new boolean[N][N];
                    int result[] = BFS(i,j,arr[i][j]);
                    int count = result[0];
                    int rainbow = result[1];
                    
                    if (cur_cnt<count || (cur_cnt==count && rainbow>=cur_rainbow)) {
                    	bigBlock = new ArrayList<>(testBlock);
                    	cur_rainbow = rainbow;
                    	cur_cnt = count;
                    	bestBlock = new Node(i, j);
                    }
                   
                }
            }
        }
        return bigBlock.size();
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
            testBlock.add(new Node(cur_x, cur_y));
            
            result_count = count;
            result_rainbow = rainbow;
            
//            result_count = Math.max(result_count,count);
//            result_rainbow = Math.max(result_rainbow, rainbow);
            
            for (int i=0;i<4;i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                

                if (nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                    if (arr[nx][ny] == 0 || arr[nx][ny] == color) {
                    	if (arr[nx][ny] == 0) rainbow++;
                        queue.add(new int[]{nx, ny, count+1, rainbow});
                        visited[nx][ny] = true;
                        if (arr[nx][ny] == color) globalVisited[nx][ny] = true;
                    }
                }
            }
//            result_count = count;
//            result_rainbow = rainbow;
        }
        return new int[]{result_count, result_rainbow};
    }

    // 비어 있는 경우 --> -2
    private static void Gravity(int[][] arr){
        for (int i=N-2;i>=0;i--){
            for (int j=0;j<N;j++){
                if (arr[i][j] > -1){
                    int cur_i = i;
                    while (cur_i +1 <N && arr[cur_i+1][j] == -2) {
                    	arr[cur_i+1][j] = arr[cur_i][j];
                    	arr[cur_i][j] = -2;
                    	cur_i++;
                    }
                    
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
    
    private static void arrPrint(int[][] arr) {
    	for (int i=0;i<N;i++) {
    		for (int j=0;j<N;j++) {
    			System.out.print(arr[i][j]);
    		}
    		System.out.println();
    	}
    	
    }
}
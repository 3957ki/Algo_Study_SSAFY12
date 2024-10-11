import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 순열
 */

public class Main {
    static int N;
    static int M;
    static boolean[] selected;
    static boolean[] visited;
    static int[] arr;
//    static StringBuilder sb = new StringBuilder();
    static int result = 0;


    static void perm(int depth, int condition) {
        if(depth == N){
        	if(condition >= M) {
        		 result++;
        		 //System.out.println(Arrays.toString(arr));
        	}
            //sb.setLength(0);
            
            return;
        }

        for(int i = 0;i < visited.length;i++){
        	if(selected[i]) {
        		arr[depth] = i;
        		selected[i] = false; 
                perm(depth + 1, condition + 1);
                selected[i] = true; 
        	} else {
        		arr[depth] = i;
            	perm(depth + 1, condition);
        	}
        	
        }
    }



    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("res/b_13908.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new boolean[10];	
        visited = new boolean[10];
        arr = new int[N];

        if(M > 0) {
        	StringTokenizer st2 = new StringTokenizer(bf.readLine());
            //int cnt = 0;
            for(int i = 0;i < M;i++){
                int v = Integer.parseInt(st2.nextToken());
                selected[v] = true;
                //arr[cnt] = v;
                //cnt++;
            }
        }
        

        perm(0,0);

        System.out.println(result);
    }
}
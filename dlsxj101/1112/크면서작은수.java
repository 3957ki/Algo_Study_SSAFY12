import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 */
public class 크면서작은수 {
	
	static int arr[], N, min, answer[];
	static boolean visited[];
	static int init;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine().trim();
        init = Integer.parseInt(input);
        N = input.length();
        
        arr = new int[N];
        for(int i = 0; i < N; i++) {
        	arr[i] = input.charAt(i)-'0';
        }
        
        min = Integer.MAX_VALUE;
        answer = new int[N];
        visited = new boolean[N];
        dfs(0);
        
        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
    
    static void dfs(int cnt) {
    	if(cnt == N) {
    		StringBuilder sb = new StringBuilder();
    		
    		for(int i = 0; i < N; i++) {
    			sb.append(answer[i]);
    		}
    		int ans = Integer.parseInt(sb.toString());
    		if(ans <= init) return;
    		min = Math.min(min, ans);
    	}
    	
    	for(int i = 0; i < N; i++) {
    		if(visited[i]) continue;
    		
    		visited[i] = true;
    		answer[cnt] = arr[i];
    		dfs(cnt+1);
    		visited[i] = false;
    	}
    }
}

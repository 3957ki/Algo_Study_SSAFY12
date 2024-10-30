import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 눈덩이굴리기 {
	
	static int N, M, arr[], max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		dfs(0, 0, 1);
		System.out.println(max);
	}
	
	static void dfs(int time, int index, int snowball) {
//		System.out.println("snowball:"+ snowball + " index:"+ index);
		if(time == M) {
			max = Math.max(max, snowball);
			return;
		}
		
		if(index+1>N) {
			max = Math.max(max, snowball);
			return;
		}
		
		if(index+2>N) {
			dfs(time+1, index+1, snowball+arr[index+1]);
			return;
		}
		
		dfs(time+1, index+1, snowball+arr[index+1]);
		dfs(time+1, index+2, (snowball/2)+arr[index+2]);
		
	}
}
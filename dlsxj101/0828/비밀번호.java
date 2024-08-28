import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비밀번호 {
	static int n, m, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] chk = new int[10];
		ans = 0;
		if(m != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				chk[Integer.parseInt(st.nextToken())] = 1;
			}
		}
		dfs(0, chk);
		
		System.out.println(ans);
		
	}
	static void dfs(int cnt, int[] arr) {
		if(cnt == n) {
			for(int i : arr) {
				if(i > 0) return;
			}
			ans++;
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			arr[i]--;
			dfs(cnt+1, arr);
			arr[i]++;
		}
	}
}
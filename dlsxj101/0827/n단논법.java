import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n단논법 {
	static int list[], n, m;
	static char input1[][], input2[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new int[27];
		
		n = Integer.parseInt(br.readLine().trim());

		input1 = new char[n][6];

		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				input1[i][j] = str.charAt(j);
			}
			list[input1[i][0] - 'a' + 1] = input1[i][5] - 'a' + 1;
		}

		m = Integer.parseInt(br.readLine().trim());

		input2 = new char[n][6];

		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				input2[i][j] = str.charAt(j);
			}
		}
		for(int i = 0; i < m; i++) {
			dfs(0, input2[i][0] - 'a' + 1, input2[i][5] - 'a' + 1);
		}
		System.out.println(sb);
	}
	static void dfs(int cnt, int c, int chk) {
		if(cnt == n) {
			sb.append("F").append("\n");
			return;
		}
		if(list[c] == 0) {
			sb.append("F").append("\n");
			return;
		}else if(list[c] == chk) {
			sb.append("T").append("\n");
			return;
		}
		dfs(cnt+1, list[c], chk);
		
	}
}
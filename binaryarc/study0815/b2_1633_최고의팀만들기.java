package study0815;
import java.io.*;
import java.util.*;
public class b2_1633_최고의팀만들기 {
	static ArrayList<int[]> arr;
	static boolean[] visited;
	static long ans;
	static int idx;
	public static void dfs(int cnt,int cur_stat) {
		if(cnt==30) {
			ans = Math.max(ans,cur_stat);
			
			return;
		}
		for(int i=0;i<idx-1;i++) {
			if(!visited[i]) {
				for(int j=0;j<2;j++) {
					visited[i] = true;
					dfs(cnt+1,cur_stat+arr.get(i)[j]);
					visited[i] = false;
				}
			}
			
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str="";
		idx=0;
		arr = new ArrayList<int[]>();
		while((str = br.readLine()) != null || !str.isEmpty()) {
			if(str.equals(""))break;
			System.out.println(str);
			arr.add(new int[]{Integer.parseInt(str.split(" ")[0]), Integer.parseInt(str.split(" ")[1])});
			idx++;
		}
		
		visited = new boolean[idx];
		ans = 0;
		dfs(0,0);
		System.out.println(ans);
	}

}

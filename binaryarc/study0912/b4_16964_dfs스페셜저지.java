package study0912;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class b4_16964_dfs스페셜저지 {
	static int N;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static String input;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=1;i<=N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		input = br.readLine();
		sb = new StringBuilder();
		dfs(1,1);
		System.out.println(sb);
		if(sb.toString().equals(input+' ')) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	static void dfs(int vertex,int cnt) {
		if(cnt == N) {
			sb.append(vertex).append(' ');
			if(sb.toString().equals(input+' ')) {
				System.out.println(1);
			}
			return;
		}
		visited[vertex] = true;
		sb.append(vertex).append(' ');
		for(Integer next : list[vertex]) {
			if(!visited[next]) {
				dfs(next , cnt + 1);
			}
			
		}
		
	}

}

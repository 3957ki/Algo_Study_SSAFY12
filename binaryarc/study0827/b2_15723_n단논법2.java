package study0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class b2_15723_n단논법2 {
	static boolean[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		map = new boolean[26][26];
		
		int N = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char from = st.nextToken().charAt(0);
			st.nextToken();
			char to = st.nextToken().charAt(0);
			map[from-'a'][to-'a'] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char from = st.nextToken().charAt(0);
			st.nextToken();
			char to = st.nextToken().charAt(0);
			visited = new boolean[26];
			if(dfs(from-'a',to-'a'))sb.append("T\n");
			else sb.append("F\n");
		}
		
		System.out.print(sb);
	}
	public static boolean dfs(int cur, int target) {
		if(cur == target) return true;
		visited[cur] = true;
		for(int next=0; next < 26; next++) {
			if(map[cur][next] && !visited[next]) {
				if(dfs(next,target))return true;
			}
		}
		return false;
	}
}

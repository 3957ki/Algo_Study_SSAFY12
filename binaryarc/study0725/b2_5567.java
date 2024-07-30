package study0725;

import java.io.*;
import java.util.*;

public class b2_5567 {
	static int n;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> friends;
	public static void dfs(int f,int cnt) {
		if(cnt == 2) {
			return;
		}
		for(int ff : friends.get(f)) {
			visited[ff] = true;
			dfs(ff,cnt+1);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int listNum = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		friends = new ArrayList<>();
		for(int i=0;i<n+1;i++)friends.add(new ArrayList<Integer>());
		int ans=0;
		for(int i=0;i<listNum;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends.get(a).add(b);
			friends.get(b).add(a);
		}
		dfs(1,0);
		for(int i=2;i<n+1;i++) {
			if(visited[i])ans++;
		}
		System.out.println(ans);
	}
}

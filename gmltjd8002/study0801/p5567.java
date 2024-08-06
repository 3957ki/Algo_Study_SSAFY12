package study0801;

import java.io.*;
import java.util.*;

public class p5567 {
	 static int n,m;
     static ArrayList<ArrayList<Integer>> friend = new ArrayList<>();
     static boolean[] isVisit;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
	    m = Integer.parseInt(br.readLine());
		for(int i=0; i<=n;i++) {
			friend.add(new ArrayList<>());
		}
		isVisit = new boolean[n+1];
		isVisit[1] = true;  // 자신
		
		for(int i=0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			friend.get(first).add(second);
			friend.get(second).add(first);
		}
		dfs(1,0);
		int res = 0;
        for (int i = 2; i < isVisit.length; i++) {// i = 1 : 상근이라 카운트X
            if(isVisit[i]) res++;
        }
        System.out.println(res);
    }
	
	public static void dfs(int x, int y) {
		if(y== 2) return;
		for(int i: friend.get(x)) {
			isVisit[i] = true;
			dfs(i,y+1);
		}
	}
	
}
package study0903;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * x < y 만족하는 두방의 모든 벽을 허물수있음
 * M번 행동함
 * 모든 행동이 끝난후 남아 있는 동방의 개수를 출력
 * N+1 개의 동방 배열
 * 
 */
public class b1_14594_동방프로젝트 {
	static int N,M;
	static int[] dongbang;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		dongbang = new int[N+1];
		for(int i=1;i<=N;i++)dongbang[i] = i;
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = x; j <= y ; j++) {
				union(x,j);
			}
		}
		Set<Integer> set = new TreeSet<Integer>();
		for(int i=1;i<=N;i++) {
			set.add(find(i));
		}
		
		System.out.println(set.size());
	}
	
	static int find(int n) {
		if(dongbang[n] == n)return n;
		else return dongbang[n] = find(dongbang[n]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)return false;
		if(aRoot != bRoot) {
			if(aRoot < bRoot) {
				dongbang[b] = aRoot;
			}else {
				dongbang[a] = bRoot;
			}
		}
		return true;
	}
}

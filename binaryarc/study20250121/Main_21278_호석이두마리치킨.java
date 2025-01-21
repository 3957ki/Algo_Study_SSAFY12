package study20250121;

import java.io.*;
import java.util.*;

public class Main_21278_호석이두마리치킨 {
	static int N, M;
	static List<Integer>[] graph;
	static int ans_time;
	static List<Integer> ans_list;
	static int[][] dist_arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		dist_arr = new int[101][101];
		ans_time = Integer.MAX_VALUE;
		ans_list = new ArrayList<>();
		calAllDist();
		combi(0, 1, new int[2]);
		for (int i : ans_list) {
			System.out.print(i + " ");
		}
		System.out.println(ans_time);

	}

	public static void calAllDist() {
	    for (int start = 1; start <= N; start++) {
	        int dist = 1;
	        boolean[] visited = new boolean[N + 1];
	        Queue<Integer> q = new ArrayDeque<>();
	        q.add(start);
	        visited[start] = true; // BFS 시작 노드 방문 처리
	        while (!q.isEmpty()) {
	            int q_size = q.size(); // 고정된 크기로 반복
	            for (int i = 0; i < q_size; i++) {
	                int cur = q.poll();
	                for (int next : graph[cur]) {
	                    if (visited[next]) continue;
	                    q.add(next);
	                    dist_arr[start][next] = dist * 2;
	                    dist_arr[next][start] = dist_arr[start][next];
	                    visited[next] = true;
	                }
	            }
	            dist++;
	        }
	    }
	}

	public static void combi(int cnt, int idx, int[] selected) {
		if (cnt == 2) {
			int res = 0;
			int start_A = selected[0];
			int start_B = selected[1];
			for(int n = 1; n <= N ; n++) {
				if(n == start_A || n == start_B)continue;
				if(dist_arr[start_A][n] < dist_arr[start_B][n]) {
					res += dist_arr[start_A][n];
				}else {
					res += dist_arr[start_B][n];
				}
			}
			if(ans_time > res) {
				ans_list.clear();
				Arrays.sort(selected);
				for(int start : selected) {
					ans_list.add(start);
					ans_time = res;
				}
			}
			return;
		}

		for (int i = idx; i <= N; i++) {
			selected[cnt] = i;
			combi(cnt + 1, idx + 1, selected);
		}
	}

}

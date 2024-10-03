package d1003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class prob4 {
	static int N;
	static List<Integer> adj[];
	static List<Integer> history;
	static boolean isCycle[];
	static int answer[];
	public static void main(String[] args) {
		
		getInput();
		findCycle();
		
		//logic
		for(int i = 1;i <= N;i++) {
			if(!isCycle[i]) continue;
			for(int next : adj[i]) {
				if(isCycle[next]) continue;
				//play dfs
				dfs(i,next,1);
			}
		}
		
		for(int i = 1;i <= N;i++) {
			System.out.print(answer[i] + " ");
		}
		 
	}
	
	static void dfs(int prev, int cur, int cnt) {
		answer[cur] = cnt;
		for(int next : adj[cur]) {
			if(!isCycle[next] && answer[next] == 0) {
				dfs(cur,next,cnt+1);
			}
		}
	}
	
	static void findCycle() {
		isCycle = new boolean[N+1];
		visited = new boolean[N+1];
		visited[1] = true;
		history = new ArrayList<>();
		history.add(1);
		findCycle(0,1);
	}
	static boolean visited[];
	static boolean findCycle(int prev,int cur) {
		//prev 가 아닌 next들을 모두 방문한다
		for(int next : adj[cur]) {
			if(next == prev) continue;
			
			//next에 방문할 것임
			if(visited[next]) {
				//cycle found! history에서 next 이후는 모두 싸이클임
				int idx =  history.indexOf(next);
				for(;idx < history.size();idx++) {
					isCycle[history.get(idx)] = true;
				}
				return true; //dfs가 종료되었음
			}
			
			history.add(next);
			visited[next] = true;
			if(findCycle(cur,next)) return true;
			visited[next] = false;
			history.remove(history.size()-1);
		}
		return false;
	}
	
	static void getInput() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new List[N+1];
		answer = new int[N+1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
	}

}

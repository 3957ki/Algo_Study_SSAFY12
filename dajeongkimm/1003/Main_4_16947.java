import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 서울 지하철 2호선
 * 
 * 51개의 역 , 51개의 구간
 * 각 역과 순환선 사이의 거리?
 * 
 * 1) 순환선에 해당하는 노드 --> 0
 * 2) 순환선이 아닌 정점 --> 순환선에 해당하는 노드 중 하나 도착 : 거리
 * 
 * 방금전에 온 곳 아닌데 이미 방문했으면? 순환선
 * 
 * @author KOREA
 *
 */
public class Main_4_16947 {
	static List<Integer> graph[];
	static Set<Integer> set = new HashSet<>(); //순환선에 해당하는 정점 
	static int[] answer;
	static int N; //역의 개수
	
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for (int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//양방향 그래프
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//순환선에 속하는지 아닌지
		for (int i=1;i<=N;i++) {
			//순환선이라면?
			visited = new boolean[N+1];
			isCircuit(i,0);
		}
		
		StringBuilder answer = new StringBuilder();
		for (int i=1;i<=N;i++) {
			if (set.contains(i)) {
				answer.append(0).append(" ");
			}
			else {
				int distance = move(i);
				answer.append(distance).append(" ");
			}
		}
		
		System.out.println(answer);
		
	}
	static int move(int start) {
		int[] moved = new int[N+1];
		Queue<Integer> queue = new ArrayDeque<>();
		moved[start] = 1;
		queue.add(start);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			//도착한 곳이 순환선이라면?
			if (set.contains(cur)) {
				return moved[cur]-1; //시작점을 1로 해서 1 빼주기
			}
			
			for (int next : graph[cur]) {
				//방문한 적이 없으면
				if (moved[next] == 0) {
					queue.add(next);
					moved[next] = moved[cur]+1;
				}
			}
		}
		return -1;
	}
	
	static boolean isCircuit(int node, int before) {
//		System.out.println("node : "+node);
		visited[node] = true;
		
		for (int next : graph[node]) {
			//방문한적이 없다면
			if (!visited[next]) {
				boolean isTrue = isCircuit(next, node);
				if (isTrue) return true;
			}
			//이미 방문한 곳인데 바로 직전에 방문한 곳 아니면 --> cycle
			else if (visited[next] && next != before) {
				set.add(next);
				return true;
			}
		}
		
		return false;
	}

}

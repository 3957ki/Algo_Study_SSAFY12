import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * DFS 스페셜 저지
 * @author KOREA
 *
 */
public class Main_4_16964 {
	static int N;
	static Stack<Integer> stack = new Stack<>();
	static int[] order;
	static int answer = 1;
	
	static HashSet<Integer> graph[];
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		//ArrayList로 graph 구성시 시간초과
		//이전노드에서 다음노드로 가는 경로가 있는지 HashSet을 통해 그래프 저장
		graph = new HashSet[N+1];
		for (int i=0;i<=N;i++) {
			graph[i] = new HashSet<>();
		}
		
		for (int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		st = new StringTokenizer(br.readLine());
		order = new int[N];
		for (int i=0;i<N;i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		//------------------------------------------------ input
		
		visited = new boolean[N+1];
		//노드 1번부터 시작
		visited[1] = true;
		stack.add(1);
		for (int i=1;i<N;i++) {
			A: while (true) {
				//다음 순서에 들어갈 노드 번호 next
				int next = order[i];
				//stack size가 0이라면 이전 노드가 없으므로 불가능
				if (stack.size() == 0) {
					System.out.println(0);
					return;
				}
				// peek : 이전노드
				int peek = stack.peek();
				// 이전노드에서 다음 노드로 가는 경로가 있는지 판단하는 boolean
				boolean isAvail = false;
				if (graph[peek].contains(next)) {
					//이전노드에서 다음 노드로 가는 경로가 있다면 스택에 추가하고 다음 순서 노드로
					stack.add(next);
					visited[next] = true;
					isAvail = true;
					break A;
					
				}
				//이전 노드에서 다음 노드로 가는 경로가 없다면
				//스택에서 이전노드를 하나 제거
				if (!isAvail) {
					if (stack.size() == 0) {
						System.out.println(0);
						return;
					}
					else stack.pop();
				}
			}
			
		}
		System.out.println(1);
		
		
	}
	
	

}

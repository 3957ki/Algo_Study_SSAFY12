import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * DFS ����� ����
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
		
		//ArrayList�� graph ������ �ð��ʰ�
		//������忡�� �������� ���� ��ΰ� �ִ��� HashSet�� ���� �׷��� ����
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
		//��� 1������ ����
		visited[1] = true;
		stack.add(1);
		for (int i=1;i<N;i++) {
			A: while (true) {
				//���� ������ �� ��� ��ȣ next
				int next = order[i];
				//stack size�� 0�̶�� ���� ��尡 �����Ƿ� �Ұ���
				if (stack.size() == 0) {
					System.out.println(0);
					return;
				}
				// peek : �������
				int peek = stack.peek();
				// ������忡�� ���� ���� ���� ��ΰ� �ִ��� �Ǵ��ϴ� boolean
				boolean isAvail = false;
				if (graph[peek].contains(next)) {
					//������忡�� ���� ���� ���� ��ΰ� �ִٸ� ���ÿ� �߰��ϰ� ���� ���� ����
					stack.add(next);
					visited[next] = true;
					isAvail = true;
					break A;
					
				}
				//���� ��忡�� ���� ���� ���� ��ΰ� ���ٸ�
				//���ÿ��� ������带 �ϳ� ����
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

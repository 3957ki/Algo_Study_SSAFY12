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
 * ���� ����ö 2ȣ��
 * 
 * 51���� �� , 51���� ����
 * �� ���� ��ȯ�� ������ �Ÿ�?
 * 
 * 1) ��ȯ���� �ش��ϴ� ��� --> 0
 * 2) ��ȯ���� �ƴ� ���� --> ��ȯ���� �ش��ϴ� ��� �� �ϳ� ���� : �Ÿ�
 * 
 * ������� �� �� �ƴѵ� �̹� �湮������? ��ȯ��
 * 
 * @author KOREA
 *
 */
public class Main_4_16947 {
	static List<Integer> graph[];
	static Set<Integer> set = new HashSet<>(); //��ȯ���� �ش��ϴ� ���� 
	static int[] answer;
	static int N; //���� ����
	
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
			
			//����� �׷���
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//��ȯ���� ���ϴ��� �ƴ���
		for (int i=1;i<=N;i++) {
			//��ȯ���̶��?
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
			
			//������ ���� ��ȯ���̶��?
			if (set.contains(cur)) {
				return moved[cur]-1; //�������� 1�� �ؼ� 1 ���ֱ�
			}
			
			for (int next : graph[cur]) {
				//�湮�� ���� ������
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
			//�湮������ ���ٸ�
			if (!visited[next]) {
				boolean isTrue = isCircuit(next, node);
				if (isTrue) return true;
			}
			//�̹� �湮�� ���ε� �ٷ� ������ �湮�� �� �ƴϸ� --> cycle
			else if (visited[next] && next != before) {
				set.add(next);
				return true;
			}
		}
		
		return false;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;


//장난감 조립
public class Main {
	
	public static class Node {
		int num, count;
		
		public Node(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
	
	static int[] inDegreeX;
	static int[] inDegreeY;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//기본 부품 찾기
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for (int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		
		inDegreeX = new int[N+1];
		inDegreeY = new int[N+1];
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			list[x].add(new Node(y,k));
			inDegreeX[x]++;
			inDegreeY[y]++;
			
		}
		int[] result = Toy(N);
		for (int i=1;i<=N;i++) {
			if (inDegreeX[i] == 0) {
				System.out.println(i+" "+result[i]);
			}
		}
	
	}
	
	public static int[] Toy(int n) {
		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(n,1));
		int[] counter = new int[n+1];
		counter[n] = 1;
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for (int i=0;i<list[cur.num].size();i++) {
				Node next = list[cur.num].get(i);
				counter[next.num] += counter[cur.num]*next.count;
				inDegreeY[next.num]--;
				if (inDegreeY[next.num] == 0) {
					queue.add(new Node(next.num, counter[next.num]));
				}
			}
			
		}
		return counter;
	}
}
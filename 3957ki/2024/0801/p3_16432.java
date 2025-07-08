import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p3_16432 {
	static List<Integer>[] arr;
	static int[] result;
	static boolean[][] visited;
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		visited = new boolean[N+1][10];
		result = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			arr[i] = new ArrayList<>();
			for (int j = 1; j <= M; j++) {
				arr[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		System.out.println(DFS(1, 0) ? sb : -1);
	}

	static boolean DFS(int index, int prev) {
		if(index > N) {
			for(int i = 1; i <= N; i++) {
				sb.append(result[i]).append('\n');
			}
			return true;
		}
		
		for(int i = 1; i <= 9; i++) {
			if(!visited[index][i] && i != prev && arr[index].contains(i)) {
				visited[index][i] = true;
				result[index] = i;
				if(DFS(index+1, i)) return true;
			}
		}
		return false;
	}
}

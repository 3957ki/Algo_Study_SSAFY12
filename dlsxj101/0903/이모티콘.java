import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Emo {
	int s;
	int b;
	int t;
	public Emo(int s, int b, int t) {
		this.s = s;
		this.b = b;
		this.t = t;
	}
}

public class 이모티콘 {
	static int S, screen, board;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());

		screen = 1;
		board = 0;
		visited = new boolean[1001][1001];
		bfs(screen, board, 0);

	}

	static void bfs(int s, int b, int time) {
		Queue<Emo> q = new ArrayDeque<>();
		q.add(new Emo(s, b, time));
		while(!q.isEmpty()) {
			Emo e = q.poll();
			int ns = e.s;
			int nb = e.b;
			int ntime = e.t;

			if(ns == S) {
				System.out.println(ntime);
				break;
			}

			//복사
			if(ns!=nb && !visited[ns][ns]) {
				q.add(new Emo(ns, ns, ntime+1));
				visited[ns][ns] = true;
			}

			//붙여넣기
			if(nb!=0 && ns+nb<1001 && !visited[ns+nb][nb]) {
				q.add(new Emo(ns+nb, nb, ntime+1));
				visited[ns+nb][nb] = true;
			}

			//하나 빼기
			if(ns-1>0 && !visited[ns-1][nb]) {
				q.add(new Emo(ns-1, nb, ntime+1));
				visited[ns-1][nb] = true;
			}
		}
	}
}

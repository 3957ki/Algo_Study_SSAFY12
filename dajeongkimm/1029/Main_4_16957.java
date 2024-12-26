import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4_16957 {
	static boolean isMoved;
	static int[][] arr;
	
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	
	static int[] parent;
	
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		for (int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<C;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//012
		//345
		//678
		
		//parent 배열 초기화
		parent = new int[R*C];
		for (int i=0;i<R*C;i++) {
			parent[i] = i;
		}
		
		//초기에는 공 1개씩 모두 차지하고 있음
		cnt = new int[R*C];
		Arrays.fill(cnt, 1);
		
		for (int from=0;from<R*C;from++) {
			int x = from/C;
			int y = from%C;
			
//			System.out.println(x+" "+y);
			int curNum = arr[x][y];
			int minNum = curNum;
			
			int to = from;
			
			for (int d=0;d<8;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx>=0 && nx<R && ny>=0 && ny<C) {
					int cur = arr[nx][ny];
					if (cur < minNum) {
						to = nx*C + ny;
						minNum = cur;
					}
				}
			}
			
			//현재 자리보다 더 작은 위치의 공이 존재할경우
			//현재 위치 -> 가장 작은 수가 있는 위치로 공이 흐름
			if (minNum < curNum) {
//				System.out.println(to+" "+from);
				parent[from] = to;
				
			}
		}
		
		int[][] answer = new int[R][C];
		
		for (int i=0;i<R*C;i++) {
			int n = find(parent[i]);
			answer[n/C][n%C]++;
		}
		
		for (int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
		

	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	

}

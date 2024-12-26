import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 일정 주기마다 랜덤한 위치에 보스몬스터
 * 피해를 준 비율대로 지급
 * 지도, 플레이어 정보, 보스몬스터 체력
 * 최대 몇명의 플레이어가 전리품을 가져갈 수 있는지?
 * 
 * 보스몬스터 위치로 최대한 빠른 경로 이동한 후 바로 공격
 * 공격 : 1초
 * 이동 : 1초
 * 
 * @author KOREA
 *
 */
public class Main_4_20005 {
	static int M,N,P;
	static char[][] arr;
	static int HP;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int X,Y;
	static int[][] pos = new int[26][2];
	static int[] timeToBos = new int[26];
	static int[] dps = new int[26];
	static boolean[] gifted;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		arr = new char[M][N];
		List<Integer> playerNum = new ArrayList<>();
		//. 이동 가능 X 이동 불가, 소문자는 플레이어, B는 보스몬스터
		for (int i=0;i<M;i++) {
			String input = br.readLine();
			for (int j=0;j<N;j++) {
				arr[i][j] = input.charAt(j);
				//보스라면
				if (arr[i][j] == 'B') {
					X = i;
					Y = j;
				}
				//플레이어라면
				else if (arr[i][j] != '.' && arr[i][j] != 'X') {
					pos[arr[i][j]-'a'][0] = i;
					pos[arr[i][j]-'a'][1] = j;
					playerNum.add(arr[i][j]-'a');
				}
			}
		}
		
		for (int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine());
			char player = st.nextToken().charAt(0);
			int how = Integer.parseInt(st.nextToken());
			dps[player-'a'] = how;
		}
		
		HP = Integer.parseInt(br.readLine()); //보스몬스터 체력
		
		Arrays.fill(timeToBos, -1);
		//각 플레이어마다 보스까지 가는 데 걸리는 시간
		for (int i=0;i<26;i++) {
			if (dps[i] > 0) {
				int x = pos[i][0];
				int y = pos[i][1];
				timeToBos[i] = bfs(x,y);
			}
		}
		
		List<Integer> arrive = new ArrayList<>(); 
		gifted = new boolean[26];
		while (true) {
			//이동
//			System.out.println(Arrays.toString(timeToBos));
			for (int i=0;i<P;i++) {
				timeToBos[playerNum.get(i)]--;
				if (timeToBos[playerNum.get(i)] == 0) {
					arrive.add(playerNum.get(i));
//					System.out.println("add: "+i);
				}
			}
			
			//공격
			for (int i=0;i<arrive.size();i++) {
				int num = arrive.get(i);
				gifted[num] = true;
				HP -= dps[num];
			}
			
			if (HP <= 0) break;
		}
		
		
		int answer = 0;
		for (int i=0;i<26;i++) {
			if (gifted[i]) answer++;
		}
		System.out.println(answer);
		
	}
	
	static int bfs(int startX, int startY) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {startX, startY});
		boolean[][] visited = new boolean[M][N];
		visited[startX][startY] = true;
		int depth = 0;
		
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int x=0;x<qSize;x++) {
				int[] cur = q.poll();
				
				if (cur[0] == X && cur[1] == Y) {
					return depth;
				}
				
				for (int i=0;i<4;i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];
					
					if (nx>=0 && nx<M && ny>=0 && ny<N && !visited[nx][ny]) {
						if (arr[nx][ny] == 'X') continue;
						
						q.add(new int[] {nx,ny});
						visited[nx][ny] = true;
					}
				}
			}
			depth++;
			
		}
		return 0;
	}

}

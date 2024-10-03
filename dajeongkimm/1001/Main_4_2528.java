import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사다리
 * 시간 0의 초기상태에서 출발해서 철수가 가장 아래층의 막대기에서
 * 가장 위층의 막대기로 올라가는데 걸리는 최소 시간 구하기
 * 0은 왼쪽에서 오른쪽, 1은 오른쪽에서 왼쪽
 * @author KOREA
 *
 */
public class Main_4_2528 {
	static int N,L;
	static Node[] building;
	
	static int cur_floor;
	
	static class Node {
		int start;
		int end;
		int dir; //0이면 왼->오 1이면 오->왼
		
		Node(int start, int end, int dir){
			this.start = start;
			this.end = end;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //층 수
		L = Integer.parseInt(st.nextToken()); //층의 길이
		
		building = new Node[N+1];
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (num == 0) {
				building[i] = new Node(0,l,num);
				
			}
			else {
				building[i] = new Node(L-l, L, num);
				
			}
		}
		
		int time = 0;
		cur_floor = 1;
		while (true) {
			up(); //층수 올라가기 (가능한 최대한 위로?)
//			System.out.println("time: "+time+" cur_floor: "+cur_floor);
			if (cur_floor == N) break; //위층 막대기에 도착하면
			
			move(); //막대기 이동
			time++;
		}
		System.out.println(time);
	}
	private static void up() {
		while (true) {
			if (cur_floor == N) break;
			
			int start = building[cur_floor].start;
			int end = building[cur_floor].end;
			
			int up_start = building[cur_floor+1].start;
			int up_end = building[cur_floor+1].end;
			
			boolean flag = false;
			
			for (int i=end;i>=start;i--) {
				if (i>=up_start && i<=up_end) {
					cur_floor++;
					flag = true;
					break;
				}
			}
			
			if (!flag) break;
		}
	}
	private static void move() {
		for (int i=1;i<=N;i++) {
			Node cur = building[i];
			
			//왼쪽으로 이동
			if (cur.dir == 1) {
				if (cur.start != 0) {
					cur.start--;
					cur.end--;
				}
				//왼쪽으로 이동 불가
				else {
					cur.start++;
					cur.end++;
					cur.dir = 0; //왼->오 방향으로 변경
				}
			}
			//오른쪽으로 이동
			else {
				if (cur.end != L) {
					cur.start++;
					cur.end++;
				}
				//오른쪽으로 이동 불가
				else {
					cur.start--;
					cur.end--;
					cur.dir = 1; //오->왼 방향으로 변경
				}
				
			}
		}
	}

}

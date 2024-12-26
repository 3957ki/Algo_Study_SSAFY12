import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * UDLR 위 아래 왼쪽 오른쪽
 * P : 위치한 칸의 아이템 줍기 (없는 칸에서 사용하면 게임 오버)
 * 
 * 모든 칸에는 아이템이 하나씩
 * 순서대로 나열했을 때 문자열이 정확히 아이디와 일치하면 한 단계 강화
 * 
 * C번 강화할 수 있고 포탈을 작동시키기 전까지 L번의 행동이 필요
 * @author KOREA
 *
 */
public class Main_3_Twitch {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int L,C;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		//알파벳의 위치 저장
		Queue<int[]> position[] = new ArrayDeque[26];
		for (int i=0;i<26;i++) {
			position[i] = new ArrayDeque<>();
		}
		
		int[] cnt = new int[26]; //남은 알파벳 갯수
		
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			for (int j=0;j<M;j++) {
				char ch = input.charAt(j);
				position[ch-'a'].add(new int[] {i,j});
				cnt[ch-'a']++;
			}
		}
		
		String id = br.readLine();
		List<Integer> idNum = new ArrayList<>();
		for (int i=0;i<id.length();i++) {
			idNum.add(id.charAt(i)-'a');
		}
		
		int x = 0;
		int y = 0;
		
		//C가 최대한이 되도록 가능한 많이 아이디만큼의 아이템 줍기
		while (true) {
			boolean isAvail = true;
			for (int i=0;i<S;i++) {
				cnt[idNum.get(i)]--;
				if (cnt[idNum.get(i)] < 0) {
					isAvail = false;
					break;
				}
				
			}
			if (!isAvail) break;
			
			for (int i=0;i<idNum.size();i++) {
				int to = idNum.get(i);
				int[] toPos = position[to].poll();
				
				int toX = toPos[0];
				int toY = toPos[1];
				
				move(x,y,toX,toY);
				sb.append("P");
				L++;
				x = toX;
				y = toY;
			}
			C++;
		}
		
		//현재 위치에서 마지막 위치까지 가기
		move(x,y,N-1,M-1);
		System.out.println(C+" "+L);
		System.out.println(sb);
	}
	
	static void move (int x, int y, int toX, int toY) {
		if (x < toX) {
			for (int i=0;i<(toX-x);i++) {
				sb.append("D");
				L++;
			}
		}
		if (x > toX) {
			for (int i=0;i<(x-toX);i++) {
				sb.append("U");
				L++;
			}
		}
		if (y < toY) {
			for (int i=0;i<(toY-y);i++) {
				sb.append("R");
				L++;
			}
		}
		if (y > toY) {
			for (int i=0;i<(y-toY);i++) {
				sb.append("L");
				L++;
			}
		}
	}

}

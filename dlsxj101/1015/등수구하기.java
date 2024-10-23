import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 메모리 : 11,628kb
 * 시간 : 68ms
 * 전략
 * 
 */
public class 등수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		if(N==0) {
			System.out.println(1);
			return;
		}
		List<Integer> rankList = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			rankList.add(Integer.parseInt(st.nextToken()));
		}

		//추가할 값이 배열 내에 있으면 값 추가하고 나머지 뒤로 밀기
		for(int i = 0; i < N; i++) {
			if(rankList.get(i) >= newScore) continue;
			rankList.add(i, newScore);
			break;
		}
		
		//추가할 값이 배열 밖에 있기 때문에
		if(rankList.size() == N) {
			//배열 밖에 추가
			rankList.add(newScore);
			//하지만 P를 넘어 랭킹에 들 수 없는 경우
			if(rankList.size() > P) {
				System.out.println(-1);
				return;
			}
		}

		int rank = 1;
		int cnt = 0;
		
		//등수 밖에 밀려난 경우는 이미 체크했기 때문에 배열을 돌면서 내 점수가 나오면 그것이 바로 내 등수
		for(int i = 0; i < rankList.size(); i++) {
			if(i != 0 && rankList.get(i-1)!=rankList.get(i)) {
				rank += cnt;
				cnt = 0;
			}
			if(rankList.get(i)==newScore) break;

			if(i != 0 && rankList.get(i-1)==rankList.get(i)) {
				cnt++;
				continue;
			}
			rank++;
		}
		System.out.println(rank);
	}
}

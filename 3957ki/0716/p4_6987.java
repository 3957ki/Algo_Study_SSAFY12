import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4_6987 {
	static int[][] arr;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

//		점수판 배열 생성
		arr = new int[6][3];

//		4가지 테스트 케이스
		for (int t = 0; t < 4; t++) {
//			경기 점수의 합
			int sum = 0;

			StringTokenizer s = new StringTokenizer(in.readLine());
//			팀별 점수 배열 입력
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					sum += arr[i][j] = Integer.parseInt(s.nextToken());
				}
			}
			flag = false;
//			총 경기 점수가 30이어야 함
			if (sum == 30) {
				dfs(0, 1);
			}
			sb.append(flag ? 1 : 0).append(' ');
		}
		System.out.println(sb);
	}

	static void dfs(int start, int next) {
//		true면 바로 종료
		if (flag) {
			return;
		}
//		마지막 2팀 간의 경기라면
		if (start == 4) {
//			승 무 패 3가지 경우의 수 탐색
			for (int i = 0; i < 3; i++) {
				arr[start][i]--;
				arr[next][2 - i]--;
//				마지막 경기 배열의 값을 감소시켰을 때 0이 되었을 경우, true로 종료
				if (arr[start][i] == 0 && arr[next][2 - i] == 0) {
					flag = true;
					return;
				}
//				아니라면 원상복귀 후 다음 경우의 수 탐색
				arr[start][i]++;
				arr[next][2 - i]++;
			}
//			마지막 경기의 경우의 수 3가지를 탐색했으나 가능하지 않다면 이전으로 돌아가기
			return;
		}
//		붙을 상대팀의 인덱스가 6이 된다면, 경기 시작팀의 인덱스 1 증가
		if (next == 6) {
			dfs(start + 1, start + 2);
			return;
		}
//		승 무 패 3가지 경우의 수 탐색
		for (int i = 0; i < 3; i++) {
			arr[start][i]--;
			arr[next][2 - i]--;
//			두 팀의 점수 중 음수가 나오면 불가능하므로, 원상복귀 후 다음 경우의 수 탐색
			if (arr[start][i] < 0 || arr[next][2 - i] < 0) {
				arr[start][i]++;
				arr[next][2 - i]++;
				continue;
			}
//			다음 매치업으로 탐색
			dfs(start, next + 1);
			arr[start][i]++;
			arr[next][2 - i]++;
		}
	}
}

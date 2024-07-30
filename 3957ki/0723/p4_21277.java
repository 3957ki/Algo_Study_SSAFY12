import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4_21277 {
	static int N1, N2, M1, M2, answer;
	static int[][] arr, arr1, arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		arr1 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N1 = Integer.parseInt(st.nextToken());
		M1 = Integer.parseInt(st.nextToken());
		arr1 = new int[51][51];
		for (int i = 1; i <= N1; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M1; j++) {
				arr1[i][j] = Integer.parseInt(s.substring(j - 1, j));
			}
		}
//		arr2 입력받기
		st = new StringTokenizer(br.readLine());
		N2 = Integer.parseInt(st.nextToken());
		M2 = Integer.parseInt(st.nextToken());
		arr2 = new int[51][51];
		for (int i = 1; i <= N2; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M2; j++) {
				arr2[i][j] = Integer.parseInt(s.substring(j - 1, j));
			}
		}
//		액자배열
		arr = new int[151][151];
		answer = Integer.MAX_VALUE;

//		액자배열 중간에 arr1 삽입
		for (int i = 51; i <= 50 + N1; i++) {
			for (int j = 51; j <= 50 + M1; j++) {
				arr[i][j] = arr1[i - 50][j - 50];
			}
		}
//		완전탐색
		for (int r = 0; r < 4; r++) {
//			arr2 회전하기
			rotate();
//			탐색 시작위치를 이동시키기
			for (int i = 1; i <= 101; i++) {
				for (int j = 1; j <= 101; j++) {
					func(i, j);
				}
			}
		}

		System.out.println(answer);
	}

//	탐색
	static void func(int y, int x) {
		for (int i = y; i <= y + N2 - 1; i++) {
			for (int j = x; j <= x + M2 - 1; j++) {
//				액자배열에서 arr1과 arr2가 겹친다면
				if (arr[i][j] == 1 && arr2[i - y + 1][j - x + 1] == 1) {
					return;
				}
			}
		}
//		겹치지 않았다면 면적 구하기
		int minY = Math.min(y, 51);
		int maxY = Math.max(y + N2 - 1, 50 + N1);
		int minX = Math.min(x, 51);
		int maxX = Math.max(x + M2 - 1, 50 + M1);
		answer = Math.min(answer, (maxY - minY + 1) * (maxX - minX + 1));
	}

//	회전
	static void rotate() {
//		arr2를 시계방향 90도 회전한 값을 temp배열에 저장
		int[][] temp = new int[51][51];
		for (int i = 1; i <= N2; i++) {
			for (int j = 1; j <= M2; j++) {
				temp[j][N2 - i + 1] = arr2[i][j];
			}
		}
//		90도 회전했으니 가로길이와 세로길이 swap
		int t = N2;
		N2 = M2;
		M2 = t;
//		arr2는 회전시킨 배열을 참조
		arr2 = temp;
	}
}

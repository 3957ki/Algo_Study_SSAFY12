import java.io.*;
import java.util.*;

public class q5567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 동기 수
		int m = Integer.parseInt(br.readLine()); // 리스트 길이
		int result = 0;

		int arr[][] = new int[m+1][2]; // 1 ~ m
		for (int i = 1; i < m+1; i++) { // 친구관계 배열 입력
			StringTokenizer st = new StringTokenizer(br.readLine()); // 과일 높이
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		boolean tf[] = new boolean[n + 1]; // 0 ~ n
		for (int i = 1; i < m+1; i++) { // 1~m
			if (arr[i][0] == 1) {
				tf[arr[i][1]] = true; // 1의 친구이면 true
			}
		}

		boolean tf2[] = new boolean[n + 1]; // 0 ~ n
		for (int i = 1; i < n + 1; i++) { // 1 ~ n
			if (tf[i]) {
				for (int j = 1; j < m+1; j++) {
					if (i == arr[j][0]) {
						
						tf2[arr[j][1]] = true;
					}
					else if(i == arr[j][1]) {
						tf2[arr[j][0]] = true;
					}
				}
			}
		}

		for (int i = 2; i < n + 1; i++) {
			if (tf[i] == true || tf2[i] == true)
				result++;
		}
		System.out.println(result);
	}
}

package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_24460_1_특별상이라도받고싶어 {

	static int size;
	static int map[][];

	static int dfs(int starty, int startx, int n) {
		if (n == 2) {
//			System.out.println(starty + " " + startx);
			int tmp[] = new int[4];
			int cnt = 0;
			for (int i = starty; i < starty + n; i++) {
				for (int j = startx; j < startx + n; j++) {
//					System.out.println(map[i][j] + " ");
					tmp[cnt] = map[i][j];
					cnt++;
				}
			}
//			System.out.println(Arrays.toString(tmp));
			Arrays.sort(tmp);
//			System.out.println("dfs : " + tmp[1]);
			return tmp[1];
		}

		n = n / 2;
		int tmp[] = new int[4];
		tmp[0] = dfs(starty, startx, n);
		tmp[1] = dfs(starty + n, startx, n);
		tmp[2] = dfs(starty, startx + n, n);
		tmp[3] = dfs(starty + n, startx + n, n);
		Arrays.sort(tmp);
		return tmp[1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		// input end

		size = N;

		if(N == 1) {
			System.out.println(map[0][0]);
			System.exit(0);
		}
		
		int answer = dfs(0, 0, N);
		System.out.println(answer);
	}
}

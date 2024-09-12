import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기19 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());

		char map[][] = new char[4*(N-1)+1][4*(N-1)+1];
		for(int i = 0; i <= 4*(N-1); i++) {
			for(int j = 0; j <= 4*(N-1); j++) {
				map[i][j] = ' ';
			}
		}
		for(int i = 0; i < 2*N; i+=2) {
			for(int n = i; n <= 4*(N-1)-i; n++) {
				for(int m = i; m <= 4*(N-1)-i; m++) {
					if(n==i || m==i || n==(4*(N-1)-i) || m==(4*(N-1)-i)) map[n][m] = '*';
				}
			}
		}

		for(int i = 0; i <= 4*(N-1); i++) {
			for(int j = 0; j <= 4*(N-1); j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
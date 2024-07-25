import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;

		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int cnt = M-N+1;

			for(int i = N; i <= M; i++) {
				String strNum = Integer.toString(i);
				boolean[] repeatCnt = new boolean[10];
				for(int k = 0; k < strNum.length(); k++) {
					int Num = strNum.charAt(k) - '0';
					if(repeatCnt[Num]) {
						cnt--;
						break;
					}
					else repeatCnt[Num] = true;
				}
			}
			System.out.println(cnt);
		}
	}
}

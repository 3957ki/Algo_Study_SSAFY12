import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1_5671 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		while ((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int answer = 0;
			Label: for (int i = N; i <= M; i++) {
				boolean[] arr = new boolean[10];
				int num = i;
				while (num > 0) {
					if (arr[num % 10]) {
						continue Label;
					}
					arr[num % 10] = true;
					num /= 10;
				}
				answer++;
			}
			System.out.println(answer);
		}
	}
}

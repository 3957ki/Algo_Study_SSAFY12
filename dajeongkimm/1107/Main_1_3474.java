import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1_3474 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			int answer = 0;
			while (N > 0) {
				N /= 5;
				answer += N;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}

}

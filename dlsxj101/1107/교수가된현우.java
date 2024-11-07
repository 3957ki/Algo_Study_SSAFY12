import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 교수가된현우 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			int input = Integer.parseInt(br.readLine().trim());
			
			int ans = 0;
			while(true) {
				if(input == 0) {
					sb.append(ans).append("\n");
					break;
				}
				
				ans += input / 5;
				input /= 5;
			}
		}
		System.out.println(sb);
	}
	
}
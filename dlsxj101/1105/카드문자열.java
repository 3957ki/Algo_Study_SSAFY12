import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 카드문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			char cards[] = new char[N];
			
			for(int i = 0; i < N; i++) {
				cards[i] = st.nextToken().charAt(0);
			}
			
			ArrayDeque<Character> ad = new ArrayDeque<>();
			char mid = cards[0];
			ad.add(mid);
			
			for(int i = 1; i < N; i++) {
				if(cards[i] <= mid) {
					mid = cards[i];
					ad.addFirst(cards[i]);
				}
				else ad.addLast(cards[i]);
			}
			
			while(!ad.isEmpty()) {
				sb.append(ad.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
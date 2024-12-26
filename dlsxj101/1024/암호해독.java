import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호해독 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().trim();
		char input[] = str.toCharArray();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		String arr[] = new String[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine().trim();
		}
		for(int k = 1; k <=26; k++) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < input.length; i++) {
				sb.append((char)((input[i]+k-'a')%26+'a'));
			}
			String tmp = sb.toString();
			for(int j = 0; j < N; j++) {
				if(tmp.contains(arr[j])) {
					System.out.println(tmp);
					return;
				}
			}
		}
	}
}

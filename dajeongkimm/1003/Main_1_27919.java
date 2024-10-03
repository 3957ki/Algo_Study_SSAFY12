import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * UDPC ÆÄÆ¼
 * 
 * 
 * @author KOREA
 *
 */
public class Main_1_27919 {
	static String V;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = br.readLine();
		if (V.length() == 0) {
			System.out.println('C');
			return;
		}
		
		int uc = 0;
		int dp = 0;
		for (char ch : V.toCharArray()) {
			if (ch == 'U' || ch == 'C') uc++;
			else dp++;
		}
		
		
		if (dp > 0) {
			if (uc > (dp+1)/2) {
				System.out.println("UDP");
			} else {
				System.out.println("DP");
			}
		}
		else {
			System.out.println('U');
		}
	}

}

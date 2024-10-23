import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UDPCÆÄÆ¼ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine().trim();
		
		int cntUC = 0;
		int cntDP = 0;
		
		for(int i = 0; i < input.length(); i++) {
			char tmp = input.charAt(i);
			if(tmp == 'U' || tmp == 'C') cntUC++;
			else if(tmp == 'D' || tmp == 'P') cntDP++;
		}
		
		int a = 0;
		
		if(cntDP % 2 == 0) a = cntDP / 2;
		else a = cntDP / 2 + 1;
		
		if(cntUC > a) sb.append("U");
		
		if(cntDP > 0) sb.append("DP");
		
		if(sb.length()==0) sb.append("C");
		
		System.out.println(sb);
	}
}
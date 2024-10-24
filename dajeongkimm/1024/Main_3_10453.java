import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_3_10453 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			String before = st.nextToken();
			String after = st.nextToken();
			
			//before와 after의 길이가 다른 경우
			if (before.length() != after.length()) {
				sb.append(-1).append(" ");
				continue;
			}
			
			List<Integer> beforeList = new ArrayList<>();
			List<Integer> afterList = new ArrayList<>();
			
			for (int i=0;i<before.length();i++) {
				if (before.charAt(i) == 'a') {
					beforeList.add(i);
				}
				if (after.charAt(i) == 'a') {
					afterList.add(i);
				}
			}
			
			if (beforeList.size() != afterList.size()) {
				sb.append(-1).append(" ");
			}
			
			int cnt = 0;
			for (int i=0;i<beforeList.size();i++) {
				cnt += Math.abs(beforeList.get(i) - afterList.get(i));
				
			}
			sb.append(cnt).append("\n");
			
			
		}
		System.out.println(sb);

	}

}

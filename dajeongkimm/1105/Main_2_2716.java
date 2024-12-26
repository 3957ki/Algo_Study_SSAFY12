import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * @author KOREA
 *
 */
public class Main_2_2716 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t=1;t<=N;t++) {
			String input = br.readLine();
			int cnt = 0;
			
			if (input.length() == 0) {
				sb.append(1).append("\n");
				continue;
			}
			
			Stack<Character> stack = new Stack<>();
			for (char ch : input.toCharArray()) {
				if (ch == '[') {
					stack.add(ch);
					cnt = Math.max(cnt, stack.size());
				}
				else if (ch == ']') {
					if (stack.peek() == '[') {
						stack.pop();
					}
				}
			}
			
			
			sb.append((int) Math.pow(2, cnt)).append("\n");
		}
		System.out.println(sb);
	}

}

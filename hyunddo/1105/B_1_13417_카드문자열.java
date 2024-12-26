package day1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_1_13417_카드문자열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			Deque<Character> queue = new ArrayDeque<>();
			char ch = st.nextToken().charAt(0);
			queue.add(ch);
			
			for(int i = 1; i<N; i++) {
				char tmp = st.nextToken().charAt(0);
				char first = queue.peek();
				if(tmp<=first)
					queue.addFirst(tmp);
				else
					queue.addLast(tmp);
			}
			
			for(Character c : queue) {
				sb.append(c);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}

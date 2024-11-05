import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 가장 왼쪽부터 한장씩 가져올 수 있음
 * 가져온 카드를 왼쪽 또는 오른쪽에 놓기
 * 
 * @author KOREA
 *
 */
public class Main_1_13417 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			String[] arr = input.split(" ");
			ArrayDeque<String> deque = new ArrayDeque<>();
			deque.add(arr[0]);
			
			for (int i=1;i<arr.length;i++) {
				if (deque.peek().charAt(0) < arr[i].charAt(0)) {
					deque.addLast(arr[i]);
				}else {
					deque.addFirst(arr[i]);
				}
			}
			
			while (!deque.isEmpty()) {
				sb.append(deque.pollFirst());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}

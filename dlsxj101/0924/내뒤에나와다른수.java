import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 내뒤에나와다른수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());
		if(N == 1) {
			System.out.println(-1);
			return;
		}
		
		int arr[] = new int[N];
		List<Integer> answer = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i == 0) continue;
			if(arr[i] == arr[i-1]) continue;
			answer.add(i+1);
		}
		int index = 0;
		if(index >= answer.size()) {
			sb.append(-1).append(" ");
		}else {
			sb.append(answer.get(index)).append(" ");
		}
		for(int i = 1; i < N; i++) {
			if(arr[i] != arr[i-1]) index++;
			
			if(index >= answer.size()) {
				sb.append(-1).append(" ");
			}else {
				sb.append(answer.get(index)).append(" ");
			}
		}
		System.out.println(sb);
	}
}

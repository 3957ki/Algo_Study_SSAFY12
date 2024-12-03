import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2_»ç´Ù¸® {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			for (int i=0;i<N;i++) {
				for (int j=i+1;j<N;j++) {
					if (arr[j] < arr[i]) {
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
						
						answer++;
					}
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}

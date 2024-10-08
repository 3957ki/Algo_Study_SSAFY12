import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소가길을건너간이유3 {
	static class arriveCow implements Comparable<arriveCow>{
		int arrive;
		int check;
		public arriveCow(int arrive, int check) {
			this.arrive = arrive;
			this.check = check;
		}
		@Override
		public int compareTo(arriveCow o) {
			return Integer.compare(this.arrive, o.arrive);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		arriveCow arr[] = new arriveCow[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i] = new arriveCow(a, b);
		}
		Arrays.sort(arr);
		
		int num = arr[0].arrive + arr[0].check;
		int answer = 0;
		for(int i = 1; i < N; i++) {
			num = Math.max(num, arr[i].arrive);
			num = num + arr[i].check;
		}
		System.out.println(num);
	}

}

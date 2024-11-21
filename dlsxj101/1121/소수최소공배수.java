import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 소수최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		boolean prime[] = new boolean[1_000_001];	//소수라면  false
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i*i <= 1_000_000; i++) {
			if(!prime[i]) {	//i가 소수라면
				for(int j = i*i; j <= 1_000_000; j+=i) {
					prime[j] = true;	//i의 배수들은 소수가 아님
				}
			}
		}
		
		int N = Integer.parseInt(br.readLine().trim());
		
		List<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			if(!prime[tmp]) list.add(tmp);
		}
		
		if(list.size() == 0) System.out.println(-1);
		else {
			long ans = list.get(0);
			for(int i : list) {
				ans = lcm(ans, i);
			}
			System.out.println(ans);
		}

	}
	static long gcd(long a, long b) {
		while(b != 0) {
			long tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
	
	static long lcm(long a, long b) {
		return a*b / gcd(a, b);
	}
}
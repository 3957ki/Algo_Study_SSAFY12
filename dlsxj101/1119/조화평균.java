import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 */
public class 조화평균 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		
		long arr[] = new long[N];
		
		st = new StringTokenizer(br.readLine());
		long mulNum = 1;
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			mulNum *= arr[i];
		}
		
		long sumNum = 0;
		for(int i = 0; i < N; i++) {
			sumNum += mulNum / arr[i];
		}
		
		long gcdNum = 0;
		
		if(sumNum >= mulNum) {
			gcdNum = gcd(sumNum, mulNum);
		}
		else {
			gcdNum = gcd(mulNum, sumNum);
		}
		
		long a = sumNum / gcdNum;
		long b = mulNum / gcdNum;
		
		System.out.println(b+"/"+a);
	}
	static long gcd(long a, long b) {
		while(b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 제곱수의합 {
	static int N, ans, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		min = Integer.MAX_VALUE;
		
		method(N, 0);
		
		System.out.println(min);
	}
	
	static void method(int num, int cnt) {
		if(min <= cnt) return;
		if(num == 0) {
			min = Math.min(min, cnt);
			return;
		}
		int tmp = (int)Math.sqrt(num);
		for(int i = tmp; i >=1; i--) {
			method(num - i*i, cnt+1);
		}
	}
}
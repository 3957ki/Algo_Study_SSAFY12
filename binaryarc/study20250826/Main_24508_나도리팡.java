package study20250826;
import java.io.*;
import java.util.*;

public class Main_24508_나도리팡 {
	static int N,K,T;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); //터지는 수
		T = Integer.parseInt(st.nextToken());
		
		long[] bucket = new long[N];
		long sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			bucket[i] = n;
			sum+= n;
		}
		
		if(sum % K != 0) {
			System.out.println("NO");
			return;
		}
		
		Arrays.sort(bucket);
		int left = 0, right = N-1;
		while(bucket[left] == 0 && left<right)left++;
		
		long move = T;
		while(bucket[right] < K && left < right) {
			long n = Math.min(bucket[left], K - bucket[right]);
			move -= n;
			if(move < 0) {
				System.out.println("NO");
				return;
			}
			bucket[left] -= n;
			bucket[right] += n;
			while(bucket[left] == 0 && left<right)left++;
			if(bucket[right] == K) {
				bucket[right] = 0;
				right--;
			}
		}
		
		System.out.println("YES");
	}
}

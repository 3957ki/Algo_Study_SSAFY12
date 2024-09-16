package study0822;
/*
 * 
 * 
 */
import java.io.*;
import java.util.*;
public class b1_11508_21세일 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		Integer[] arr = new Integer[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,Collections.reverseOrder());
		long ans=0;
		int idx=0;
		int cnt=0;
		while(idx<N) {
			if(cnt==2) {
				cnt=0;
				idx++;
				continue;
			}
			ans+=arr[idx];
			cnt++;
			idx++;
		}
		
		
		System.out.println(ans);
		
		
	}

}

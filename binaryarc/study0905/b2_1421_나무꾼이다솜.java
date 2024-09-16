package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2_1421_나무꾼이다솜 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//나무개수 N
		int N = Integer.parseInt(st.nextToken());
		//자를때 드는 비용 C
		int C = Integer.parseInt(st.nextToken());
		//다무한단위가격 W
		int W = Integer.parseInt(st.nextToken());
		
		//나무 K개 길이L이면 K*L*W원
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int k = 0;
		int cost = 0;
		int left = 0;
		int right = arr[N-1];
		int mid = arr[N/2];
		
		while(mid >= left) {
			cost++;
			if(mid - left > right - mid) {
				right = mid;
				mid = (mid-left)/2;
			}else {
				left = mid;
				mid = (right-mid / 2);
			}
		}
		System.out.println(mid);
		
		
		
		
		
	}
}

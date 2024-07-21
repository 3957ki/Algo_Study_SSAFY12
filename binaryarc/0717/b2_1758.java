package algostudy0717;

import java.io.*;
import java.util.*;
public class b2_1758 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Integer[] tips = new Integer[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			tips[i] = Integer.parseInt(st.nextToken());
		}
		int cnt=1;
		long res=0;
		
		Arrays.sort(tips,Collections.reverseOrder());
//		Arrays.sort(tips);
		for(int i=0;i<N;i++) {
			int temp_res = tips[i]-(cnt-1);
			if(temp_res > 0) {
				res += temp_res;
			}
			cnt++;
		}
		System.out.println(res);
		
		
	}

}

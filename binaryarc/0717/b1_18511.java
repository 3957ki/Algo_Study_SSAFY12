package algostudy0717;

import java.io.*;
import java.util.*;
public class b1_18511 {
	static HashSet<Integer> set = new HashSet<>();
	static String N;
	static int K;
	static Integer[] arr;

	public static void dfs(int L,int num) {
		if(L == N.length() ) {
			if(num <= Integer.parseInt(N))set.add(num);
			return;
		}
		int temp_num=0;
		for(int i=0;i<K;i++) {
			temp_num = num * 10;
			temp_num = temp_num + arr[i];
//			System.out.println((arr[i] -'0'));
			if(temp_num == Integer.parseInt(N)) {
				set.add(temp_num);
				return;
			}else if(temp_num < Integer.parseInt(N))
			{
				set.add(temp_num);
				dfs(L+1,temp_num);
			}
			
		}
	}
	
	
	public static void main(String[] args) throws Exception{
	
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = st.nextToken();
	    K = Integer.parseInt(st.nextToken());
	    
	    arr = new Integer[K];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<K;i++) {
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
//	    Arrays.sort(arr);
	    Arrays.sort(arr,Collections.reverseOrder());
	    
	    for(int i=0;i<K;i++) {
	    	if( arr[i]<= Integer.parseInt(N))
			{
				set.add(arr[i]);
			}
	    	dfs(1,arr[i]);
	    }
	    int max = set.stream().max(Integer::compareTo).get();
	    System.out.println(max);

	}
}

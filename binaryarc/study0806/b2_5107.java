package study0806;

import java.io.*;
import java.util.*;
//백준 5107 마니또
public class b2_5107 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testC = 1;
		
		while(true) {
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N==0) {
				break;
			}
			System.out.print(testC+" ");
			Map<String, String> map = new HashMap<>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				map.put(a,b);
			}
			
			Set<String> keys = map.keySet();
			String[] arr = keys.toArray(new String[0]);
			for(int i=0;i<arr.length;i++) {
				String curr = arr[i];
				while(map.containsKey(curr)) {
					String next = map.get(curr);
					map.remove(curr);
					if(!map.containsKey(next)) {
						map.remove(next);
						ans++;
						break;
					}
					curr = next;
				}//Ax -> S -> C -> A
			}
			System.out.println(ans);
			testC++;
		}
		
	}
}
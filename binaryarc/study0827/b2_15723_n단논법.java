package study0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class b2_15723_n단논법 {
	static Map<Character, Character> map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		map = new HashMap<Character, Character>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char from = st.nextToken().charAt(0);
			st.nextToken();
			char to = st.nextToken().charAt(0);
			map.put(from,to);
			
		}
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char from = st.nextToken().charAt(0);
			st.nextToken();
			char to = st.nextToken().charAt(0);
			char key = from;
			while(map.get(key)!=null) {
				key = map.get(key);
				if(key == to) {
					break;
				}
			}
			
			if(key == to)sb.append("T").append("\n");
			else sb.append("F").append("\n");
		}
		System.out.print(sb);
	}
	
}

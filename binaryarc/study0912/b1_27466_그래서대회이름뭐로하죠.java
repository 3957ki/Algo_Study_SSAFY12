package study0912;

import java.io.*;
import java.util.*;

public class b1_27466_그래서대회이름뭐로하죠 {
	static int N,M;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String input = st.nextToken();
		char[] chArr = input.toCharArray();
		Arrays.sort(chArr);
		StringBuilder sb = new StringBuilder(new String(chArr));
		sb.reverse();
		boolean flag1 = false;
		for(int i = 0 ;i <= sb.length()-4;i++) {
			if(sb.charAt(i) != 'A' && sb.charAt(i) != 'E' && sb.charAt(i) != 'I'
					&& sb.charAt(i) != 'O' && sb.charAt(i) != 'U') {
				sb.append(sb.charAt(i));
				sb.deleteCharAt(i);
				flag1 = true;
				break;
			}
		}
		
		int len = sb.length();
		boolean flag2 = false;
		if(sb.charAt(len-2) == 'A' && sb.charAt(len-3) == 'A') {
			flag2 = true;
		}
		
		if(sb.length() == M && flag1 && flag2) {
			System.out.println("YES");
			System.out.println(sb);
		}else if(sb.length() > M && flag1 && flag2) {
			for(int i=0;i <= sb.length() - M; i++) {
				sb.deleteCharAt(0);
			}
			System.out.println("YES");
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
		
	}

}

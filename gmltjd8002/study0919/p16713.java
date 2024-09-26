package study0919;
import java.io.*;
import java.util.*;

public class p16713 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int map[] = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int next = Integer.parseInt(st.nextToken());
			map[i] = map[i-1]^next;
		}
		int res = 0;
		for(int i = 0 ; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			res ^= map[R]^map[L-1];
		}
		sb.append(res).append("\n");
		System.out.println(sb);
	}
}
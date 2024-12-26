package study1107;
import java.io.*;
import java.util.*;
public class b2_17827_달팽이리스트 {
	static List<Integer>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list[i]= new ArrayList<>();
			list[i].add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			if(K <N) {
				sb.append(list[K].get(0)).append('\n');
			}else {
				int cnt = (K-(V-1)) % (N-V+1);
				sb.append(list[V-1+cnt].get(0)).append('\n');
			}
		}
		System.out.println(sb);
	}
	
}
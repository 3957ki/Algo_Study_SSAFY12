import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2_30205 {
	static int N,M;
	static long P;
	
	static int[][] arr;
	static List<Integer> list[];
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Long.parseLong(st.nextToken());
		
		list = new ArrayList[N];
		for (int i=0;i<N;i++) {
			list[i] = new ArrayList<>();
		}
		
		int[] cnt = new int[N];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1) cnt[i]++;
				else {
					list[i].add(num);
				}
			}
		}
		
		for (int i=0;i<N;i++) {
			List<Integer> tmp = list[i];
			Collections.sort(tmp);
			
			int idx = 0;
			while (idx<tmp.size()) {
				int cur = tmp.get(idx);
				
				if (cur > P) {
					if (cnt[i] == 0) {
						System.out.println(0);
						return;
					}
					P *= 2;
					cnt[i]--;
				}
				else{
					idx++;
					P += cur;
				}
			}
			
			while (cnt[i]>0) {
				P*=2;
				cnt[i]--;
			}
			
		}
		System.out.println(1);


	}
//	static void dfs(List<Integer>tmp, long curP, int count, int idx) {
//		if (idx == tmp.size()) {
//			flag = true;
//			return;
//		}
//		
//		int num = tmp.get(idx);
//		if (num > curP) {
//			if (count>0) {
//				dfs(tmp, curP*2, count-1, idx+1);
//				if (flag) return;
//			}
//		}
//		
//		dfs(tmp, curP+tmp.get(idx), count, idx+1);
//	}
	

}

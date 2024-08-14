import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class BJ_study_2_1495 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] V = new int[N];	//볼륨의 차이
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		HashSet<Integer> P1 = new HashSet<>();
		HashSet<Integer> P2 = new HashSet<>();
		P2.add(S);
		boolean flag = false;
		
		for(int i = 0; i < N; i++) {
			if(!flag) {
				P1.clear();
				for(int num : P2) {
					if((num + V[i]) <= M) P1.add(num + V[i]);
					if((num - V[i]) >= 0) P1.add(num - V[i]);
				}
				flag = true;
			}else if(flag) {
				P2.clear();
				for(int num : P1) {
					if((num + V[i]) <= M) P2.add(num + V[i]);
					if((num - V[i]) >= 0) P2.add(num - V[i]);
				}
				flag = false;
			}
		}
		int max = -1;
		if(flag) {
			for(int num : P1) {
				max = Math.max(max, num);
			}
		}else if(!flag) {
			for(int num : P2) {
				max = Math.max(max, num);
			}
		}
		System.out.println(max);
	}
}

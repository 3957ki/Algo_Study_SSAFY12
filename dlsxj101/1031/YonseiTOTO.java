import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class YonseiTOTO {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer> list[] = new List[n];
		for(int i = 0 ; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		
		List<Integer> target = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < P; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
			if(P < L) target.add(1);
			else {
				Collections.sort(list[i], Comparator.reverseOrder());
				target.add(list[i].get(L-1));
			}
		}
		
		Collections.sort(target);
		int total = 0;
		int cnt = 0;
		for(int i : target) {
			if(total+i > m) break;
			
			total += i;
			cnt++;
		}
		System.out.println(cnt);
	}
}
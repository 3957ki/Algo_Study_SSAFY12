import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1_12018 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //과목수
		int m = Integer.parseInt(st.nextToken()); //마일리지
		
		int[] need = new int[n];
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			List<Integer> how = new ArrayList<>();
			for (int j=0;j<p;j++) {
				how.add(Integer.parseInt(st.nextToken()));
			}
			
			//큰순으로 내림차순
			Collections.sort(how, Collections.reverseOrder());
			if (p >= l) {
				need[i] = how.get(l-1);
			}
			else {
				need[i] = 1;
			}
		}
		
		Arrays.sort(need);
		int answer = 0;
		for (int i=0;i<n;i++) {
			if (m >= need[i]) {
				answer++;
				m -= need[i];
			}
			
		}
		System.out.println(answer);
	}

}

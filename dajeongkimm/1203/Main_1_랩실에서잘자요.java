import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1_랩실에서잘자요 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		boolean[] paper = new boolean[N+1];
		for (int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			paper[num] = true;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=1;i<=N;i++) {
			if (!paper[i]) list.add(i);
		}
		
		int answer = 0;
		if (list.size() == 0) {
			System.out.println(0);
			return;
		}
		
		answer += 7;
		int lastNum = list.get(0);
		for (int i=1;i<list.size();i++) {
			int cur = list.get(i);
			
			if ((cur-lastNum) >= 4) {
				answer += 7;
			}
			else {
				answer += (2*(cur-lastNum));
				
			}
			lastNum = cur;
		}
		System.out.println(answer);

	}

}

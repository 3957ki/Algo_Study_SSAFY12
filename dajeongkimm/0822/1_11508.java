import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 과일우유, 드링킹요구르트 --> 2+1 세일
 * 유제품 3개 : 가장 싼 것은 무료
 * @author SSAFY
 *
 */
public class Main_11508 {
	static int N;
	static int[] cost;
	
	static long answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		answer = 0;
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N];
		for (int i=0;i<N;i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		cost = Arrays.stream(cost).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		
		for (int i=0;i<N;i++) {
			if (i%3 == 2) continue;
			else {
				answer += cost[i];
//				System.out.println("add cost: "+cost[i]);
			}
		}
		
		System.out.println(answer);

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 블랙 프라이데이
 * 양의 정수의 무게 C에 딱 맞게 물건을 안가져오면 전부 만원에 판매하는 이벤트
 * 선택할 수 있는 물건은 최대 3개, 같은 물건을 중복 선택하는 것은 불가
 * 백화점에서 판매하는 물건들의 무게는 모두 다름
 * 
 * 판매하는 물건 N개의 양의 정수의 무게가 주어질때 만원에 구매할 수 있는 조합이 있는지?
 * 
 * @author KOREA
 *
 */
public class Main_3_18114 {
	static int N,C;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		//--------------------------------------------
		
		Arrays.sort(arr);
		
		int answer = 0;
		//물건을 한개만 살때
		if (arr[1] == C || arr[N] == C) {
			System.out.println(1);
			return;
		}
		//물건을 두개 이상 살때
		else {
			int start = 1;
			int end = N;
			while (start<end) {
				//두가지 물건 선택
				int w = arr[start]+arr[end];
				//두가지 물건이 이미 C보다 크면 
				if (w > C) end--;
				//두가지 물건이 C보다 작으면
				else if (w < C) {
					if (set.contains(C-w) && (C-w) != arr[start] && (C-w) != arr[end]) {
						answer = 1;
						break;
					}
					else start++;
				//두가지 물건의 합이 C와 같으면
				}else if (w == C) {
					answer = 1;
					break;
				}
			}
		}
		
		
		System.out.println(answer);
		

	}
	

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * 실행 시간 : kb
 * 메모리 : ms
 * 전략
 *
 */
public class 붙임성좋은총총이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		
		Map<String, Boolean> map = new HashMap<>();
		map.put("ChongChong", true);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String input1 = st.nextToken();
			String input2 = st.nextToken();
			
			if(map.containsKey(input1)) {
				if(map.get(input1)) {
					map.put(input2, true);
				}
			}else map.put(input1, false);
			if(map.containsKey(input2)) {
				if(map.get(input2)) {
					map.put(input1, true);
				}
			}else map.put(input2, false);
		}
		int ans = 0;
		for(Boolean chk:map.values()) {
			if(chk) ans++;
		}
		System.out.println(ans);
	}
}

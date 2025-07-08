import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p2_5107 {
	static int N, answer;
	static boolean[] visited;
	static HashMap<String, String> map;
	static String[] keyset;
	static int t = 1;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	while (true) {
    		N = Integer.parseInt(br.readLine());
//    		N이 0이면 루프 break
    		if(N == 0) break;
    		answer = 0;
    		map = new HashMap<>();
    		visited = new boolean[N+1];
    		for(int i = 1; i <= N; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			String name = st.nextToken();
    			String next = st.nextToken();
//    			자기 이름과 마니또 이름을 key value로 hashmap에 put
    			map.put(name, next);
    		}
//    		map의 keyset을 String배열로 생성
    		keyset = map.keySet().toArray(new String[0]);
//    		탐색
    		for(int i = 0; i < N; i++) {
    			func(keyset[i], keyset[i]);
    		}
    		sb.append(t).append(' ').append(answer).append('\n');
    		t++;
    	}
    	System.out.println(sb);
    }
    
    static void func(String name, String first) {
//    	다음 사람 이름 next
    	String next = map.get(name);
//    	다음 사람이 없으면 루프가 없으니 return
    	if(next == null) return;
//    	다음 사람이 첫번째 사람과 같으면
    	if(next.equals(first)) {
//    		map에서 첫번째 사람을 지우고 answer 증가
    		map.remove(first);
    		answer++;
    		return;
    	}
//    	다음 사람 이름으로 재귀
    	func(next, first);
//    	map에서 다음 사람 이름 지우기
    	map.remove(next);
    	return;
    }
}

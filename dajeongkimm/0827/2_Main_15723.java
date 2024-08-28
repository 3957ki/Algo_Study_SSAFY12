import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * n단 논법
 * 전제 두 개 -> 결론 하나
 * n개의 전체가 있을때 m개의 결론 도출
 * 
 * a -> b -> c -> d
 * @author SSAFY
 *
 */
public class Main_15723 {
	static int n;
	static int m;
	
	static int target;
	static int cnt;
	static boolean answer;
	
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i=0;i<26;i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			String tmp = st.nextToken();
			char b = st.nextToken().charAt(0);
			
			graph.get(a-'a').add(b-'a');
		}
		
		m = Integer.parseInt(br.readLine());
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			String tmp = st.nextToken();
			char b = st.nextToken().charAt(0);
			
			target = b-'a';
			answer = false;
			cnt=0;
			test(a-'a');
			if (answer) System.out.println("T");
			else System.out.println("F");
		}
	}
	
	public static void test(int a) {
		if (a == target && cnt>=2) {
			answer = true;
			return;
		}
		for (int i : graph.get(a)) {
			cnt++;
			test(i);
		}
	}
	
	

}

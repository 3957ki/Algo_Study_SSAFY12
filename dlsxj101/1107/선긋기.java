import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class 선긋기 {
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.x, o.x);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine().trim());
		Point points[] = new Point[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			points[i] = new Point(x, y); 
		}
		Arrays.sort(points);
		
		int start = Integer.MIN_VALUE;
		int end = Integer.MIN_VALUE;
		
		int answer = 0;
		for(Point p : points) {
			if(end < p.x) {
				answer += (end - start);
				start = p.x;
				end = p.y;
			}else if(end < p.y) {
				end = p.y;
			}
		}
		answer += (end - start);
		System.out.println(answer);
	}
}
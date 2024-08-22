package study0820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1_14400_편의점2 {
	public static class Point implements Comparable<Point>{
		int x;
		int y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			if(this.x == o.x) {
				return this.y-o.y;
			}else return this.x - o.x;
			
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Point[] arr = new Point[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Point(x, y);
		}
		
		int mid = (int)(n/2);
		Arrays.sort(arr,(o1,o2)->{return o1.x-o2.x;});
		int x = arr[mid].x;
		Arrays.sort(arr,(o1,o2)->{return o1.y-o2.y;});
		int y = arr[mid].y;
		long sum=0;
		for(int i=0;i<n;i++) {
			sum += Math.abs(x - arr[i].x) + Math.abs(y - arr[i].y);
		}
		System.out.println(sum);
	}

}

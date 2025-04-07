package algo250401;

import java.io.*;
import java.util.*;

public class Main_2171_지사각형의개수 {
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static List<Point> list;
	static Map<Integer,HashSet<Integer>> map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x,y));
			HashSet<Integer> set = map.getOrDefault(x, new HashSet<Integer>());
			set.add(y);
			map.put(x,set);
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			Point p1 = list.get(i);
			HashSet<Integer> p3_y = map.get(p1.x);
			for (int j = i + 1; j < N; j++) {
				Point p2 = list.get(j);
				if(p1.x != p2.x && p1.y != p2.y) {
					HashSet<Integer> p4_y = map.get(p2.x);
					if(p3_y == null || p4_y == null)continue;
					if(p3_y.contains(p2.y) && p4_y.contains(p1.y))ans++;
				}
			}
		}
		System.out.println(ans/2);
	}
} 
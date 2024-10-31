package day1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1_21735_눈덩이굴리기 {

	static class Snowball implements Comparable<Snowball> {
		int location;
		int size;

		public Snowball(int location, int size) {
			super();
			this.location = location;
			this.size = size;
		}

		@Override
		public int compareTo(Snowball o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.size, this.size);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N + 1];
		st = new StringTokenizer(br.readLine().trim());
		arr[0] = 1;
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// input end

		int time = 0;
		Queue<Snowball> queue = new ArrayDeque<>();
		List<Snowball> list = new ArrayList<>();
		queue.add(new Snowball(1, arr[0] + arr[1]));
		list.add(new Snowball(1, arr[0]+arr[1]));
		if (N >= 2) {
			queue.add(new Snowball(2, arr[0] / 2 + arr[2]));
			list.add(new Snowball(2, arr[0] / 2 + arr[2]));
		}
		
		while (true) {
			time++;
			if (time == M)
				break;
			int queueSize = queue.size();
//			System.out.println(time+"================"+queue.size());
			while (queueSize != 0) {
				queueSize--;
				Snowball sn = queue.poll();
				int loc = sn.location;
				int si = sn.size;
//				System.out.println(loc+" "+si);
				if (loc + 1 <= N) {
					queue.add(new Snowball(loc + 1, si + arr[loc + 1]));
					list.add(new Snowball(loc + 1, si + arr[loc + 1]));
				}
				if (loc + 2 <= N) {
					queue.add(new Snowball(loc + 2, si / 2 + arr[loc + 2]));
					list.add(new Snowball(loc + 2, si / 2 + arr[loc + 2]));
				}
			}
		}
		Collections.sort(list);
//		System.out.println("====================");
//		for(Snowball sb : list) {
//			System.out.println(sb.location+ " " +sb.size);
//		}
		System.out.println(list.get(0).size);
	}
}

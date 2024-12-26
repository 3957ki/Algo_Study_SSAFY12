package day1114;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_2_30205_전역임무 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long P = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N; n++) {
			List<Long> list = new ArrayList<>();
			int item = 0;
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < M; i++) {
				long tmp = Long.parseLong(st.nextToken());
				if (tmp == -1)
					item++;
				else
					list.add(tmp);
			}
			Collections.sort(list);

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) <= P)
					P += list.get(i);
				else {
					if (item > 0) {
						P *= 2;
						item--;
						if (list.get(i) <= P)
							P += list.get(i);
						else {
							System.out.println(0);
							System.exit(0);
						}
					} else {
						System.out.println(0);
						System.exit(0);
					}
				}
			}
			if (item > 0) {
				P *= Math.pow(2, item);
				item = 0;
			}
//			System.out.println(P);
		}
		System.out.println(1);
	}
}

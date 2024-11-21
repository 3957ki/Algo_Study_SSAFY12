package day1121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_1_21919_소수최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			boolean flag = false;
			for (int j = 2; j <= Math.sqrt(tmp); j++) {
				if (tmp % j == 0) {
					flag = true;
					continue;
				}
			}
			if (!flag)
				list.add(tmp);
		}
//		for(int num:list) {
//			System.out.println(num);
//		}
		// input end
		
		if(list.size()==0) {
			System.out.println(-1);
			System.exit(0);
		}
			
		
		long a = list.get(0);
		long max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			long b = list.get(i);
			if (list.get(i) == 1)
				continue;
			while (b != 0) {
				long tmp = b;
				b = a % b;
				a = tmp;
			}
			max = (list.get(i) * max) / a;
		}
		
		System.out.println(max);
		
	}
}

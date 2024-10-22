package day1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B_26069_1_붙임성좋은총총이 {
// 딸기야 안녕❤️
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String arr[][] = new String[N][2];
		HashSet<String> list = new HashSet<>();
		list.add("ChongChong");
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();

			if (list.contains(arr[i][0]))
				list.add(arr[i][1]);
			else if (list.contains(arr[i][1]))
				list.add(arr[i][0]);
		}
		System.out.println(list.size());
	}
}

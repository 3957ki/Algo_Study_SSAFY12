package day0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1487_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 구매할 의향이 있는 사람의 수
		int answer = 0;
		int min_price = 0;

		int arr[][] = new int[N][2]; // 입력
		int price[] = new int[N]; // 원하는 가격일때의 가격

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 지불 금액
			arr[i][1] = Integer.parseInt(st.nextToken()); // 배송비
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[j][0] >= arr[i][0] && arr[i][0] >= arr[j][1]) {
					price[i] += arr[i][0] - arr[j][1];
				}
			}
			if (price[i] > answer) {
				answer = price[i];
				min_price = arr[i][0];
			}
			else if(price[i] == answer && min_price > arr[i][0]) {
				min_price = arr[i][0];
			}
		}
		System.out.println(min_price);
	}
}

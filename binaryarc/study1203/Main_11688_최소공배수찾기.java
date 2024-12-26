package study1203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_11688_최소공배수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong(); // 첫 번째 숫자
		long b = sc.nextLong(); // 두 번째 숫자
		long L = sc.nextLong(); // 목표 최소공배수

		// a b의 최소공배수
		long lcm_ab = lcm(a, b);

		// L이 a와 b의 최소공배수(lcm_ab)의 배수가 아니면 불가능하므로 -1 출력
		if (L % lcm_ab != 0) {
			System.out.println(-1);
			return;
		}

		// lcm_ab의 모든 약수를 구하기 위한 리스트
		List<Long> list = new ArrayList<>();
		for (long i = 1; i <= Math.sqrt(lcm_ab); i++) {
			if (lcm_ab % i == 0) { 
				list.add(i); // i는 약수
				list.add(lcm_ab / i); // lcm_ab / i도 약수
			}
		}

		// 약수를 정렬 (오름차순)
		Collections.sort(list);

		boolean find = false;
		long c = -1;
		long k = L / lcm_ab; // L이 lcm_ab의 배수이므로 k는 그 배수 계수

		// 약수 리스트를 순회하며 적합한 c를 찾음
		for (int i = 0; i < list.size(); i++) {
			c = k * list.get(i); // c는 k와 현재 약수의 곱
			long gcd_abc = gcd(lcm_ab, c); // lcm_ab와 c의 최대공약수 계산

			// gcd(lcm_ab, c)가 현재 약수와 같으면 조건을 만족
			if (gcd_abc == list.get(i)) {
				find = true;
				break;
			}
		}

		System.out.println(c);
	}

	// 최대공약수 / 유클리드 호재법
	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b; 
			a = temp; 
		}
		return a; 
	}

	// 최소공배수(LCM)를 계산하는 함수
	public static long lcm(long a, long b) {
		if (a == 0 || b == 0) // 둘 중 하나가 0이면 LCM은 0
			return 0;
		return a / gcd(a, b) * b; //오버 플로우 방지 b 나중에 계산
	}
}

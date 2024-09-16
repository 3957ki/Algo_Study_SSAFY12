package study0910;

import java.util.Scanner;

public class b2_11687_팩토리얼0의개수 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		//5의 배수가 나올떄마다 0개수가 증가함
		int ans = 0;
		while(num >= 5) {
			ans += num/5;
			num /= 5;
		}
	}
}

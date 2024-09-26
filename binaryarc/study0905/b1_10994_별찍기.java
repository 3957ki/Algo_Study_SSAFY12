package study0905;

import java.util.Scanner;

public class b1_10994_별찍기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1)System.out.println("*");
		int nn = (n-1)*4+1;

		for(int i = 0 ; i < nn ; i++) {
			for(int j = 0; j < nn ; j++) {
				if(i==0 || i == nn-1 || j == 0 || j == nn-1)  {
					System.out.print("*");
					continue;
				}else if(i%2 != 0 ) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

}

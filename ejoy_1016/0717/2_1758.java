package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 2_1758 {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int person = sc.nextInt();
		
		Integer[] tip = new Integer[person];
		for (int i = 0; i<person; i++) {
			tip[i] = sc.nextInt();
		}
		
		
		Arrays.sort(tip,Comparator.reverseOrder());
		
		// tip[i] - ( (i+1) -1 ) 
		//팁의 최댓값 ,,^^
		
		long total = 0;
		for(int i =0; i<person; i++) {
			int tmp = tip[i] - ((i+1)-1);
			if (tmp < 0 ) {
				tmp = 0;
			}
			total += tmp;
		}
		
		System.out.println(total);

		
	}

}
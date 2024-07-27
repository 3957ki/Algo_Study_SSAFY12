package allgostudy0723;

import java.util.*;


public class b1_5671 {
	static int N,M;
	
	public static boolean chk(String nums) {
		for(int t=0;t<nums.length();t++) {
			for(int i=0;i<nums.length();i++) {
				if(t != i ) {
					if(nums.charAt(i) == nums.charAt(t))return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int count = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			for(int i=N;i<=M;i++) {
				if(!chk(Integer.toString(i)))count++;
			}
			System.out.println(count);
		}
		
	}

}

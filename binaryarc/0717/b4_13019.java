package algostudy0717;

import java.io.*;
import java.util.*;
public class b4_13019 {
	public static boolean compareAB(String a, String b) {
		char[] compA = a.toCharArray();
		char[] compB = b.toCharArray();
		Arrays.sort(compA);
		Arrays.sort(compB);
		String sortedA = new String(compA);
		String sortedB = new String(compB);
		return sortedA.equals(sortedB);
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		
		
		if(A.length == 1 && B.length == 1 && A[0] != B[0])
		{
			System.out.println(-1);
			return;
		}
		if( !compareAB(new String(A), new String(B)) ) { //정렬해서 다르면 A를 B로 바꿀 수 없음
			System.out.println(-1);
			return;
		}
		
		int idxA = A.length-1;
		int cnt = 0;
		for(int idxB = idxA ; idxB >=0 && idxA >=0 ;idxB--,idxA--) {
			while(idxA >=0 && B[idxB] != A[idxA])
			{
				cnt++;
				idxA--;
			}
		}
		System.out.println(cnt);
	}

}

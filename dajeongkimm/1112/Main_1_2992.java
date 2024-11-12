import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1_2992 {
	static char[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int X = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		
		if (!nextPermutation()) {
			System.out.println(0);
			return;
		}
		
		String answer = "";
		for (int i=0;i<arr.length;i++) {
			answer += arr[i];
		}
		System.out.println(Integer.parseInt(answer));
		
	}
	static boolean nextPermutation() {
		int i = arr.length-2;
		
		while (i >= 0 && (arr[i] >= arr[i+1])) {
			i--;
		}
		
		if (i == -1) return false;
		
		//더 큰 j 찾기
		int j = arr.length - 1 ;
		while (arr[i] >= arr[j]) {
			j--;
		}
		
		//i랑 j 스왑
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
		//i 이후 reverse
		reverse(i);
		return true;
	}
	static void reverse(int n) {
		char[] copy = new char[arr.length];
		for (int i=0;i<copy.length;i++) {
			copy[i] = arr[i];
		}
		
		int cnt=1;
		for (int i=n+1;i<copy.length;i++) {
			arr[i] = copy[copy.length-cnt++];
		}
	}

}

package algo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;






public class Main2 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		

		while( (line = br.readLine()) != null  ) {
			
			String[] temp = line.trim().split(" ");
		
			
			int N = Integer.parseInt(temp[0]);
			int M = Integer.parseInt(temp[1]);
			
			int result = 0;
			
			for (int i=N; i<=M; i++) {
				
				String tmp = String.valueOf(i);
				
				int numArr[] = new int[10];
				
				int flag = 1;
				for (int j = 0; j<tmp.length(); j++) {
					
					int num = tmp.charAt(j) - '0';
					numArr[num]++;
					
					if (numArr[num] > 1) {
						flag = 0;
						break;
						}
						
					}
				result += flag;
				}	
			
			System.out.println(result);
			
		}
				
	}

}

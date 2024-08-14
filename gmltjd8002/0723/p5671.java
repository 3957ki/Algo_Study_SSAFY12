package study0725;

import java.io.*;
public class p5671 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String check = "";
	    while((check = br.readLine()) != null) { // 읽어올 내용이 없을 때 까지
	    	String[] str = check.split(" ");
		    int N = Integer.parseInt(str[0]); //N
		    int M = Integer.parseInt(str[1]); //M
		    int cnt =0; // 사용가능한 숫자 개수
		   
		   //자리수를 비교
		   //같은게 있으면 루프 깨기
		    for(int i = N; i<=M;i++){ // N이상 M 이하에 같은숫자가 있는지 확인하는 부분
		    	boolean flag = true; // boolean형태로 트리거 생성
		    	boolean[] chk = new boolean[10]; // 0~9까지 같은게 있는지 체크할 부분
			    String NtoStr = Integer.toString(i);
			   
			    for(int j =0; j<NtoStr.length();j++) {
			    	int tmp = NtoStr.charAt(j)-'0';
				    
			    	if(chk[tmp]) { 		// 이미 tmp자리가 true면(중복이 있다면) 패스
			    		flag = false;	// 중복이므로 트리거 발동
			    		continue;		// 루프 패스
			    	}
				    else chk[tmp] = true; // 아니라면 그자리 true로 변경
			    }
			    if(flag) cnt++; // flag 트리거가 발동한 상태가 아니면(중복X) +1
			    }
		    System.out.println(cnt); // N이 M보다 커지면 루프 나와서 계산
	   }
   }
}
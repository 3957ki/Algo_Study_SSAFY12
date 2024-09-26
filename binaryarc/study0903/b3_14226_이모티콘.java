package study0903;

import java.util.Scanner;

/*
 * 
 * 연산 3가지
 * 1. 이모티콘 모두 복사후 저장
 * 2. 복사한 이모티콘 붙여넣기
 * 3. 이모티콘중 하나 삭제
 * 연산당 1초
 * 복사시 덮어쓰기됨
 * 비어있을땐 붙여넣기 x
 * 붙여넣기시 이모티콘 개수 화면에 추가
 * 이모티콘 S개를 만들기 위해 필요한 시간의 최솟값 구하기
 * 현재 이모티콘 한개를 이미 가짐
 */
public class b3_14226_이모티콘 {
	static int S;
	static int ans;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		ans = 987654321;
		S = sc.nextInt();
		
		copy(1,1,0);
		System.out.println(ans);
		
	}
	static void paste(int cur_time,int cur_output, int cur_save) {
		cur_output += cur_save;
		if(cur_output == S) {
			ans = Math.min(ans, cur_time);
			return;
		}
		if(cur_save==0)return;
		if(cur_output >= 1) {
			copy(cur_time+1,cur_output,cur_save);
			delete(cur_time+1,cur_output,cur_save);
		}
	}
	static void copy(int cur_time,int cur_output, int cur_save) {
		if(cur_output == S) {
			ans = Math.min(ans, cur_time);
			return;
		}
		cur_save = cur_output;
		if(cur_output==0)return;
		if(cur_save >= 1) {
			paste(cur_time+1,cur_output,cur_output);
		}
		if(cur_output >= 1) {
			delete(cur_time+1,cur_output+cur_save,cur_save);
		}
	}
	static void delete(int cur_time,int cur_output, int cur_save) {
		cur_output--;
		if(cur_output == S) {
			ans = Math.min(ans, cur_time);
			return;
		}
		if(cur_output==0)return;
		if(cur_output >= 2){
			delete(cur_time+1,cur_output,cur_save);
		}
		if(cur_output >= 1)copy(cur_time+1,cur_output,cur_save);
		if(cur_save >= 1)paste(cur_time+1,cur_output,cur_save);
		
	}
}

package study0801;

import java.util.ArrayList;
import java.util.Scanner;


//백준 15721 번데기
public class b1_15721 {
	public static boolean chk(int num, int goal, int cnt, int t) {
		return num==goal && cnt == t;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int peoples = sc.nextInt();
		int T = sc.nextInt();
		int goal = sc.nextInt();
		int p_cnt=-1; //현재사람
		int now=0; //현재 뻔, 데기
		int temp_one_cnt=0; //데기 횟수
		int total_zero_cnt=0; //전체 뻔 횟수
		int total_one_cnt=0; //전체 데기 횟수
		int rotaCnt=2; //뻔 뻔 데기 데기
		A: while(true) {
			p_cnt++;
			p_cnt = p_cnt%peoples;
			
			//뻔 - 데기
			if(temp_one_cnt!=2) {
				if(now==0) {
					total_zero_cnt++;
					if(chk(now,goal,total_zero_cnt,T)) {
						break;
					}
					now++;
				}else {
					total_one_cnt++;
					temp_one_cnt++;
					if(chk(now,goal,total_one_cnt,T)) {
						break;
					}
					now--;
				}
			}
			///////////////// 뻔 데기 n번 시작 /////////////
			if(temp_one_cnt==2){ 
				now=0;
				for(int i=0;i<rotaCnt;i++) {
					total_zero_cnt++;
					p_cnt++;
					p_cnt = p_cnt%peoples;
					if(chk(now,goal,total_zero_cnt,T)) {
						break A;
					}
				}
				now=1;
				for(int i=0;i<rotaCnt;i++) {
					total_one_cnt++;
					p_cnt++;
					p_cnt = p_cnt%peoples;
					if(chk(now,goal,total_one_cnt,T)) {
						break A;
					}				
				}
				temp_one_cnt=0;
				now=0;
				rotaCnt++;
			}
		}
		System.out.println(p_cnt);
	}//main

}

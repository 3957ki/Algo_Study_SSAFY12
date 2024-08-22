package study0822;

import java.io.*;
import java.util.*;

public class p1342 {
/*
 * 최대길이 -> 10이니깐 완탐 가능할듯
 * 첫값은 두번째 값이랑 비교하고 두번째값부터 현-1과 현+1비교 끝값은 끝-1과 비교해서 다르면 카운트 올리기
 * (ex)
 * a a a b
 * 처음엔 a와 a가 같은지 보고 같으니 0번자리는 조건만족 X
 * 1번자린 0번과 2번을 비교 후 같으니 조건 만족 X
 * 2번자린 1번과 같으니 만족 X
 * 3번자린 2번과 다르니 만족 -> cnt++
 * ----------------------------------------------------
 * 4번 테케 보니 접근방법 잘못된 것 같음
 * 해당 문자들을 잘 "뽑아서" 나열이니깐 순열로 풀여야함
 * ---dfs---
 * 이전에 만든 값을 파라미터로 받아서 넘겨오면 좀 낫다
 * char형태는 ascii코드를 이용하면 좀 편하다
 * */
	static int cnt, len; // 문자열 개수 , 문자열 길이
//	static boolean[] isVisit; // 방문처리 -> 알파벳으로 확인하면 되니깐 굳이 없어도 됨
	static String str; // 문자열
	static int[] alphabet = new int[27]; // a to z 개수 각각 세기 -> 여기선 이게 방문처리
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		str = br.readLine().trim();
		len = str.length();
		for(int i=0; i<len;i++) {
			alphabet[str.charAt(i)-'a']++; // 각 알파벳에 해당하는 인덱스 추가
		}
		dfs(0,' '); // dfs 호출
		System.out.println(cnt);
	}
	static void dfs(int idx, char temp) { // 문자열 개수랑 지금까지 만든 값 넘기면 편하게 만들 수 있을듯?
		if(idx == len) { // 기저
			cnt++;
			return;
		}
		
		for(int i=0; i<27;i++) {
			if(alphabet[i] == 0) continue; // 일단 없는 알파벳부터 걸러내기
			
			if(temp != (i + 'a')) { // temp가 char잖아? 그러면 i도 char로 맞춰줘야하는데
				alphabet[i]--; // 기존 visited = true처럼
				dfs(idx+1,(char)(i+'a')); // 에러뜨길래 형변환
				alphabet[i]++; // 기존 visited = false처럼 비슷한 역할
			}
		}
	}
}
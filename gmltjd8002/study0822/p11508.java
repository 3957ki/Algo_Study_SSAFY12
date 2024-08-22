package study0822;

import java.io.*;
import java.util.*;

/*
 * btgo
 * 그리디?
 * 비싼것부터 세개 사면 될까?
 * 내림차순으로 정렬하고 세개씩 묶어서
 * 내림차순 어케하지? -> 오름차순하고 인덱스 역순으로 해보자
 * -> int 배열을 Integer로 만들고 comparator.reverseOrder() 씀
 * 아니면 ArrayList로 선언해도 되는데 오버헤드 클 것 같아서 안함
 * ex) n이 3의 배수 -> {1,2,3,4,5,6} i -> mod 0
 * 	   n이 3배수+1 -> {1,2,3,4,5,6,7} i -> mod 1
 * 	   n이 3배수+2 -> {1,2,3,4,5,6,7,8} i -> mod 2 -> 오름차순으로 정렬해서 고려 안함
 * */
public class p11508 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Integer[] map = new Integer[n];
		int sum =0;
		for(int i=0; i<n;i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(map, Comparator.reverseOrder());
		int cnt =0; // 세번째인지 카운트할 변수
		for(int i=0; i<n;i++) {
			cnt++;
			if(cnt==3) {
				cnt=0;
				continue;
			}
			sum += map[i];
		}
		System.out.println(sum);
	}

}

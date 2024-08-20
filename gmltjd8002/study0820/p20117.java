package study0820;
import java.io.*;
import java.util.*;
/*
 * 품질 -> 묶음의 median으로 결정
 * 짝수인 경우 -> (n/2)+1
 * 홀수인 경우 -> (n+1)/2 
 * (ex) 6개라면
 * 1 2 3 4 5 6 -> 6/2+1 = 4번째(4) -> 중앙에서 오른쪽걸로 취급
 * (ex) 5개라면
 * 1 2 3 4 5 -> 5+1/2 = 3번째(3) -> 그냥 가운데거임
 * --------------------------------------------------
 * 1. 부분집합 만들기
 * 2. 그 부분집합에서 중앙값을 이용해 가격 책정하기
 * 3. 기저부분에서 최대값 갱신하고 출력하기...
 * -> 꼬여서 포기
 * 가장 낮은 등급의 소를 가장 비싼 소와 묶으면 비싸진다(짝수개면 오른쪽걸로 취급)
 * a.k.a 가우스 합?
 * 97프로...
 * */ 
public class p20117 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		int n = Integer.parseInt(br.readLine());
		int[] map = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(map);
		if(n%2 == 0) {
			for(int i=n-1; i>=n/2;i--) {
				sum += map[i]*2; // 낮은 소와 높은 소를 묶으면 어차피 등급이 같아진다
			}
		}
		else if(n%2 == 1) {
			for(int i=n-1; i>n/2;i--) {
				sum += map[i]*2; // 여기도 마찬가지로 더해준다
			}
			sum += map[n/2]; // 얘는 혼자 팔아야함
		}
		System.out.println(sum);
	}
}
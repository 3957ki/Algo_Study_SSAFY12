package study0820;
import java.io.*;
import java.util.*;
//부분집합?
//정렬하고 좌표 멘하탄 거리 계산?
//이걸 최소화하는 argmin .... 음
//중앙값 -> 이상치의 영향을 가장 덜 받음 -> 정렬? -> 정렬
//x와 y좌표 각각 중앙값에서 빼준 값을 더해주면 출력 -> 절대값 
//위치가 최대 100만에 사람수가 최대 10만? -> int로 감당안됨 -> long으로
public class p14400 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine().trim());
		int[] posX = new int[n];
		int[] posY = new int[n];
		
		long minX =0;
		long minY =0;
		
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine().trim());
			posX[i] = Integer.parseInt(st.nextToken());
			posY[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(posX);
		Arrays.sort(posY);
		
		int medX = posX[n/2]; // n이 홀수건 짝수건 가운데가 나온다(int 형태로 선언)
		int medY = posY[n/2]; // 중앙값의 x와 y좌표
		
		for(int i=0; i<n;i++) {
			minX += Math.abs(posX[i] - medX);
			minY += Math.abs(posY[i] - medY);
		}
		
		System.out.println(minX + minY);
	}
}
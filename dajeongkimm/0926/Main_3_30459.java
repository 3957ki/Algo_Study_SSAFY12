import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 현수막 걸기
 * 
 * 구매할 수 있는 현수막의 최대 넓이 R
 * 주어진 말뚝과 깃대를 활용해서 현수막을 걸때 -> 현수막 넓이의 최댓값?
 * @author KOREA
 *
 */
public class Main_3_30459 {
	static int N,M,R;
	static int[] point;
	static int[] height;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		point = new int[N]; //말뚝 위치
		height = new int[M]; //현수막 길이
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		
		//말뚝과 말뚝 사이의 거리로 가능한 경우만 set을 통해 확인 후 numList에 담아줌
		//최대 2000*2000 = 4_000_000
		List<Integer> numList = new ArrayList<>();
		for (int i=0;i<N-1;i++) {
			for (int j=i+1;j<N;j++) {
				int num = Math.abs(point[i] - point[j]);
				if (!set.contains(num)) {
					set.add(num);
					numList.add(num);
				} 
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<M;i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		//현수막의 길이가 작은것부터 정렬 --> 삼각형의 높이
		Arrays.sort(height);
		
		//말뚝 사이의 거리가 작은것부터 정렬 --> 삼각형의 밑변
		Collections.sort(numList);
		
		
		double area = -1;
		//가능한 말뚝 사이의 모든 거리에 대해서
		for (int i=0;i<numList.size();i++) {
			//현수막의 길이 이분탐색
			int start = 0;
			int end = M-1;
			int w = numList.get(i);
			
			while (start<=end) {
				int mid = (start+end)/2;
				int h = height[mid];
				
				double tmp_area = w*h*0.5;
				if (tmp_area > R) {
					end = mid-1;
				}
				else {
					area = Math.max(area, tmp_area);
					start = mid+1;
				}
			}
		}
		
		//어떻게 걸어도 현수막을 구매할 수 없는 경우 -1 출력
		if (area == -1) System.out.println(-1);
		else System.out.printf("%.1f\n", area);

	}

}

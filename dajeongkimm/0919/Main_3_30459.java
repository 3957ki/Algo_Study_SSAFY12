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
 * ������ �ɱ�
 * 
 * ������ �� �ִ� �������� �ִ� ���� R
 * �־��� ���Ұ� ��븦 Ȱ���ؼ� �������� �ɶ� -> ������ ������ �ִ�?
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
		
		point = new int[N]; //���� ��ġ
		height = new int[M]; //������ ����
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		
		//���Ұ� ���� ������ �Ÿ��� ������ ��츸 set�� ���� Ȯ�� �� numList�� �����
		//�ִ� 2000*2000 = 4_000_000
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
		//�������� ���̰� �����ͺ��� ���� --> �ﰢ���� ����
		Arrays.sort(height);
		
		//���� ������ �Ÿ��� �����ͺ��� ���� --> �ﰢ���� �غ�
		Collections.sort(numList);
		
		
		double area = -1;
		//������ ���� ������ ��� �Ÿ��� ���ؼ�
		for (int i=0;i<numList.size();i++) {
			//�������� ���� �̺�Ž��
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
		
		//��� �ɾ �������� ������ �� ���� ��� -1 ���
		if (area == -1) System.out.println(-1);
		else System.out.printf("%.1f\n", area);

	}

}

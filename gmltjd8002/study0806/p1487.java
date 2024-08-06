package study0806;

import java.io.*;
import java.util.*;

public class p1487 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() { // �ִ� ��� ������ �������� ����
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = o1[0] - o2[0]; // ���� ���
				if(diff == 0) { // ���̰� ���ٸ�
					diff = o1[1] - o2[1]; // ��� ��� ���� ��������
				}
				return diff;
			}
		});
		
		int curMax =0; // �ִ� ������ �� �ǸŰ�(��°�)
		int maxProfit =0;// �ִ� ����
		for(int i=0; i<n;i++) {
			int sum =0; // ���簡�� �Ǹ����� ���� ���� ����
			for(int j=i;j<n;j++) {
				int diff = arr[i][0] - arr[j][1]; // ���簡 ���� ���� ��� 
				if(diff > 0) {
					sum += diff; // ���ڸ� ����
				}
			}
			if(maxProfit < sum) { // �ִ밻��
				maxProfit = sum;
				curMax = arr[i][0];
			}
		}
		System.out.println(curMax);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * �� �����̵���
 * ���� ������ ���� C�� �� �°� ������ �Ȱ������� ���� ������ �Ǹ��ϴ� �̺�Ʈ
 * ������ �� �ִ� ������ �ִ� 3��, ���� ������ �ߺ� �����ϴ� ���� �Ұ�
 * ��ȭ������ �Ǹ��ϴ� ���ǵ��� ���Դ� ��� �ٸ�
 * 
 * �Ǹ��ϴ� ���� N���� ���� ������ ���԰� �־����� ������ ������ �� �ִ� ������ �ִ���?
 * 
 * @author KOREA
 *
 */
public class Main_3_18114 {
	static int N,C;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		//--------------------------------------------
		
		Arrays.sort(arr);
		
		int answer = 0;
		//������ �Ѱ��� �춧
		if (arr[1] == C || arr[N] == C) {
			System.out.println(1);
			return;
		}
		//������ �ΰ� �̻� �춧
		else {
			int start = 1;
			int end = N;
			while (start<end) {
				//�ΰ��� ���� ����
				int w = arr[start]+arr[end];
				//�ΰ��� ������ �̹� C���� ũ�� 
				if (w > C) end--;
				//�ΰ��� ������ C���� ������
				else if (w < C) {
					if (set.contains(C-w) && (C-w) != arr[start] && (C-w) != arr[end]) {
						answer = 1;
						break;
					}
					else start++;
				//�ΰ��� ������ ���� C�� ������
				}else if (w == C) {
					answer = 1;
					break;
				}
			}
		}
		
		
		System.out.println(answer);
		

	}
	

}

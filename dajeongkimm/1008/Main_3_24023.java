import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �Ʊ� ȫ��
 * 
 * ũ�� N�� �迭 A���� ������ ������ ���
 * ������ ������ ��� bitwiseOR --> ���� ��Ȯ�� K�� �Ǵ� ����?
 * @author KOREA
 *
 */
public class Main_3_24023 {
	static int N,K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = 0;
		int start = -1;
		int end = -1;
		
		//arr[i]�� K�� & ������ arr[i]�� �״�ο�����
		// 001
		// 010
		// 101 
		// --> 111 --> 7 (111)
		
		for (int i=1;i<=N;i++) {
			
			if (arr[i] == K) {
				System.out.println(i+" "+i);
				return;
			}
			
			int n = arr[i]&K;
			if (n == arr[i]) {
				if (num == 0) {
					start = i;
				} else end = i;
				
				num |= arr[i];
				if (num == K) {
					System.out.println(start+" "+end);
					return;
				}
			} 
			else {
				num = 0;
			}
		}
		System.out.println(-1);

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� ����
 * N���� ����
 * �ٸ� ������ ������ ���� �ٸ�
 * 
 * ������ ���ӵ� 3���� ������ ���� ��� �ٸ���
 * 
 * �ټ��̰� ����̸� ���� �� �ִ� ����� ����� ��
 * @author KOREA
 *
 */
public class Main_4_1301 {
	static int N; //������ ���� (3<=N<=5)
	static int[] arr; //������ ������ ��ִ��� (<=10) 
	
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		int total = 0;
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		dp = new int[total+1][N+1]; //���� N������ �������� �� total���� ~
		for (int i=1;i<=N;i++) {
			dp[1][i] = 1;
		}
		
		

	}

}

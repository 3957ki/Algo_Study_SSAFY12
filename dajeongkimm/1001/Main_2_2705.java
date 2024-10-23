import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �Ӹ���� ��Ƽ��
 * 
 * �������� N�� ��Ƽ�� : ���� N�� �Ǵ� ����
 * 
 * � ��Ƽ���� �տ��� ���� ���� �ڿ��� ���� ���� ������ --> �Ӹ���� ��Ƽ��
 * 
 * ������� �Ӹ���� ��Ƽ��
 * : �Ӹ�����̸鼭 ���� ���ݰ� ������ ������ ������� �Ӹ���� or ������� ��
 * 
 * � �� N --> ������� �Ӹ���� ��Ƽ���� ���� ���
 * @author KOREA
 *
 */
public class Main_2_2705 {
	static int[] count = new int[1001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		count[1] = 1; //1
		count[2] = 2; //1+1, 2
		count[3] = 2; //1+1+1, 3
		count[4] = 4; 
		//count[2] : (1+1+1+1, 2+2)
		//count[1] : (1+2+1)
		//4
		
		for (int i=5;i<=1000;i++) {
			//��� ���� j
			for (int j=0;j<=i-2;j++) {
				if ((i-j)%2 == 0) {
					count[i] += count[(i-j)/2];
				}
			}
			count[i]++; //i = i �϶� 
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(count[N]);
			
			
		}
	}

}

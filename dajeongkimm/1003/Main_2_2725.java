import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ���̴� ���� ����
 * 
 * (0,0)���� ���̴� (x,y)�� ����
 * (0,0)�� (x,y)�� �����ϴ� ������ �ٸ� ���� ������� X
 * @author KOREA
 *
 */
public class Main_2_2725 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] count = new int[1001];
		count[0] = 0;
		count[1] = 3;
		count[2] = 5;
		for (int i=3;i<=1000;i++) {
			int add = 0;
			for (int j=2;j<i;j++) {
				if (gcd(i,j) == 1) add++;
			}
			count[i] = count[i-1] + 2 + add*2;
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(count[N]);
		}
	}
	
	static int gcd(int a, int b) {
		while (b>0) {
			int tmp = a%b;
			a = b;
			b = tmp;
		}
		return a;
	}

}

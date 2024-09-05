import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ������ �̴ټ�
 * 
 * �ȷ��� �ϴ� ������ ���̸� ���� ���� (�ڿ�����)
 * 
 * �ѹ� �ڸ� ���� C���� ���
 * ������ �� ���� �� ������ W���� �ش�.
 * K���� ���� ���� L --> K*L*W
 * 
 * ���� ������ �ִ� ������ ���̰� �־����� �� �� �� �ִ� ���� ū ��
 * @author KOREA
 *
 */
public class Main_2_1421 {
	static int N,C,W;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		long answer = 0;
		int max = 0;
		tree = new int[N];
		for (int i=0;i<N;i++) {
			tree[i]= Integer.parseInt(br.readLine());
			max = Math.max(max,  tree[i]);
			
		}
		
		int start = 1;
		while (start<=max) {
			long tmp = 0;
			for (int t : tree) {
				if (start>t) {
//					tmp += W*t;
				}
				//������ �������� --> �ѹ� ���߶� �� (4���� 3�� �ڸ���)
				else if (t%start == 0) {
					long cost = ((t/start)*start*W - (t/start-1)*C);
					if (cost>0) {
						tmp += cost;
					}
					
				}
				else if (t%start != 0){
					long cost = ((t/start)*W*start - (t/start)*C);
					if (cost>0) {
						tmp += cost;
					}
				}
			}
//			System.out.println(tmp);
			answer = Math.max(answer, tmp);
			start++;
		}
		
		System.out.println(answer);
		

	}

}

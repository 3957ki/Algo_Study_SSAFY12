import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * �����̴� �Ź� ���ϸ� ��ٸ�
 * 
 * 1. �������� �����ġ ������ ��� ��ġ X
 * 2. �����̰� �ɸ��� �ִ� �ð� + ������ �ִܽð� => �ּ�
 * 3. ���϶� �����̰� ���ų� ���ϰ� �� �۵���
 * 4. �� �߿� �����̷κ��� ���� ����� �� (�� �� ���� ��ȣ�� ���� ��)
 * 
 * @author KOREA
 *
 */
public class Main_4_17270 {
	static int V,M;
	static int[][] weight;
	static int J,S;
	
	static int answer = -1;
	static int fromJ = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		weight = new int[V+1][V+1];
		for (int i=1;i<=V;i++) {
			Arrays.fill(weight[i], 100_000_000);
		}
		for (int i=1;i<=V;i++) {
			weight[i][i] = 0; //�ڱ��ڽſ��� ���� ���� ����ġ 0
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//���� �濡 ����ġ�� �ٸ� ��� ���
			if (weight[a][b] > c) {
				weight[a][b] = c;
				weight[b][a] = c;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		J = Integer.parseInt(st.nextToken()); //���� ����
		S = Integer.parseInt(st.nextToken()); //���� ����
		
		//�÷��̵�ͼ� --> A���� B������ �ִ� ��� ����
		for (int k=1;k<=V;k++) {
			for (int i=1;i<=V;i++) {
				for (int j=1;j<=V;j++) {
					if (weight[i][k] + weight[k][j] < weight[i][j]) {
						weight[i][j] = weight[i][k] + weight[k][j];
					}
				}
			}
		}
		
		int minDistance = Integer.MAX_VALUE / 2;
		for (int i=1;i<=V;i++) {
			if (i == J || i == S) continue;
			minDistance = Math.min(minDistance, weight[J][i]+weight[S][i]);
		}
		
		//�Ÿ��� �� �ִܰŸ�
		for (int i=1;i<=V;i++) {
//			System.out.println(i+": "+(weight[J][i]+weight[S][i]));
			if (i == J || i == S) continue; //�������� ����
			
			//�����̰� ���Ϻ��� �� ������ �ȵ�
			if (weight[J][i] > weight[S][i]) continue;
			
			// ���� ������ Ž���ϱ� ������ --> ���ٸ� ���� ��ȣ ����
			if (weight[J][i] + weight[S][i] == minDistance) {
				if (fromJ > weight[J][i]) {
					fromJ = weight[J][i];
					answer = i;
				}
				
			} 
		}
		System.out.println(answer);
		
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��ٸ�
 * �ð� 0�� �ʱ���¿��� ����ؼ� ö���� ���� �Ʒ����� ����⿡��
 * ���� ������ ������ �ö󰡴µ� �ɸ��� �ּ� �ð� ���ϱ�
 * 0�� ���ʿ��� ������, 1�� �����ʿ��� ����
 * @author KOREA
 *
 */
public class Main_4_2528 {
	static int N,L;
	static Node[] building;
	
	static int cur_floor;
	
	static class Node {
		int start;
		int end;
		int dir; //0�̸� ��->�� 1�̸� ��->��
		
		Node(int start, int end, int dir){
			this.start = start;
			this.end = end;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //�� ��
		L = Integer.parseInt(st.nextToken()); //���� ����
		
		building = new Node[N+1];
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (num == 0) {
				building[i] = new Node(0,l,num);
				
			}
			else {
				building[i] = new Node(L-l, L, num);
				
			}
		}
		
		int time = 0;
		cur_floor = 1;
		while (true) {
			up(); //���� �ö󰡱� (������ �ִ��� ����?)
//			System.out.println("time: "+time+" cur_floor: "+cur_floor);
			if (cur_floor == N) break; //���� ����⿡ �����ϸ�
			
			move(); //����� �̵�
			time++;
		}
		System.out.println(time);
	}
	private static void up() {
		while (true) {
			if (cur_floor == N) break;
			
			int start = building[cur_floor].start;
			int end = building[cur_floor].end;
			
			int up_start = building[cur_floor+1].start;
			int up_end = building[cur_floor+1].end;
			
			boolean flag = false;
			
			for (int i=end;i>=start;i--) {
				if (i>=up_start && i<=up_end) {
					cur_floor++;
					flag = true;
					break;
				}
			}
			
			if (!flag) break;
		}
	}
	private static void move() {
		for (int i=1;i<=N;i++) {
			Node cur = building[i];
			
			//�������� �̵�
			if (cur.dir == 1) {
				if (cur.start != 0) {
					cur.start--;
					cur.end--;
				}
				//�������� �̵� �Ұ�
				else {
					cur.start++;
					cur.end++;
					cur.dir = 0; //��->�� �������� ����
				}
			}
			//���������� �̵�
			else {
				if (cur.end != L) {
					cur.start++;
					cur.end++;
				}
				//���������� �̵� �Ұ�
				else {
					cur.start--;
					cur.end--;
					cur.dir = 1; //��->�� �������� ����
				}
				
			}
		}
	}

}

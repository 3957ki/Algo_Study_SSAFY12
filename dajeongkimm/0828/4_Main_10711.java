import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * �𷡼�
 * ưư�� : 1~9
 * �ڱ� ���� �ֺ��� 8����(�� �Ʒ� �� �� �밢��)
 * --> �𷡼��� �׿����� ���� �κ��� ������ �ڱ� �𷡼��� ưư�Ժ���
 * ���ų� ���� ��� �ĵ��� ���ؼ� ������ �� ������ �ǹ�
 * 
 * �𷡼��� ������ ���, �� ���ڴ� �𷡼��� �׿����� ���� ������ ���
 * 
 * �𷡼��� �� �̻� ����� ������ �ʰ� �Ƿ��� �ĵ��� ��� �ľ��ϴ���?
 * @author KOREA
 *
 */
public class Main_10711 {
	static int H,W;
	static int[][] arr;
	
	static int answer;
	
	//8���� delta
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		arr = new int[H][W];
		answer = 0;
		
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		for (int i=0;i<H;i++) {
			String input = br.readLine();
			for (int j=0;j<W;j++) {
				char tmp = input.charAt(j);
				if (tmp == '.') {
					//�𷡼��� ������ ť�� �ֱ�
					queue.add(new int[] {i,j});
				}
				else {
					arr[i][j] = tmp-'0';
				}
			}
		}

		
		//�ĵ��� ĥ������ �𷡼��� ������ -1 --> �𷡼��� 0�̵Ǹ� �𷡰� �ǰ� queue�� �ֱ�
		while (!queue.isEmpty()) {
			int queue_size = queue.size();
//			System.out.println(queue_size);
			
			for (int q=0;q<queue_size;q++) {
				int[] cur = queue.poll();
				int cur_x = cur[0];
				int cur_y = cur[1];
				
				//8���� Ž��
				for (int i=0;i<8;i++) {
					int nx = cur_x+dx[i];
					int ny = cur_y+dy[i];
					if (nx>=0 && nx<H && ny>=0 && ny<W) {
						//�ĵ��� �𷡼��� ������
						if (arr[nx][ny] > 0) {
							arr[nx][ny]--;
							if (arr[nx][ny] == 0) {
								//���Ӱ� �𷡰� �Ǵ� �κ� ť�� �߰�
								queue.add(new int[] {nx,ny});
//								System.out.println("added: "+nx+" "+ny);
							}
						}
					}
				}
			}
//			System.out.println();
			answer++;
		}
		System.out.println(answer-1);

	}
	
	//������ ���� 0�̸� ������ ���� ���� ,,
//	public static int bfs() {
//		ArrayDeque<int[]> queue = new ArrayDeque<>();
//		queue.add(new int[] {0,0});
//		boolean[][] visited = new boolean[H][W];
//		visited[0][0] = true;
//		
//		int remove_cnt = 0;
//		ArrayList<int[]> remove = new ArrayList<>();
//		
//		while (!queue.isEmpty()) {
//			int cur[] = queue.poll();
//			int cur_x = cur[0];
//			int cur_y = cur[1];
//			
//			for (int i=0;i<4;i++) {
//				int nx = cur_x+dx[i];
//				int ny = cur_y+dy[i];
//				
//				if (nx>=0 && nx<H && ny>=0 && ny<W && !visited[nx][ny]) {
//					//�𷡼��̸�
//					if (arr[nx][ny]>=1) {
//						int cnt = count(nx,ny);
//						//ưư���� ������
//						if (cnt>=arr[nx][ny]) {
//							visited[nx][ny] = true;
////							arr[nx][ny] = -1;
//							remove.add(new int[] {nx,ny});
//							remove_cnt++;
//						}
//						//ưư�ϸ�
//						else {
//							visited[nx][ny] = true;
//							queue.add(new int[] {nx,ny});
//						}
//					}
//					//�𷡼��� ������
//					else {
//						visited[nx][ny] = true;
//						queue.add(new int[] {nx,ny});
//					}
//				}
//			}
//			
//		}
//		
//		for (int[] xy : remove) {
//			arr[xy[0]][xy[1]] = -1;
//		}
//		
//		return remove_cnt;
//	}
//	
//	//8���⿡ ���� �κ� ���� ����
//	public static int count(int x, int y) {
//		int cnt = 0;
//		for (int dx=-1;dx<=1;dx++) {
//			for (int dy=-1;dy<=1;dy++) {
//				if (arr[x+dx][y+dy] == -1) cnt++;
//			}
//		}
//		return cnt;
//	}
//	
//	public static void printArr(int[][] arr) {
//		for (int i=0;i<H;i++) {
//			for (int j=0;j<W;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}

}

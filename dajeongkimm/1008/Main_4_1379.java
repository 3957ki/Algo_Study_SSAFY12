import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * ���ǽ�2
 * N���� ����
 * �����ϴ� �ð��� ������ �ð�
 * �ִ��� ���� ���� ���ǽ� ����Ͽ� ��� ���ǰ� �̷��������
 * 
 * �� ���Ǹ��� ���ǽ� ����
 * @author KOREA
 *
 */
public class Main_4_1379 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Room> roomPQ = new PriorityQueue<>();
	static PriorityQueue<Lecture> lecturePQ = new PriorityQueue<>();
	
	static int[] answer; 
	
	//���۽ð� ���� ��������
	static class Lecture implements Comparable<Lecture>{
		int num, start,end;
		Lecture(int num, int start, int end){
			this.num = num;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Lecture o) {
			return Integer.compare(start, o.start);
		}
	}
	
	//������ �ð� ���� ��������
	static class Room implements Comparable<Room>{
		int roomNum;
		int endTime;
		
		Room(int roomNum, int endTime){
			this.roomNum = roomNum;
			this.endTime = endTime;
		}
		
		@Override 
		public int compareTo(Room o) {
			return Integer.compare(endTime, o.endTime);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			lecturePQ.add(new Lecture(num, start, end));
		}
		
		//�� ���ǿ� � ���ǽ��� ������� ����
		answer = new int[N+1];
		
		//ù��° ���ǽǿ� ù��° ���� �־��ֱ�
		int K = 1;
		Lecture lecture = lecturePQ.poll();
		answer[lecture.num] = K;
		roomPQ.add(new Room(K, lecture.end));
		
		
		while (!lecturePQ.isEmpty()) {
			Lecture cur = lecturePQ.poll();
			
			//���� ���� ������ ���ǽǿ� ���� ���Ǹ� ���� �� ������?
			if (cur.start >= roomPQ.peek().endTime) {
				Room r = roomPQ.poll();
				answer[cur.num] = r.roomNum;
				roomPQ.add(new Room(r.roomNum, cur.end));
			}
			//���ο� ���ǽ� �߰�
			else {
				K++;
				answer[cur.num] = K;
				roomPQ.add(new Room(K, cur.end));
			}
			
		}
		sb.append(K).append("\n");
		for (int i=1;i<=N;i++) {
			sb.append(answer[i]+"\n");
		}
		
		System.out.println(sb);
	}

}

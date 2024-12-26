import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3_2170 {
	static class Line implements Comparable<Line>{
		int start;
		int end;
		
		Line(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Line o) {
			return Integer.compare(start, o.start);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Line> list = new ArrayList<>();
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Line(start,end));
		}
		
		Collections.sort(list);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int answer = 0;
		for (int i=0;i<N;i++) {
			Line cur = list.get(i);
			
			//���� �߱�
			if (cur.start >= max) {
				answer += (cur.end - cur.start);
				min = cur.start;
				max = cur.end;
			}
			
			//�߰��� ���������� �ʰ� �߱�
			else if (min <= cur.start && max >= cur.end) {
				
			}
			//�߰��� ���������� �߱�
			else {
				answer += (cur.end - max);
				max = cur.end;
			}
		}
		System.out.println(answer);
	}

}

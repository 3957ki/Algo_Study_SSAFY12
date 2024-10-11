import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_B_14226 {
    static int S;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;

    static void BFS() {
    	Queue<Node> queue = new ArrayDeque<Node>();
    	queue.add(new Node(1, 0, 0));
 
    	while(true) {
    		Node curr = queue.poll();
    	   	visited[curr.display][curr.clip] = true;
    	   	
    		if(curr.display == S) {
    			min = Math.min(min, curr.count);
    			//System.out.println(curr);
    			return;
    		}
    		
    		// 붙여넣기
    		if(curr.display < S && curr.clip != 0 && !visited[curr.display + curr.clip][curr.clip]) {
    			queue.add(new Node(curr.display + curr.clip, curr.clip, curr.count + 1));
    		}
    		
    		// 복사
    		if(curr.display < S && !visited[curr.display][curr.display]) {
    			queue.add(new Node(curr.display, curr.display, curr.count + 1));
    		}
    		
    		// 삭제
    		if(curr.display != 0 && !visited[curr.display - 1][curr.clip]) {
    			queue.add(new Node(curr.display - 1, curr.clip, curr.count + 1));
    		}
    	}
    	
    	
    }

    static class Node {
    	int display;
    	int clip;
    	int count;
		public Node(int display, int clip, int count) {
			this.display = display;
			this.clip = clip;
			this.count = count;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "d:" + display + " cp:" + clip + " c:" + count;
		}
    }

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("res/b_14226.txt"));
        Scanner sc = new Scanner(System.in);

        S = sc.nextInt();

        visited = new boolean[2001][1001];
        BFS();
        
        System.out.println(min);
    }
}
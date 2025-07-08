import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4_16985 {
	static List<Integer> seq = new ArrayList<>(5);
	static List<Integer> rotate = new ArrayList<>(4);
	static int[][][] arr;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[7][7][7];
		for(int p = 1; p <= 5; p++) {
			for(int i = 1; i <= 5; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= 5; j++) {
					arr[p][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		DFS_seq(1);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	static void DFS_seq(int depth) {
		if(depth > 5) {
			DFS_rotate(1);
			return;
		}
		for(int i = 1; i <= 5; i++) {
			if(seq.contains(i)) continue;
			seq.add(i);
			DFS_seq(depth+1);
			seq.remove(depth-1);
		}
	}
	
	static void DFS_rotate(int depth) {
		if(depth > 4) {
			make();
			return;
		}
		for(int i = 0; i <= 3; i++) {
			rotate.add(i);
			DFS_rotate(depth+1);
			rotate.remove(depth-1);
		}
	}
	
	static void make() {
		int[][][] cube = new int[7][7][7];
		cube[1] = arr[seq.get(0)];
		for(int i = 2; i <= 5; i++) {
			cube[i] = rotate(arr[seq.get(i-1)], rotate.get(i-2));
		}
		Queue<Node> queue = new LinkedList<>();
		int[] dx = {-1, 1, 0, 0, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};
		
		if(cube[1][1][1] == 1) {
			boolean[][][] visited = new boolean[7][7][7];
			int[][][] distance = new int[7][7][7];
			queue.add(new Node(1, 1, 1));
			visited[1][1][1] = true;
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				int x = node.x;
				int y = node.y;
				int z = node.z;
				for(int d = 0; d < 6; d++) {
					int X = x+dx[d];
					int Y = y+dy[d];
					int Z = z+dz[d];
					if(!visited[Z][Y][X] && cube[Z][Y][X] == 1) {
						distance[Z][Y][X] = distance[z][y][x] + 1;
						if(Z == 5 && Y == 5 && X == 5) {
							queue.clear();
							answer = Math.min(answer, distance[5][5][5]);
							break;
						}
						queue.add(new Node(Z, Y, X));
						visited[Z][Y][X] = true;
					}
				}
			}
			
		}
		if(cube[1][1][5] == 1) {
			boolean[][][] visited = new boolean[7][7][7];
			int[][][] distance = new int[7][7][7];
			queue.add(new Node(1, 1, 5));
			visited[1][1][5] = true;
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				int x = node.x;
				int y = node.y;
				int z = node.z;
				for(int d = 0; d < 6; d++) {
					int X = x+dx[d];
					int Y = y+dy[d];
					int Z = z+dz[d];
					if(!visited[Z][Y][X] && cube[Z][Y][X] == 1) {
						distance[Z][Y][X] = distance[z][y][x] + 1;
						if(Z == 5 && Y == 5 && X == 1) {
							queue.clear();
							answer = Math.min(answer, distance[5][5][1]);
							break;
						}
						queue.add(new Node(Z, Y, X));
						visited[Z][Y][X] = true;
					}
				}
			}
		}
		
		if(cube[1][5][1] == 1) {
			boolean[][][] visited = new boolean[7][7][7];
			int[][][] distance = new int[7][7][7];
			queue.add(new Node(1, 5, 1));
			visited[1][5][1] = true;
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				int x = node.x;
				int y = node.y;
				int z = node.z;
				for(int d = 0; d < 6; d++) {
					int X = x+dx[d];
					int Y = y+dy[d];
					int Z = z+dz[d];
					if(!visited[Z][Y][X] && cube[Z][Y][X] == 1) {
						distance[Z][Y][X] = distance[z][y][x] + 1;
						if(Z == 5 && Y == 1 && X == 5) {
							queue.clear();
							answer = Math.min(answer, distance[5][1][5]);
							break;
						}
						queue.add(new Node(Z, Y, X));
						visited[Z][Y][X] = true;
					}
				}
			}
		}
		
		if(cube[1][5][5] == 1) {
			boolean[][][] visited = new boolean[7][7][7];
			int[][][] distance = new int[7][7][7];
			queue.add(new Node(1, 5, 5));
			visited[1][5][5] = true;
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				int x = node.x;
				int y = node.y;
				int z = node.z;
				for(int d = 0; d < 6; d++) {
					int X = x+dx[d];
					int Y = y+dy[d];
					int Z = z+dz[d];
					if(!visited[Z][Y][X] && cube[Z][Y][X] == 1) {
						distance[Z][Y][X] = distance[z][y][x] + 1;
						if(Z == 5 && Y == 1 && X == 1) {
							queue.clear();
							answer = Math.min(answer, distance[5][1][1]);
							break;
						}
						queue.add(new Node(Z, Y, X));
						visited[Z][Y][X] = true;
					}
				}
			}
		}
	}
	
	static int[][] rotate(int[][] plate, int n){
		int[][] temp = new int[7][7];
		if(n == 1) {
			for(int i = 1; i <= 5; i++) {
				for(int j = 1; j <= 5; j++) {
					temp[i][j] = plate[j][6-i];
				}
			}
		}
		else if(n == 2) {
			for(int i = 1; i <= 5; i++) {
				for(int j = 1; j <= 5; j++) {
					temp[i][j] = plate[6-i][6-j];
				}
			}
		}
		else if(n == 3) {
			for(int i = 1; i <= 5; i++) {
				for(int j = 1; j <= 5; j++) {
					temp[i][j] = plate[6-j][i];
				}
			}
		}
		else {
			for(int i = 1; i <= 5; i++) {
				for(int j = 1; j <= 5; j++) {
					temp[i][j] = plate[i][j];
				}
			}
		}
		
		return temp;
	}
	
	static class Node{
		int z, y, x;
		Node(int z, int y, int x){
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
}

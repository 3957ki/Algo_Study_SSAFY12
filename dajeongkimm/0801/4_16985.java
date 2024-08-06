package cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] input = new int[5][5][5];
	static int[][][] copy = new int[5][5][5];
	static boolean check[];
	static int[] dir;
	static int[] order;
	static boolean[][][] visited;
	static int answer = Integer.MAX_VALUE;
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	
	static class Node {
		int x,y,z, cnt;
		public Node (int x, int y, int z , int cnt) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i=0;i<5;i++) {
			for (int j=0;j<5;j++) {
				st = new StringTokenizer(br.readLine());
				for (int k=0;k<5;k++) {
					input[i][j][k] = Integer.parseInt(st.nextToken());				
					}
			}
		}
		dir = new int[5];
		order = new int[5];
		check = new boolean[5];
		permutation(0);
		System.out.println((answer==Integer.MAX_VALUE) ? -1 : answer);
		

	}
	
	//순열
	private static void permutation(int idx) {
		if (idx == 5) {
			copy = new int[5][5][5];
			for (int i=0;i<order.length;i++) {
				rotation(0);
			}
			return;
		}
		for (int i=0;i<5;i++) {
			if (!check[i]) {
				check[i] = true;
				order[idx] = i;
				permutation(idx+1);
				check[i] = false;
			}
		}
	}
	
	//중복 순열
	private static void rotation(int idx) {
		if (idx == 5) {
			for (int o=0;o<order.length;o++) {
				int pan = order[o];
				int d = dir[pan];
				for (int i=0;i<5;i++) {
					for (int j=0;j<5;j++) {
						if (d == 0) {
							copy[o][i][j] = input[pan][i][j];
						}
						if (d == 1) {
							copy[o][j][4-i] = input[pan][i][j];
						}
						if (d == 2) {
							copy[o][4-i][4-j] = input[pan][i][j];
						}
						if (d == 3) {
							copy[o][4-j][i] = input[pan][i][j];
						}
					}
				}
			}
			
			if (copy[0][0][0] == 1 && copy[4][4][4] == 1) {
				bfs();
			}
			return;
		}
		for (int d=0;d<4;d++) {
			dir[idx] = d;
			rotation(idx+1);
		}
	}
	
	//최단 길이
	private static void bfs() {
		Queue<Node> queue = new LinkedList<Node>();
		visited = new boolean[5][5][5];
		queue.add(new Node(0,0,0,0));
		visited[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (node.x == 4 && node.y==4 && node.z==4) {
				answer = Math.min(answer,  node.cnt);
//				if (answer==12) {
//					System.out.println(12);
//					System.exit(0);
//				}
				return;
			}
			
			for (int i=0;i<6;i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				int nz = node.z + dz[i];
				
				if (nx>=0 && nx<5 && ny>=0 && ny<5 && nz>=0 && nz<5) {
					if (!visited[nx][ny][nz] && copy[nx][ny][nz] == 1) {
						visited[nx][ny][nz] = true;
						queue.add(new Node(nx,ny,nz,node.cnt+1));
					}
					
				}
			}
		}
	}
	

}

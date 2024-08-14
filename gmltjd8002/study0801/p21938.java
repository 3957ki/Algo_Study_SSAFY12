package study0801;

import java.io.*;
import java.util.*;

public class p21938 {
	static int[][] map;
	static boolean[][] isVisit;
	static int n,m,t;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt =0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		isVisit = new boolean[n][m];
		
		for(int i=0; i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m;j++) { // 3���� ���� ����� �迭�� ���� 
				int r = Integer.parseInt(st.nextToken()); 
				int g = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[i][j] = (r+g+b) / 3;
			}
		}
		t = Integer.parseInt(br.readLine());
		for(int i=0; i<n;i++) {
			for(int j=0; j<m;j++) {
				map[i][j] = (map[i][j] >= t) ? 255 : 0; // ��谪���� ũ�� 255 �ƴ� 0
			}
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<m;j++) {
				if(map[i][j] == 255 && !isVisit[i][j]) { // 255�� �湮�� ���� ������
					dfs(i,j); 	// �� ��ġ���� dfs
					cnt++; // ��ü ���� +1
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int x, int y) {
		isVisit[x][y] = true;
		
		for(int i=0; i<4;i++) { // ��Ÿ�� �̿��� ��� Ž��
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx < n && ny >= 0 && ny < m // ��� üũ
					&& map[nx][ny] != 0 && !isVisit[nx][ny]) { // ���� ���� 0�� �ƴϰ� �湮�� ���� ���ٸ�
				dfs(nx,ny); // �� ��ġ���� �ٽ� dfs
			}
		}
	}
}
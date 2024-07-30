package study0730;
//백준 17141
//연구소

//바이러스 M개를 놓을 곳 배열로 구해두기
//바이러스 위치 배열 순회하며 bfs
//bfs 끝날때마다 시간 최대값으로
import java.io.*;
import java.util.*;
public class b3_17141 {
	public static class position{
		int x;
		int y;
		public position(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<ArrayList<position>> virusPostionArr;
	static ArrayList<position> tempPostion;
	static int[][] map;
	static int N,M;
	
	
	public static void savePosition(int idx,ArrayList<position> temp) {
		
		if(temp.size() == M) {
			virusPostionArr.add(new ArrayList<position>(temp));
			return;
		}
		for(int i = idx ; i < tempPostion.size() ; i++) {
			temp.add(tempPostion.get(i));
			savePosition(i+1,temp);
			temp.remove(temp.size()-1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 연구소의 크기 N
		M = Integer.parseInt(st.nextToken()); //바이러스 개수
		virusPostionArr = new ArrayList<ArrayList<position>>();
		tempPostion = new ArrayList<position>();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)tempPostion.add(new position(i, j));
			}
		}
		
		savePosition(0, new ArrayList<position>());
	}
}

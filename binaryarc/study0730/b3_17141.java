package study0730;
//백준 17141
//연구소 2

//바이러스 M개를 놓을 곳 배열로 구해두기
//바이러스 위치 배열 순회하며 bfs
//bfs 끝날때마다 시간 최소값으로 업데이트
import java.io.*;
import java.util.*;
public class b3_17141 {
	public static class Position{
		int x;
		int y;
		public Position(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<ArrayList<Position>> virusPositionArr;
	static ArrayList<Position> tempPosition;
	static int[][] map;
	static int N,M;
	static final int[] dx = {-1,1,0,0};
	static final int[] dy = {0,0,-1,1};
	static int emptyCnt;
	
	public static void savePosition(int idx,ArrayList<Position> temp) {
		if(temp.size() == M) {
			virusPositionArr.add(new ArrayList<>(temp));
			return;
		}
		for(int i = idx ; i < tempPosition.size() ; i++) {
			temp.add(tempPosition.get(i));
			savePosition( i + 1,temp);
			temp.remove(temp.size()-1);
		}
	}
	
	public static int bfs(ArrayList<Position> list) {
		Queue<Position> queue = new LinkedList<>();
		//boolean[][] visited = new boolean[N][N];
		int[][] time = new int[N][N];
		for(int i = 0;i < N;i++) for(int j = 0;j < N;j++) time[i][j] = -1;
		int maxTime = 0;
		int infectedCnt=0;
		
		
		for(Position p : list) {
			queue.add(p);
			time[p.x][p.y] = 0;
			infectedCnt++;
		}
		
		while(!queue.isEmpty()) {
			Position p = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx >=0 && nx < N && ny >= 0 && ny < N 
						&& time[nx][ny] == -1 && map[nx][ny] != 1) {
					time[nx][ny] = time[p.x][p.y] + 1;
					maxTime = Math.max(maxTime, time[nx][ny]);
					queue.add(new Position(nx, ny));
					if(map[nx][ny] == 0 || map[nx][ny] == 2)infectedCnt++;
				}
			}
		}
		
		
		
		
		//모든곳 감염 됐는지 확인
		return (infectedCnt == emptyCnt) ? maxTime : Integer.MAX_VALUE;
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 연구소의 크기 N
		M = Integer.parseInt(st.nextToken()); //바이러스 개수
		
		virusPositionArr = new ArrayList<ArrayList<Position>>();
		tempPosition = new ArrayList<Position>();
		map = new int[N][N];
		emptyCnt=0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0 || map[i][j] == 2)emptyCnt++;
				if(map[i][j] == 2)tempPosition.add(new Position(i, j));
			}
		}
		
		savePosition(0, new ArrayList<Position>());
		
		int minTime = Integer.MAX_VALUE;
		for(ArrayList<Position> virusList : virusPositionArr) {
			int time = bfs(virusList);
			minTime = Math.min(minTime,time);
		}
		
		System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
		br.close();
		return ;
	}
}

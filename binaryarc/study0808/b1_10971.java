package study0808;
import java.io.*;
import java.util.*;
public class b1_10971 {
	static int cityCnt;
	static int[][] map;
	static int result=987654321;
	static boolean visited[];
	static int firstCity;
	public static void dfs(int cost,int startCity) {
		
		//전체 방문여부 체크
		for(int i=0;i<cityCnt;i++) {
			if(!visited[i])break;
			//전체 방문했을때 다시 첫째 도시로 갈 수 있다면 결과값 갱신
			if(i==cityCnt-1 && map[startCity][firstCity]!=0) {
				result = Math.min(result, cost+map[startCity][firstCity]);	
			}
		}
		
		for(int cityB=0;cityB<cityCnt ; cityB++) {
			//다음도시가 방문안했고 갈 수 있는곳이면 방문
			if(!visited[cityB] && map[startCity][cityB]!=0) {
				visited[cityB]=true;
				dfs(cost+map[startCity][cityB],cityB);
				visited[cityB]=false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		cityCnt = Integer.parseInt(st.nextToken());
		map = new int[cityCnt][cityCnt];
		visited = new boolean[cityCnt];
		for(int i=0;i<cityCnt;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<cityCnt;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<cityCnt;i++) {
			visited = new boolean[cityCnt];
			firstCity = i;
			visited[i] = true;
			dfs(0,i);
		}
		
		System.out.println(result);
		
	}

}

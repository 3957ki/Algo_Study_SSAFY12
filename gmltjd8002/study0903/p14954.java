import java.io.*;
import java.util.*;
/*
1~N번까지 N개의 방이 있음
x<a<y인 모든 a의 벽을 허물어버린다
이미 무너진방이라면 무시한다
1,N번방은 항상 고정
허물어져 합쳐지고 남은 방의 개수 구하기
M : 벽을 허무는 횟수
N : 동방 개수
1 2 3 4 5
-> 1 1 3 4 5
-> 1 1 1 1 5

-아이디어
유니온 파인드?
서로소였던 집합들이 초기에는 자기자신을 가리킴
이게 벽을 허물면서 같은방이 됨 -> 루트가 같아지는 방법으로 해석이 가능할 것 같다.
유니온 파인드 필요했던 요소
find -> 루트노드를 가리키면 그 값을 반환하고 아니라면 경로압축을 통해 재귀를 호출해 루트를 반환한다
union -> 각 두 값의 루트를 받아서 이 루트가 같으면 이미 같은 노드이고, 아니라면 합치고 헤드부분을 바꿔줬다.
여기선 헤드를 결합한 방으로 보는게 나을 듯 하다
 */
public class p14954 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 방 수
		int m = Integer.parseInt(br.readLine()); // 뿌시는 횟수
		int[] map = new int[n+1]; // 방 리스트
		for(int i=1;i<=n;i++) { // 루트가 자기 자신을 가리키게함
			map[i] = i;
		}
		
		for(int i=0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int cur = 0;
			for(int j = first; j<=second;j++) { // 방을 부신다 -> 결합한다
				//여기가 부서진 방의 시작점이 아니라면
				if(map[j] != j) { // 이게 다르다는건 서로소 집합이 아니다 -> 이미 union이 한번 진행되었다.(방이 무너졌던 이력이 있다.)
					cur = map[j];
				}
				if(cur != 0) { // cur이 0이 아니라는 건 위에서 갱신했던 적이 있다.(방이 무너진 적이 있다.)
					map[j] = cur; // 그 값을 가리키게 한다
				}else { // 아니라면
					map[j] = first; // 그방이 시작부분이다
				}
			}
		}
		int cnt = 0;
		
		for(int i=1; i<=n;i++) { // 모든 배열을 순회하면서 방이 합쳐진 개수가 있는지 본다
			if(map[i] == i) cnt++; // 이 위치가 시작값이라면 카운트 추가
		}
		System.out.println(cnt);
	}

}

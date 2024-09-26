package study0919;
import java.io.*;
import java.util.*;
/*
주경이가 반드시 걸린다 -> K-1번째에 무조건 희현이 턴이 와야한다?
첫줄 -> 테케, 둘째줄 -> 사람 수 && 주경이 번호
첫 추측 : 중복조합으로 K-1
첫 추측 틀린점 : 한 번에 한명만 지목이 가능한 것 같다 -> 테케만 봐도 한번에 한명만 될거같이 생겼다
두 번째 추측 : 이미 한번 지목당한사람을 방문배열형태로 처리해서 숫자를 센다
배열에 지명한 순서를 넣고 방문하면서 방문처리랑 배열 내 값이 N인지 비교한다
아니라면 인덱스랑 카운트를 하나씩 늘려본다

 */
public class p11558 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[] map = new int[n+1]; //번호니깐 패딩
            boolean[] isVisit = new boolean[n+1]; //이것도 패딩
            for(int j=1;j<=n;j++){
                map[j] = Integer.parseInt(br.readLine().trim());
            }
            int curVal = 1; // 이게 다음 지목받을 사람의 값을 저장할 변수
            int cnt =0; // 이건 턴수
            while(!isVisit[curVal] && curVal != n){ // 지금 지목을 안당해봤고 지금 값이 N이 아니라면?
                isVisit[curVal] = true;
                curVal = map[curVal]; // 다음 지목한 사람으로 값 덮어씌우기
                cnt++;
            }
            //루프를 빠져나왔다는건 N이거나 끝까지 돌려봤는데 도저히 만들 수 없는 경우다
            if(curVal == n){
                System.out.println(cnt);
            }else{
                System.out.println(0);
            }
        }
    }
}

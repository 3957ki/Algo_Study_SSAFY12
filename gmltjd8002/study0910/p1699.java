import java.io.*;
import java.util.*;
/*
swea 제곱수 놀이랑 비슷한거 같음
입력된 수와 가장 가까운 제곱 수 찾기(1씩 빼보면서)
그다음 제곱수 나오면 바로 루트 씌우기 -> 그리디
샘플 테케는 다 맞는데 1%에서 틀렸다고 나옴 -> 로직이 틀렸다?
->dp
 */
public class p1699 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int cnt =0;
		while(true) {
			if(Math.sqrt(t) % 1 ==0) { // 제곱수라면
				cnt++;
				break;
			}else{
                int leastMax = 0;
                for(int i=1;i<=350;i++){ // 대략 350^2이 10만을 넘는다
                    if(i*i < t){
                        leastMax = Math.max(leastMax, i*i);
                    }
                }
                t -= leastMax;
                cnt++;
            }
		}
		System.out.println(cnt);
	}

}
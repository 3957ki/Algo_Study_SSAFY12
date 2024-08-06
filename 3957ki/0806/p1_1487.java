import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1_1487 {
	static int answerSum = 0;
    static int answer = 0;
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2];
        for(int i = 1; i <= N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
//        	원하는 가격
        	arr[i][0] = Integer.parseInt(st.nextToken());
//        	배송비
        	arr[i][1] = Integer.parseInt(st.nextToken());
        }
//      원하는 가격을 기준으로 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> o1[0]-o2[0]);
//      탐색 시작
        DFS(1, arr[1][0]);
        System.out.println(answer);
    }
    static void DFS(int start, int price) {
//    	얻는 이익의 합
    	int sum = 0;
    	for(int i = start; i <= N; i++) {
//    		원하는 가격보다 현재 가격이 작거나 같고, 현재 가격이 배송비보다 클 때
    		if(arr[i][0] >= price && price > arr[i][1]) {
//    			얻는 이익 증가
    			sum += (price - arr[i][1]);
    		}
    	}
//    	현재 얻는 이익의 합이 최댓값이라면 갱신 후, 현재 가격으로 책정
    	if(answerSum < sum) {
    		answerSum = sum;
    		answer = price;
    	}
//    	마지막 사람이 원하는 값까지 탐색했다면 종료
    	if(start == N) return;
//    	다음 사람이 원하는 값으로 가격 올려서 재귀
    	DFS(start+1, arr[start+1][0]);
    }
}

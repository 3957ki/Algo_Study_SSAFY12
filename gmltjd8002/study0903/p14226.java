import java.io.*;
/*
임티를 S개 보낸다
지금 임티를 하나 입력해놓은 상태이다
1. 화면의 모든 임티를 복사해 클립보드에 저장(스택처럼)
2. 저장되어있던 임티를 붙여넣기
3. 삭제
각 연산들 모두 1초
임티를 복사하면 이전건 지워진다
임티가 비어있으면 붙여넣기가 안된다
붙여넣을때 임티 개수가 화면에 나온다
테케1 -> 초기 -> 연산1 -> 연산2 하면 2초
테케2 -> 초기 -> 연산1 -> 연산2 -> 연산1 -> 연산2 하면 4초
swea 제곱근 뭐시기랑 비슷할거같기도하고
 */
public class p14226 {
    static int S,clipBoard,delete;
    static int init,cnt,cur, callCnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        S = Integer.parseInt(br.readLine());
        clipBoard =0; // 현재 저장된 임티 수(스택처럼 쓸듯)
        delete = -1; // 취소
        init = 1; // 시작값
        cnt = 0; // 연산횟수
        cur = 0; // 현재 값
        callCnt = Integer.MAX_VALUE;
        calculate(1);
        System.out.println(cnt);
    }
    static void calculate(int x){
        if(x == S){ // 현재값이 S랑 같다면
            //기존의 최소값이랑 비교해서 갱신이 가능하면 갱신하는 코드
            return;
        }

        if(x * 2 <= S){
            clipBoard += x; // 클립보드에 현상태 저장
            cnt++; //저장할 때 1초

            cnt++; //복붙
            x += clipBoard;
        }else if(x * 2 > S){
            x += (x - S);
        }
        calculate(x);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        //계산한 압축 문자열을 push할 때는 "+"도 함께 push(기존 문자열과 계산된 길이 값을 구분하기 위해)
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (!s.equals(")")) {   //")"가 아니면
                stack.push(s);      //스택에 쌓기
            } else {                //")"이면
                int cnt = 0;
                while (!stack.peek().equals("(")) {     //"("를 만나기 전까지
                    String topStr = stack.pop();        //스택에서 뽑으면서
                    if (topStr.equals("+")) {           //스택에서 뽑은 게 "+"이면
                        int len = Integer.parseInt(stack.pop());    //다음 pop되는 값은 계산된 값이므로 cnt에 추가
                        cnt += len;
                    } else cnt++;                       //그냥 입력 문자열이라면 cnt 1 늘리기
                }
                stack.pop(); // "(" 제거
                int k = Integer.parseInt(stack.pop());  //몇 번 압축 됐는지 계산할 값
                cnt = cnt * k;
                stack.push(String.valueOf(cnt));    //계산된 값을 push해주고 "+"도 push
                stack.push("+");
            }
        }
        int answer = 0;
        while (!stack.empty()) {
            if (stack.peek().equals("+")) {
                stack.pop();    //"+" 제거
                answer += Integer.parseInt(stack.pop());    //계산된 값 더하기
            } else {
                stack.pop();
                answer++;   //그냥 입력 문자열
            }
        }
        System.out.println(answer);
    }
}
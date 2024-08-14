package study0806;
import java.io.*;
import java.util.*;

public class p5107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; ; tc++) {
            int n = Integer.parseInt(br.readLine()); //테케 값 받기 || EOF 처리
            if (n == 0) break;  // 입력의 끝

            int cnt = 0; // 사이클 개수
            HashMap<String, String> map = new HashMap<>(); // 이름 받을 해시맵
            List<String>names = new ArrayList<>(); // 앞사람 이름 저장할 배열

            for (int i = 0; i < n; i++) { 
                st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();
                map.put(first, second); // 맵에 입력
                names.add(first); // 앞에 친구 이름
            }

            for (String start : names) { // 앞 친구들 순회
                if (!map.containsKey(start)) continue;
                String name = start;
                Set<String> isVisit = new HashSet<>(); // 마니또 지정한 적 있는지 set으로 체크
                while (true) {
                    isVisit.add(name); // 마니또 지정
                    name = map.get(name); //name에 해당하는 value 리턴
                    if (name == null || !map.containsKey(name)) { // 더 지정할 애가 없다면
                        break;
                    }
                    if (name.equals(start)) { // 처음 지정한 애면
                        cnt++;
                        for (String checkedName : isVisit) {
                            map.remove(checkedName); // 사이클에 있던 애들 이름 다 제거
                        }
                        break;
                    }
                }
            }
            System.out.println(tc + " " + cnt); // 출력
        }
    }
}
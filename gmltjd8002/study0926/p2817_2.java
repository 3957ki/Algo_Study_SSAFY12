import java.io.*;
import java.util.*;

public class p2817_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 입력
        int voteCnt = Integer.parseInt(br.readLine().trim());
        int candidateCnt = Integer.parseInt(br.readLine());
        
        // 득표수,이름
        int[] votes = new int[candidateCnt];
        String[] names = new String[candidateCnt];
        
        // 입력 받기
        for (int i = 0; i < candidateCnt; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            votes[i] = Integer.parseInt(st.nextToken());
        }

        // 토큰
        int[] tokens = new int[candidateCnt];
        
        // pq에 클래스를 받아 정렬하기
        PriorityQueue<Candidate> pq = new PriorityQueue<>();

        // 5% 이상 득표한 후보만 pq에 오퍼
        for (int i = 0; i < candidateCnt; i++) {
            if (votes[i] >= voteCnt * 0.05) {
                pq.offer(new Candidate(i, votes[i], 1));
            }
        }

        // 토큰 분배
        for (int i = 0; i < 14; i++) {
            if (pq.isEmpty()) break;
            Candidate tmp = pq.poll();  // pq니 가장 높다
            tokens[tmp.idx]++;  // 토큰 주기
            // 토큰을 받은 후보를 다시 큐에 넣되, divideVal을 1 증가시켜 오퍼
            pq.offer(new Candidate(tmp.idx, tmp.votes, tmp.divideVal + 1));
        }

        // 결과를 저장할 리스트 생성
        List<Candidate> result = new ArrayList<>();
        for (int i = 0; i < candidateCnt; i++) {
            if (votes[i] >= voteCnt * 0.05) {
                result.add(new Candidate(i, votes[i], tokens[i]));
            }
        }

        // 사전순 정렬
        result.sort((a, b) -> names[a.idx].compareTo(names[b.idx]));

        // 결과
        for (Candidate candidate : result) {
            System.out.println(names[candidate.idx] + " " + candidate.divideVal);
        }
    }

    // 후보자 정보 저장 && 비교까지
    static class Candidate implements Comparable<Candidate> {
        int idx;  // 후보자 인덱스
        int votes;  // 득표 수
        int divideVal;  // 토큰 수 또는 나눌 값

        public Candidate(int idx, int votes, int divideVal) {
            this.idx = idx;
            this.votes = votes;
            this.divideVal = divideVal;
        }

        @Override
        public int compareTo(Candidate o) {
            // priority -> 현재수로 나눈 몫이 가장 큰애
            double cur_score = (double) this.votes / this.divideVal;
            double o_score = (double) o.votes / o.divideVal;
            return Double.compare(o_score, cur_score);
        }
    }
}
import java.io.*;
import java.util.*;

public class p2817 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int voteCnt = Integer.parseInt(br.readLine().trim());
        int candidateCnt = Integer.parseInt(br.readLine());
        int[] votes = new int[candidateCnt];
        String[] names = new String[candidateCnt];
        for(int i=0;i<candidateCnt;i++){
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            votes[i] = Integer.parseInt(st.nextToken());
        }

        int[] tokens = new int[candidateCnt]; // 최종적으로 받을 토큰 수 저장
        PriorityQueue<Candidate> pq = new PriorityQueue<>(); //pq로 스탶 관리

        for(int i=0;i<candidateCnt;i++){
            if(votes[i] >=voteCnt*0.05){ // 조건 만족시에만 pq에 오퍼
                pq.offer(new Candidate(i,votes[i],1));
            }
        }

        for(int i=0;i<14;i++){
            if(pq.isEmpty()) break;
            Candidate tmp = pq.poll(); // 현재 가장 우선순위로 정렬되어있다
            tokens[tmp.idx]++; // 해당 후보에게 토큰을 준다
            //divideVal값을 1 증가시킨 다음 이전에 토큰을 받은 후보와 다음 후보 비교
            pq.offer(new Candidate(tmp.idx, tmp.votes, tmp.idx++));
        }
        
        for(int i=0;i<candidateCnt;i++){
            if(votes[i] >= voteCnt*0.05){
                System.out.println(names[i] + " " + tokens[i]);
            }
        }
        List<int[]> candList = new ArrayList<>();
        for(int i=0;i<candidateCnt;i++){
            if(votes[i] >= voteCnt*0.05){
                candList.add(new int[]{i,tokens[i]});
            }
        }
        candList.sort((a,b) -> names[a[0]].compareTo(names[b[0]]));
        for(int[] candidate : candList){
            System.out.println(names[candidate[0]] + " " + candidate[1]);
        }
    }
    static class Candidate implements Comparable<Candidate>{
        int idx; // 후보 인덱스
        int votes; // 후보 득표수
        int divideVal; // 나눌 수
        public Candidate(int idx, int votes, int divideVal){
            // TODO Auto-generated method stub
            this.idx = idx;
            this.votes = votes;
            this.divideVal = divideVal;
        }
        @Override
        public int compareTo(Candidate o) { // -> 득표수를 나눈값이 큰 순으로 정렬
            // TODO Auto-generated method stub
            int cur_score =  this.votes / this.divideVal; // 나눈값 저장
            int o_score = o.votes / o.divideVal;
            if(cur_score != o_score){
                return Integer.compare(o_score, cur_score);
            }
            if(this.votes != o.votes){
                return Integer.compare(o.votes, this.votes);
            }
            return Integer.compare(this.idx, o.idx);
        }
    }
}
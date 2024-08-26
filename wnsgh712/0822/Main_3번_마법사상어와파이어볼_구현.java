package src.study0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

/*
4 2 1
1 1 5 2 2
1 4 7 1 6
* */
public class Main_3번_마법사상어와파이어볼_구현 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K;
    static Map<P, List<F>> fBalls;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        fBalls = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            List<F> li = new ArrayList<>();
            P p = new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            li.add(new F(p, m, d, s));
            fBalls.put(p, li);
        }

        for (int k = 0; k < K; k++) {
            // 맵안의 모든 파이어볼에 대해서
        	Iterator<List<F>> iter = fBalls.values().iterator();
            while(iter.hasNext()) {
            	List<F> l = iter.next();
                for (int i = 0; i < l.size(); i++) {
                    F fBall = l.remove(i);

                    if (fBall.isMoved) continue;
                    P p = fBall.move();
                    if (fBalls.get(p) != null) {
                    	fBalls.get(p).add(fBall);	
                    } else {
                    	fBalls.put(p, new ArrayList<>());
                    }
                    
                    fBall.isMoved = true;
                }
            }

            // 이동이 끝난 뒤 2개 이상인 리스트를 찾기
            for (P p: fBalls.keySet()) {
                List<F> li = fBalls.get(p);
                if (li.size() >= 2) {
                    divide(li);
                }
            }
        }
        int answer = 0;
        for (List<F> l : fBalls.values()) {
        	for (int i = 0; i < l.size(); i++) {
				answer += l.get(i).m;
			}
        }
        System.out.println(answer);
    }

    private static void divide(List<F> list) {
        //같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
        int mSum = 0;
        int dSum = 0;
        int sSum = 0;
        int fCnt = list.size();
        P p = null;
        boolean dirFlag = true;
        int dir = list.get(0).d % 2; // true = 홀수
        for (int i = 0; i < fCnt; i++) {
            F f = list.remove(0);
            p = f.p;
            mSum += f.m;
            sSum += f.s;
            dSum += f.d;
            if (dir != f.d % 2) {
            	dirFlag = false;
            }
        }
        //질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
        int m = (int) (double) mSum / 5;
        //속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
        int s = (int) (double) sSum / 5;
        //질량이 0인 파이어볼은 소멸되어 없어진다.
        if (m == 0) return;
        
        List<F> li = new ArrayList<>();
        //파이어볼은 4개의 파이어볼로 나누어진다.
        for (int i = 0; i < 8; i+=2) {
        	//합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
        	if (dirFlag) {
        		li.add(new F(p, m, i, s));
        	} else {
        		li.add(new F(p, m, i+1, s));
        	}	
		}
        
        list = li;
    }


    static class P {
        int x, y;
        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            P p = (P) object;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

		@Override
		public String toString() {
			return "x=" + x + ", y=" + y;
		}
        
    }

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static class F {
        P p;
        int m, d, s;
        boolean isMoved;
        public F(P p, int m, int d, int s) {
            this.p = p;
            this.m = m;
            this.d = d;
            this.s = s;
            this.isMoved = false;
        }
        public P move() {
            // 이동하려는 방향이 좌표계보다 큰경우 열 또는 형의 반대편으로 다시 이동시켜주기
            int nx = (p.x + dx[d] * s) % N;
            int ny = (p.x + dx[d] * s) % N;
            if (nx < 0) {
                nx += N;
            }
            if (ny < 0) {
                ny += N;
            }
            return new P(nx, ny);
        }
		@Override
		public String toString() {
			return "p=" + p + ", m=" + m + ", d=" + d + ", s=" + s + ", isMoved=" + isMoved;
		}
        
    }
}

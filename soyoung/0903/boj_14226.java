import java.util.*;
import java.io.*;

public class boj_14226 {
    static Queue<Node> q = new LinkedList<>();
    static boolean[][] visited = new boolean[2000][2000];
    static int S;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = Integer.parseInt(br.readLine());

        bfs(new Node(1, 0, 0));

    }
    static void bfs(Node node){

        q.add(node);
        visited[node.cur][node.clipboard] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            //복사
            if(!visited[now.cur][now.cur]){
                visited[now.cur][now.cur] = true;
                q.offer(new Node(now.cur, now.cur, now.time+1));
            }

            //붙여넣기
            if(now.clipboard+now.cur == S){
                System.out.println(now.time+1);
                return;
            }
            if(now.cur+now.clipboard<=1000 && !visited[now.cur+now.clipboard][now.clipboard]){
                visited[now.cur+now.clipboard][now.clipboard] = true;
                q.offer(new Node(now.cur+now.clipboard, now.clipboard, now.time+1));
            }

            //삭제
            if(now.cur-1 == S){
                System.out.println(now.time+1);
                return;
            }
            if(now.cur-1>=0 && !visited[now.cur-1][now.clipboard]){
                visited[now.cur-1][now.clipboard] = true;
                q.offer(new Node(now.cur-1, now.clipboard, now.time+1));
            }
        }
    }
}
class Node{
    int cur, clipboard, time;
    Node(int cur, int clipboard, int time){
        this.cur = cur;
        this.clipboard = clipboard;
        this.time = time;
    }
}

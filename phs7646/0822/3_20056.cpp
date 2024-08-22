#include<iostream>
#include<vector>
#include<queue>
using namespace std;
typedef pair<int,int> pp;
pp moves[] = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

typedef class {
public:
    int sum_m;
    int sum_v;
    int sum_n;
    int sum_dir; //-1 : none, 0 : all even , 1 : all odd, 2 : mixed
    int _dir; 
     
}cell;

typedef class fireball{
public:
    int i;
    int j;
    int m;
    int s; //0..7
    int d;
    fireball(int _a, int _b, int _c, int _d, int _e) : 
        i(_a),j(_b),m(_c),s(_d),d(_e) {};
} fireball;

cell map[50][50];


void initMap(int N) {
    for(int i = 0;i < N;i++) {
        for(int j = 0;j < N;j++) {
            map[i][j].sum_m = 0;
            map[i][j].sum_v = 0;
            map[i][j].sum_n = 0;
            map[i][j].sum_dir = -1;
            //map[i][j]._dir = 0; //no need
        }
    }
}

int main() {
    int N,M,K;
    cin >> N >> M >> K;
    int padding = (1000/N + 1) * N;
    //input
    queue<fireball> q;
    for(int i = 0;i < M;i++) {
        int a,b,c,d,e;
        cin >> a >> b >> c >> d >> e;
        q.emplace(a,b,c,d,e);
    }

    //logic
    for(int i = 0;i < K;i++) {
        //initialize map
        initMap(N);
        //move and mix
        while(!q.empty()) {
            fireball f = q.front(); q.pop();
            //move ball
            int y = (f.i + f.s * moves[f.d].first + padding)%N;
            int x = (f.j + f.s * moves[f.d].second + padding)%N;
            //load ball to map
            map[y][x].sum_m += f.m;
            map[y][x].sum_n++;
            map[y][x].sum_v += f.s;
            map[y][x]._dir = f.d; //for one ball case
            //decide direction
            if(f.d % 2 == 0) {
                //0 or 2 : no touch
                if(map[y][x].sum_dir == -1) map[y][x].sum_dir = 0;
                else if(map[y][x].sum_dir == 1) map[y][x].sum_dir = 2;
            } else {
                //1 or 2 : no touch
                if(map[y][x].sum_dir == -1) map[y][x].sum_dir = 1;
                else if(map[y][x].sum_dir == 0) map[y][x].sum_dir = 2;
            }
        }
        //divide fire ball
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < N;j++) {
                //if only fireball
                if(map[i][j].sum_n == 1) {
                    //just add
                    q.emplace(i,j,map[i][j].sum_m,map[i][j].sum_v,map[i][j]._dir);
                    continue;
                }

                int m = map[i][j].sum_m / 5;
                if(m == 0) continue;
                int s = map[i][j].sum_v / map[i][j].sum_n;
                if(map[i][j].sum_dir == 2) {
                    //1,3,5,7
                    q.emplace(i,j,m,s,1);
                    q.emplace(i,j,m,s,3);
                    q.emplace(i,j,m,s,5);
                    q.emplace(i,j,m,s,7);
                } else {
                    //0,2,4,6
                    q.emplace(i,j,m,s,0);
                    q.emplace(i,j,m,s,2);
                    q.emplace(i,j,m,s,4);
                    q.emplace(i,j,m,s,6);
                }
            }
        }
    }
    //end
    int answer = 0;
    while(!q.empty()) {
        fireball f = q.front(); q.pop();
        answer += f.m;
    }

    cout << answer;

    return 0;
}
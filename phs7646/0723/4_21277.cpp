#include<iostream>
#include<vector>
#include<climits>
using namespace std;

const int OFFSET = 50;
bool base[150][150];

vector<vector<bool>> rotate(const vector<vector<bool>>& origin) {
    int N = origin.size();
    int M = origin[0].size();
    vector<vector<bool>> ret(M, vector<bool>(N));
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            ret[j][N - i - 1] = origin[i][j];
        }
    }
    return ret;
}

int main() {
    int N1, M1;
    cin >> N1 >> M1;
    for(int i = 0; i < N1; i++) {
        for(int j = 0; j < M1; j++) {
            char a; cin >> a;
            if(a == '1') base[OFFSET + i][OFFSET + j] = true;
        }
    }

    int N2, M2;
    cin >> N2 >> M2;
    vector<vector<bool>> piece(N2, vector<bool>(M2));
    for(int i = 0; i < N2; i++) {
        for(int j = 0; j < M2; j++) {
            char a; cin >> a;
            if(a == '1') piece[i][j] = true;
        }
    }

    int answer = INT_MAX;
    for(int rot = 0; rot < 4; rot++) {
        //현재 piece를 base에 꽂아보자
        for(int a = OFFSET - N2; a <= OFFSET + N1; a++) {
            for(int b = OFFSET - M2; b <= OFFSET + M1; b++) {
                //piece를 a,b에 배치시키기
                bool canPlace = true;
                for(int i = 0; i < N2; i++) {
                    for(int j = 0; j < M2; j++) {
                        if(piece[i][j] && base[a + i][b + j]) {
                            canPlace = false;
                            break;
                        }
                    }
                    if(!canPlace)break;
                }
                if(canPlace) {
                    //현재 상태에서 필요한 비용 계산
                    int minHeight = min(OFFSET, a);
                    int maxHeight = max(OFFSET + N1, a + N2);
                    int minWidth = min(OFFSET, b);
                    int maxWidth = max(OFFSET + M1, b + M2);
                    int height = maxHeight - minHeight;
                    int width = maxWidth - minWidth;
                    answer = min(answer, height * width);
                }
            }
        }
        piece = rotate(piece);
        swap(N2, M2);
    }
    cout << answer;
    return 0;
}

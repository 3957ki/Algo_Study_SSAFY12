#include<iostream>
#include<set>
#include<vector>
#include<algorithm>
#include<iomanip>

using namespace std;

int N,M,R;
int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    cin >> N >> M >> R;
    R<<=1; //사각형이라고 생각하자..
    //삼각형 말뚝2개 사이 길이 * 깃대 길이

    //말뚝사이의 길이를 treeSet에 모으기
    set<int> len1;
    vector<int> coords;
    for(int i = 0;i < N;i++) {
        int x; cin >> x;
        for(int a : coords) len1.emplace(abs(x-a));
        coords.emplace_back(x);
    }

    //깃대의 길이를 vector로 받아서 정렬
    vector<int> len2(M);
    for(int i = 0;i < M;i++) cin >> len2[i];
    sort(len2.begin(),len2.end());

    int answer = -1;
    for(int l1 : len1) {
        int rem = R / l1; //최대 rem길이 까지 고를 수 있음
        auto it = lower_bound(len2.begin(),len2.end(),rem);
        if(*it == rem) answer = max(answer,l1*rem);
        else if(it != len2.begin()) {
            answer = max(answer,l1* *(it-1));
        }
    }
    if(answer == -1) cout << answer;
    else {
        cout << fixed << setprecision(1) << (double)answer / 2;
    }

    
    return 0;
}
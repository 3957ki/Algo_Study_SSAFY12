#include<iostream>

using namespace std;

int A[50];
int B[50];
int main() {
    int N; cin >> N;
    for(int i = 0;i < N;i++) cin >> A[i] >> B[i];
    int answer = 0;
    int answer_val = 0;
    for(int price = 1;price <= 1000000;price++) {
        int total = 0;
        for(int j = 0;j < N;j++) {
            if(price <= A[j] && price > B[j]) {
                total += price-B[j];
            }
        }
        if(answer < total) {
            answer = total;
            answer_val = price;
        }
    }
    cout << answer_val;
    return 0;
}
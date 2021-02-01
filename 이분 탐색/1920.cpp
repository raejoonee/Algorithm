#include <iostream>
#include <vector>
#include <string>

using namespace std;

bool find(vector<int> N, int b){
        for (int i = 0; i < N.size(); i++) {
                if (b == N[i]) return true;
        }
        return false;
}

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0); int N, M;
        cin >> N;
        vector<int> A;
        for (int i = 0; i < N; i++){
                int a; cin >> a;
                A.push_back(a);
        }
        cin >> M;
        vector<int> B;
        for (int i = 0; i < M; i++){
                int b; cin >> b;
                B.push_back(b);
        }
        for (int i = 0; i < M; i++){
                cout << find(A, B[i]) << '\n';
        }
        return 0;
}
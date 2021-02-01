#include <iostream>

using namespace std;

int dp(int N, int M){
        if (N == 1){
                return M-1;
        }
        if (N > M){
                return dp(M, N);
        }
        return (N-1)+dp(1, M)*N;
}

int main(){
        int N, M;
        cin >> N >> M;
        cout << dp(N,M) << endl;
        return 0;
}
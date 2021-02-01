#include <iostream>
#include <vector>
#include <string>

using namespace std;

int cal(int n){
        int ans = n;
        while(n/10){
                ans+=n%10;
                n/=10;
        }
        ans+=n%10;
        return ans;
}

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        int N; cin >> N;
        for (int i = 1; i < N; i++){
                if (cal(i) == N){
                        cout << i;
                        return 0;
                }
        }
        cout << 0;
        return 0;
}
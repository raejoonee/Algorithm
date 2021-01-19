#include <iostream>
#include <math.h>
#include <limits.h>

using namespace std;

int N;
int dp[1000001];
int a,b,c;

int main(){
        cin >> N;
        dp[1] = 0;
        for (int i = 2; i<=N; i++){
                a=INT_MAX;
                b=INT_MAX;
                if (i % 2 == 0) a = 1+dp[i/2];
                if (i % 3 == 0) b = 1+dp[i/3];
                c = 1+dp[i-1];
                dp[i] = min(min(a,b),c);
        }
        cout << dp[N] <<'\n';
        return 0;
}